package com.example.networkmeup.view.LoginTest.LoginEmployeeTest;

import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.view.Login.LoginEmployee.LoginEmployeePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains test cases for the LoginEmployeePresenter class.
 * It tests the functionality of employee login scenarios.
 */
public class LoginEmployeePresenterTest {
    private LoginEmployeePresenter presenter;
    private LoginEmployeeViewStub view;
    private Initializer dataInitializer;

    /**
     * Sets up necessary objects and data before each test case.
     */
    @Before
    public void setup() {
        dataInitializer = new MemoryInitializer();
        dataInitializer.prepareData(); // Prepare initial data for testing
        view = new LoginEmployeeViewStub(); // Create a stub view for testing
    }

    /**
     * Tests the process of logging in with various scenarios.
     */
    @Test
    public void testLoginProcess() {
        presenter = new LoginEmployeePresenter(view, new EmployeeDAOMemory());

        // Test various scenarios for logging in

        // Testing scenario where both email and password are valid
        // incorrect credentials
        view.setEmailField("john.Brown12@gmail.com");
        view.setPasswordField("Test1234!");
        presenter.onLogin();
        Assert.assertEquals("Login Error", view.getShowErrorMessageTitle());
        Assert.assertEquals("Invalid credentials!", view.getShowErrorMessageMsg());

        // Testing scenario where both email and password are valid
        // correct credentials
        view.setEmailField("john.Brown12@gmail.com");
        view.setPasswordField("JohnBrown!12");
        presenter.onLogin();
        Assert.assertEquals("john.Brown12@gmail.com", view.getSuccessfullyFinishLoginToken());

        // Testing scenario where email is empty
        view.setEmailField("");
        view.setPasswordField("Test1234!");
        presenter.onLogin();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Invalid email address.", view.getShowErrorMessageMsg());

        // Testing scenario where password is empty
        view.setEmailField("john.doe@example.com");
        view.setPasswordField("");
        presenter.onLogin();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Password is not strong enough.", view.getShowErrorMessageMsg());

        // Testing scenario where email is invalid
        view.setEmailField("invalid.email");
        view.setPasswordField("Test1234!");
        presenter.onLogin();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Invalid email address.", view.getShowErrorMessageMsg());

        // Testing scenario where password is invalid
        view.setEmailField("john.doe@example.com");
        view.setPasswordField("weak");
        presenter.onLogin();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Password is not strong enough.", view.getShowErrorMessageMsg());

        // Testing scenario where both email and password are invalid
        view.setEmailField("invalid.email");
        view.setPasswordField("weak");
        presenter.onLogin();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Password is not strong enough.", view.getShowErrorMessageMsg());

    }
}

