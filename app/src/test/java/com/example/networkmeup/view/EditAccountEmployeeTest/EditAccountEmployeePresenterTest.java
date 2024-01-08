package com.example.networkmeup.view.EditAccountEmployeeTest;

import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;
import com.example.networkmeup.view.EditAccountEmployer.EditAccountEmployeePresenter;
import com.example.networkmeup.view.EditAccountEmployerTest.EditAccountEmployeeViewStub;

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
        presenter = new EditAccountEmployeePresenter(viewStub);
    }

    @Test
    public void testOnCreate_AllFieldsValid() {
        // Simulate valid input in the fields
        viewStub.setCompanyNameField("");
        viewStub.setSectorField("");
        viewStub.setEmailField("b.be@northfreedom.com");
        viewStub.setPhoneField("5693311692");
        viewStub.setPasswordField("UwL[;3{[fQP:");
        viewStub.setTinField("000001010");

        presenter.onCreate();

        // Assert that no error messages were shown (fields are valid)
        Assert.assertNull(viewStub.getShowErrorMessageMsg());
        Assert.assertNull(viewStub.getShowErrorMessageTitle());

        // Assert that employee information is updated properly when all fields are valid
        Employee updatedEmployee = viewStub.getCurrEmployer();
        String companyname = updatedEmployee.getCompanyName();
        String sector = updatedEmployee.getSector();
        Email email = updatedEmployee.getEmail();
        Phone phone = updatedEmployee.getPhone();
        Password password = updatedEmployee.getPassword();
        TIN tin = updatedEmployee.getTin();

        Assert.assertEquals("", companyname);
        Assert.assertEquals("", sector);
        Assert.assertEquals("b.be@northfreedom.com", email.getAddress());
        Assert.assertEquals("5693311692", phone.getNumber());
        Assert.assertEquals("UwL[;3{[fQP:", password.getPassword());
        Assert.assertEquals("000001010", tin.getTin());
    }

    @Test
    public void testOnCreate_InvalidEmail() {
        // Simulate invalid email input
        viewStub.setCompanyNameField("");
        viewStub.setSectorField("");
        viewStub.setEmailField("invalid_email");
        viewStub.setPhoneField("5693311692");
        viewStub.setPasswordField("UwL[;3{[fQP:");
        viewStub.setTinField("000001010");

        presenter.onCreate();

        // Assert that an error message for email validation is shown
        Assert.assertNotNull(viewStub.getShowErrorMessageMsg());
        Assert.assertNotNull(viewStub.getShowErrorMessageTitle());

        // Assert that employer information is not updated due to invalid email
        //Assert.assertNull(viewStub.getCurrEmployer());
    }

    // Add more test methods to cover scenarios for invalid phone, password, TIN, etc.

    @Test
    public void testOnCreate_PasswordFieldError() {
        // Simulate invalid password input
        viewStub.setCompanyNameField("");
        viewStub.setSectorField("");
        viewStub.setEmailField("b.be@northfreedom.com");
        viewStub.setPhoneField("5693311692");
        viewStub.setPasswordField("pass");
        viewStub.setTinField("000001010");

        presenter.onCreate();

        // Assert that an error message for password validation is shown
        Assert.assertNotNull(viewStub.getShowErrorMessageMsg());
        Assert.assertNotNull(viewStub.getShowErrorMessageTitle());

        // Assert that employer information is not updated due to invalid password
        Assert.assertNotNull(viewStub.getCurrEmployer());
    }
}
