package com.example.networkmeup.view.EditAccountEmployerTest;

import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;
import com.example.networkmeup.view.EditAccountEmployer.EditAccountEmployerPresenter;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class EditAccountEmployerPresenterTest {

    private EditAccountEmployerPresenter presenter;
    private EditAccountEmployerViewStub viewStub;

    @Before
    public void setUp() {
        new MemoryInitializer().prepareData();
        viewStub = new EditAccountEmployerViewStub();
        presenter = new EditAccountEmployerPresenter("b.be@northfreedom.com", viewStub);
    }

    @Test
    public void testSave_AllFieldsValid() {
        // Simulate valid input in the fields
        viewStub.setCompanyNameField("");
        viewStub.setSectorField("");
        viewStub.setEmailField("b.be@northfreedom.com");
        viewStub.setPhoneField("5693311692");
        viewStub.setPasswordField("UwL[;3{[fQP:");
        viewStub.setTinField("000001010");

        presenter.Save();

        // Assert that no error messages were shown (fields are valid)
        Assert.assertNull(viewStub.getShowErrorMessageMsg());
        Assert.assertNull(viewStub.getShowErrorMessageTitle());

        // Assert that employer information is updated properly when all fields are valid
        Employer updatedEmployer = viewStub.getCurrEmployer();
        String companyname = updatedEmployer.getCompanyName();
        String sector = updatedEmployer.getSector();
        Email email = updatedEmployer.getEmail();
        Phone phone = updatedEmployer.getPhone();
        Password password = updatedEmployer.getPassword();
        TIN tin = updatedEmployer.getTin();

        Assert.assertEquals("", companyname);
        Assert.assertEquals("", sector);
        Assert.assertEquals("b.be@northfreedom.com", email.getAddress());
        Assert.assertEquals("5693311692", phone.getNumber());
        Assert.assertEquals("UwL[;3{[fQP:", password.getPassword());
        Assert.assertEquals("000001010", tin.getTin());
    }

    @Test
    public void testSave_InvalidEmail() {
        // Simulate invalid email input
        viewStub.setCompanyNameField("");
        viewStub.setSectorField("");
        viewStub.setEmailField("invalid_email");
        viewStub.setPhoneField("5693311692");
        viewStub.setPasswordField("UwL[;3{[fQP:");
        viewStub.setTinField("000001010");

        presenter.Save();

        // Assert that an error message for email validation is shown
        Assert.assertEquals("Invalid email address.", viewStub.getShowErrorMessageMsg());
    }

    // Add more test methods to cover scenarios for invalid phone, password, TIN, etc.
    @Test
    public void testSave_InvalidPhone() {
        // Simulate invalid email input
        viewStub.setCompanyNameField("");
        viewStub.setSectorField("");
        viewStub.setEmailField("b.be@northfreedom.com");
        viewStub.setPhoneField("123");
        viewStub.setPasswordField("UwL[;3{[fQP:");
        viewStub.setTinField("000001010");

        presenter.Save();

        // Assert that an error message for password validation is shown
        Assert.assertEquals("Invalid phone number.", viewStub.getShowErrorMessageMsg());

    }

    @Test
    public void testSave_PasswordFieldError() {
        // Simulate invalid password input
        viewStub.setCompanyNameField("");
        viewStub.setSectorField("");
        viewStub.setEmailField("b.be@northfreedom.com");
        viewStub.setPhoneField("5693311692");
        viewStub.setPasswordField("pass");
        viewStub.setTinField("000001010");

        presenter.Save();

        // Assert that an error message for password validation is shown
        Assert.assertEquals("Password is not strong enough.", viewStub.getShowErrorMessageMsg());

    }

    @Test
    public void testSave_TINFieldError() {
        // Simulate invalid password input
        viewStub.setCompanyNameField("");
        viewStub.setSectorField("");
        viewStub.setEmailField("b.be@northfreedom.com");
        viewStub.setPhoneField("5693311692");
        viewStub.setPasswordField("UwL[;3{[fQP:");
        viewStub.setTinField("sad");

        presenter.Save();

        // Assert that an error message for password validation is shown
        Assert.assertEquals("Invalid TIN.", viewStub.getShowErrorMessageMsg());

    }

    @Test
    public void testOnDelete() {
        presenter.Delete();
        Assert.assertEquals(0, new EmployerDAOMemory().getAll().size());
    }
}
