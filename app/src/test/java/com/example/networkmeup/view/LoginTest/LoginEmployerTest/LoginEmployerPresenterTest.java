package com.example.networkmeup.view.LoginTest.LoginEmployerTest;

import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.view.Login.LoginEmployer.LoginEmployerPresenter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginEmployerPresenterTest {

    private LoginEmployerPresenter presenter;
    private LoginEmployerViewStub view;
    private MemoryInitializer dataInitializer;

    @Before
    public void setup() {
        dataInitializer = new MemoryInitializer();
        dataInitializer.prepareData();
        view = new LoginEmployerViewStub();
    }

    @Test
    public void testLoginProcess() {
        presenter = new LoginEmployerPresenter(view, new EmployerDAOMemory());

        // Test various scenarios for employer login

        // No input provided, attempt to login
        view.setPasswordField("Test1234!");
        presenter.onLogin();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Email address cannot be empty.", view.getShowErrorMessageMsg());

        // No password provided, attempt to login
        view.setPasswordField(null);
        view.setEmailField("example@email.com");
        presenter.onLogin();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Password cannot be empty.", view.getShowErrorMessageMsg());


        // Invalid email provided, attempt to login
        view.setEmailField("invalid.email");
        view.setPasswordField("Test1234!");
        presenter.onLogin();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Invalid email address.", view.getShowErrorMessageMsg());

        // Valid email but incorrect password provided
        view.setEmailField("john.doe@example.com");
        view.setPasswordField("WrongPassword123!");
        presenter.onLogin();
        Assert.assertEquals("Login Error", view.getShowErrorMessageTitle());
        Assert.assertEquals("Invalid credentials!", view.getShowErrorMessageMsg());

        // Valid email and password, successfully login
        view.setEmailField("b.be@northfreedom.com");
        view.setPasswordField("UwL[;3{[fQP:");
        presenter.onLogin();
        Assert.assertEquals("b.be@northfreedom.com", view.getSuccessfullyFinishLoginToken());

        // Empty email and valid password
        view.setEmailField(null);
        view.setPasswordField("Test1234!");
        presenter.onLogin();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Email address cannot be empty.", view.getShowErrorMessageMsg());

        // Valid email and empty password
        view.setEmailField("john.doe@example.com");
        view.setPasswordField(null);
        presenter.onLogin();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Password cannot be empty.", view.getShowErrorMessageMsg());

        // Empty email and empty password
        view.setEmailField(null);
        view.setPasswordField(null);
        presenter.onLogin();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Password cannot be empty.", view.getShowErrorMessageMsg());
    }
}




