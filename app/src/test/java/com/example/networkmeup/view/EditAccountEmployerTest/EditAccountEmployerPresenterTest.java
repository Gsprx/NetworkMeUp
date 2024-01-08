package com.example.networkmeup.view.EditAccountEmployerTest;

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
        viewStub = new EditAccountEmployerViewStub();
        presenter = new EditAccountEmployerPresenter(viewStub);
    }

    @Test
    public void testOnCreate_AllFieldsValid() {
        // Simulate valid input in the fields
        viewStub.setEmailField("validemail@example.com");
        viewStub.setPhoneField("1234567890");
        viewStub.setPasswordField("password123@");
        viewStub.setTinField("123456789");

        presenter.onCreate();

        // Assert that no error messages were shown (fields are valid)
        Assert.assertNull(viewStub.getShowErrorMessageMsg());
        Assert.assertNull(viewStub.getShowErrorMessageTitle());

        // Assert that employer information is updated properly when all fields are valid
        Employer updatedEmployer = viewStub.getCurrEmployer();
        Email email = updatedEmployer.getEmail();
        Phone phone = updatedEmployer.getPhone();
        Password password = updatedEmployer.getPassword();
        TIN tin = updatedEmployer.getTin();

        Assert.assertEquals("validemail@example.com", email.getAddress());
        Assert.assertEquals("1234567890", phone.getNumber());
        Assert.assertEquals("password123@", password.getPassword());
        Assert.assertEquals("123456789", tin.getTin());
    }

    @Test
    public void testOnCreate_InvalidEmail() {
        // Simulate invalid email input
        viewStub.setEmailField("invalid_email");

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
        viewStub.setPasswordField("pass"); // Invalid password length

        presenter.onCreate();

        // Assert that an error message for password validation is shown
        Assert.assertNotNull(viewStub.getShowErrorMessageMsg());
        Assert.assertNotNull(viewStub.getShowErrorMessageTitle());

        // Assert that employer information is not updated due to invalid password
        //Assert.assertNull(viewStub.getCurrEmployer());
    }
}
