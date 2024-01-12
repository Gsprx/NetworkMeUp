package com.example.networkmeup.view.EditAccountEmployeeTest;

import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.view.EditAccountEmployee.EditAccountEmployeePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EditAccountEmployeePresenterTest {
    private EditAccountEmployeePresenter presenter;
    private EditAccountEmployeeViewStub viewStub;

    @Before
    public void setUp() {
        new MemoryInitializer().prepareData();
        viewStub = new EditAccountEmployeeViewStub();
        presenter = new EditAccountEmployeePresenter(viewStub,"john.Brown12@gmail.com");
    }

    @Test
    public void testSave_AllFieldsValid() {
        // Simulate valid input in the fields
        viewStub.setNameField("");
        viewStub.setAddressField("");
        viewStub.setEmailField("john.Brown12@gmail.com");
        viewStub.setPhoneField("6977264561");
        viewStub.setPasswordField("JohnBrown!12");


        presenter.Save();

        // Assert that no error messages were shown (fields are valid)
        Assert.assertNull(viewStub.getShowErrorMessageMsg());
        Assert.assertNull(viewStub.getShowErrorMessageTitle());

        // Assert that employee information is updated properly when all fields are valid
        Employee updatedEmployee = new EmployeeDAOMemory().getByEmail(new Email("john.Brown12@gmail.com"));
        String name = updatedEmployee.getName();
        String address = updatedEmployee.getAddress();
        Email email = updatedEmployee.getEmail();
        Phone phone = updatedEmployee.getPhone();
        Password password = updatedEmployee.getPassword();

        Assert.assertEquals("", name);
        Assert.assertEquals("", address);
        Assert.assertEquals("john.Brown12@gmail.com", email.getAddress());
        Assert.assertEquals("6977264561", phone.getNumber());
        Assert.assertEquals("JohnBrown!12", password.getPassword());
    }

    @Test
    public void testSave_InvalidEmail() {
        // Simulate invalid email input
        viewStub.setNameField("");
        viewStub.setAddressField("");
        viewStub.setEmailField("invalid_email");
        viewStub.setPhoneField("6977264561");
        viewStub.setPasswordField("JohnBrown!12");

        presenter.Save();

        // Assert that an error message for email validation is shown
        Assert.assertEquals("Invalid email address.", viewStub.getShowErrorMessageMsg());
    }

    // Add more test methods to cover scenarios for invalid phone, password, TIN, etc.
    @Test
    public void testSave_InvalidPhone() {
        // Simulate invalid email input
        viewStub.setNameField("");
        viewStub.setAddressField("");
        viewStub.setEmailField("john.Brown12@gmail.com");
        viewStub.setPhoneField("123");
        viewStub.setPasswordField("JohnBrown!12");

        presenter.Save();

        // Assert that an error message for password validation is shown
        Assert.assertEquals("Invalid phone number.", viewStub.getShowErrorMessageMsg());

    }

    @Test
    public void testSave_PasswordFieldError() {
        // Simulate invalid password input
        viewStub.setNameField("");
        viewStub.setAddressField("");
        viewStub.setEmailField("john.Brown12@gmail.com");
        viewStub.setPhoneField("6977264561");
        viewStub.setPasswordField("pass");

        presenter.Save();

        // Assert that an error message for password validation is shown
        Assert.assertEquals("Password is not strong enough.", viewStub.getShowErrorMessageMsg());

    }

    @Test
    public void testOnDelete() {
        presenter.Delete();
        Assert.assertEquals(1, new EmployeeDAOMemory().getAll().size());
    }

    @Test
    public void checkApplicationArchiveMove(){
        presenter.ApplicationArchive();

        Assert.assertEquals("john.Brown12@gmail.com", viewStub.getLastTokenPassed());
    }

}
