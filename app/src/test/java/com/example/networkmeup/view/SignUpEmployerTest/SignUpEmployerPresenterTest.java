package com.example.networkmeup.view.SignUpEmployerTest;

import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.view.SignUpEmployee.SignUpEmployeePresenter;
import com.example.networkmeup.view.SignUpEmployer.SignUpEmployerPresenter;
import com.example.networkmeup.view.SignUpEmployerTest.SignUpEmployerViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignUpEmployerPresenterTest {
    private SignUpEmployerPresenter presenter;
    private SignUpEmployerViewStub view;
    private Initializer dataInitializer;

    @Before
    public void setup(){
        // Setting up the data initializer and view stub before each test case
        dataInitializer = new MemoryInitializer();
        dataInitializer.prepareData();
        view = new SignUpEmployerViewStub();
    }

    @Test
    public void testCreateNewAccount(){
        // Testing various scenarios for employer sign-up

        presenter = new SignUpEmployerPresenter(view, new EmployerDAOMemory());

        // Attempt to create an account without any input
        presenter.onCreate();
        // The last update to the showErrorMessage in our stub, is the TIN field, we can only check this at this instance
        // Expecting an error message for TIN field being empty
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("TIN cannot be empty.", view.getShowErrorMessageMsg());

        // Adding an incorrect TIN format
        view.setTinField("Company3414");
        presenter.onCreate();
        // Expecting an error message for an invalid TIN format
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Invalid TIN.", view.getShowErrorMessageMsg());

        // Adding a correct TIN but no password
        view.setTinField("341423139");
        presenter.onCreate();
        // Expecting an error message for an empty password
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Password cannot be empty.", view.getShowErrorMessageMsg());

        // Adding a weak password
        view.setPasswordField("Password123");
        presenter.onCreate();
        // Expecting an error message for a weak password
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Password is not strong enough.", view.getShowErrorMessageMsg());

        // Adding a strong password but no phone number
        view.setPasswordField("Password!234");
        presenter.onCreate();
        // Expecting an error message for an empty phone number
        // Password field no longer throws an exception -> theres no error message update
        // Last update to showErrorMessage happens on the phone field
        // Phone number and email are empty
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Phone number cannot be empty.", view.getShowErrorMessageMsg());

        // Adding an invalid phone number
        view.setPhoneField("124512347");
        presenter.onCreate();
        // Expecting an error message for an invalid phone number
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Invalid phone number.", view.getShowErrorMessageMsg());

        // Adding a valid phone number but no email
        view.setPhoneField("8674829405");
        presenter.onCreate();
        // Expecting an error message for an empty email
        // Password and phone field no longer throw exceptions -> theres no error message update
        // Last update to showErrorMessage happens in the email field
        // Email field is currently empty
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Email address cannot be empty.", view.getShowErrorMessageMsg());

        // Adding an invalid email address
        view.setEmailField("@email.com");
        presenter.onCreate();
        // Expecting an error message for an invalid email address
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Invalid email address.", view.getShowErrorMessageMsg());

        // Adding a valid email address, expecting successful account creation
        view.setEmailField("example@email.com");
        presenter.onCreate();
        // Expecting a success message for account creation
        Assert.assertEquals("Your NetworkMeUp Employer account was created!", view.getSuccessfullyFinishActivityMessage());
    }
    @Test
    public void testCreateExistingAccount(){

        // Testing scenario when creating an account with existing details in the system

        presenter = new SignUpEmployerPresenter(view, new EmployerDAOMemory());
        // Check when creating an account with any existing details in the system
        // Password does not need to be unique

        // Creating an account with a unique phone number but an existing email
        view.setTinField("341423139");
        view.setEmailField("b.be@northfreedom.com");
        view.setPhoneField("8795175834");
        view.setPasswordField("Test1234!");
        presenter.onCreate();
        // Expecting an error message as an employer account already exists with the same email or phone number or TIN
        Assert.assertEquals("Account Creation Error", view.getShowErrorMessageTitle());
        Assert.assertEquals("An employer account already exists with the same email or phone number or TIN!", view.getShowErrorMessageMsg());

        // Creating an account with a unique email but an existing phone number
        view.setTinField("341423139");
        view.setEmailField("random.email@yahoo.com");
        view.setPhoneField("5693311692");
        view.setPasswordField("Test1234!");
        presenter.onCreate();
        // Expecting an error message as an employer account already exists with the same email or phone number or TIN
        Assert.assertEquals("Account Creation Error", view.getShowErrorMessageTitle());
        Assert.assertEquals("An employer account already exists with the same email or phone number or TIN!", view.getShowErrorMessageMsg());

        // Creating an account with existing email and phone number
        view.setTinField("341423139");
        view.setEmailField("Company.188@gmail.com");
        view.setPhoneField("6953619405");
        view.setPasswordField("Test1234!");
        presenter.onCreate();
        // Expecting an error message as an employer account already exists with the same email or phone number or TIN
        Assert.assertEquals("Account Creation Error", view.getShowErrorMessageTitle());
        Assert.assertEquals("An employer account already exists with the same email or phone number or TIN!", view.getShowErrorMessageMsg());

    }
}
