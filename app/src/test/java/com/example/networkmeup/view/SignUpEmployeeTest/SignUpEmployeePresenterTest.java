package com.example.networkmeup.view.SignUpEmployeeTest;

import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.view.SignUpEmployee.SignUpEmployeePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains test cases for the SignUpEmployeePresenter class.
 * It tests the functionality of employee sign-up scenarios.
 */
public class SignUpEmployeePresenterTest {
    private SignUpEmployeePresenter presenter;
    private SignUpEmployeeViewStub view;
    private Initializer dataInitializer;

    /**
     * Sets up necessary objects and data before each test case.
     */
    @Before
    public void setup(){
        dataInitializer = new MemoryInitializer();
        dataInitializer.prepareData(); // Prepare initial data for testing
        view = new SignUpEmployeeViewStub(); // Create a stub view for testing
    }

    /**
     * Tests the process of creating a new employee account with various scenarios.
     */
    @Test
    public void testCreateNewAccount(){

        presenter = new SignUpEmployeePresenter(view, new EmployeeDAOMemory());

        // Test various scenarios for creating a new account

        // No input provided, attempt to create an account
        presenter.onCreate();

        // The last update to the showErrorMessage in our stub, is the password field, we can only check this at this instance
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Password cannot be empty.", view.getShowErrorMessageMsg());

        // Add a weak password
        view.setPasswordField("Password123");
        presenter.onCreate();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Password is not strong enough.", view.getShowErrorMessageMsg());

        // Add a strong password but no phone number provided
        view.setPasswordField("Password!234");
        presenter.onCreate();
            // Password field no longer throws an exception -> theres no error message update
            // Last update to showErrorMessage happens on the phone field
            // Phone number and email are empty
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Phone number cannot be empty.", view.getShowErrorMessageMsg());

        // Add an invalid phone number
        view.setPhoneField("124512347");
        presenter.onCreate();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Invalid phone number.", view.getShowErrorMessageMsg());

        // Add a valid phone number but no email provided
        view.setPhoneField("8674829405");
        presenter.onCreate();
            // Password and phone field no longer throw exceptions -> theres no error message update
            // Last update to showErrorMessage happens in the email field
            // Email field is currently empty
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Email address cannot be empty.", view.getShowErrorMessageMsg());

        // Add an invalid email address
        view.setEmailField("@email.com");
        presenter.onCreate();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Invalid email address.", view.getShowErrorMessageMsg());

        // Add a valid email address, complete signup process successfully
        view.setEmailField("example@email.com");
        presenter.onCreate();
        Assert.assertEquals("Your NetworkMeUp Employee account was created!", view.getSuccessfullyFinishActivityMessage());
    }

    /**
     * Tests the scenario when attempting to create an account with existing details.
     */
    @Test
    public void testCreateExistingAccount(){

        presenter = new SignUpEmployeePresenter(view, new EmployeeDAOMemory());
        // Check scenarios for creating an account with existing details in the system
        // Password does not need to be unique

        // Existing email, new phone
        view.setEmailField("john.Brown12@gmail.com");
        view.setPhoneField("8795175838");
        view.setPasswordField("Test1234!");
        presenter.onCreate();
        Assert.assertEquals("Account Creation Error", view.getShowErrorMessageTitle());
        Assert.assertEquals("An employee account already exists with the same email or phone number!", view.getShowErrorMessageMsg());

        // New email, existing phone
        view.setEmailField("random.email@yahoo.com");
        view.setPhoneField("6977264561");
        view.setPasswordField("Test1234!");
        presenter.onCreate();
        Assert.assertEquals("Account Creation Error", view.getShowErrorMessageTitle());
        Assert.assertEquals("An employee account already exists with the same email or phone number!", view.getShowErrorMessageMsg());

        // Existing email and phone
        view.setEmailField("marygreen.188@gmail.com");
        view.setPhoneField("6953619405");
        view.setPasswordField("Test1234!");
        presenter.onCreate();
        Assert.assertEquals("Account Creation Error", view.getShowErrorMessageTitle());
        Assert.assertEquals("An employee account already exists with the same email or phone number!", view.getShowErrorMessageMsg());

    }
}
