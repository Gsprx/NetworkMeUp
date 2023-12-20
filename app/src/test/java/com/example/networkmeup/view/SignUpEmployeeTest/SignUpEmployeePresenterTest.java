package com.example.networkmeup.view.SignUpEmployeeTest;

import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.view.SignUpEmployee.SignUpEmployeePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignUpEmployeePresenterTest {
    private SignUpEmployeePresenter presenter;
    private SignUpEmployeeViewStub view;
    private Initializer dataInitializer;

    @Before
    public void setup(){
        dataInitializer = new MemoryInitializer();
        dataInitializer.prepareData();
        view = new SignUpEmployeeViewStub();
    }

    @Test
    public void testCreateNewAccount(){
        //checking all possible outcomes for employee signup

        presenter = new SignUpEmployeePresenter(view, new EmployeeDAOMemory());

        //no input, attempt to create account

        presenter.onCreate();
            //the last update to the showErrorMessage in our stub, is the password field, we can only check this at this instance
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Password cannot be empty.", view.getShowErrorMessageMsg());

        //add a weak password
        view.setPasswordField("Password123");
        presenter.onCreate();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Password is not strong enough.", view.getShowErrorMessageMsg());

        //add a strong password
        view.setPasswordField("Password!234");
        presenter.onCreate();
            //password field no longer throws an exception -> theres no error message update
            //last update to showErrorMessage happens on the phone field
            //phone number and email are empty
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Phone number cannot be empty.", view.getShowErrorMessageMsg());

        //add an invalid phone number
        view.setPhoneField("124512347");
        presenter.onCreate();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Invalid phone number.", view.getShowErrorMessageMsg());

        //add a valid phone number
        view.setPhoneField("8674829405");
        presenter.onCreate();
            //password and phone field no longer throw exceptions -> theres no error message update
            //last update to showErrorMessage happens in the email field
            //email field is currently empty
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Email address cannot be empty.", view.getShowErrorMessageMsg());

        //add an invalid email address
        view.setEmailField("@email.com");
        presenter.onCreate();
        Assert.assertEquals("Error!", view.getShowErrorMessageTitle());
        Assert.assertEquals("Invalid email address.", view.getShowErrorMessageMsg());

        //add a valid email address
        view.setEmailField("example@email.com");
        presenter.onCreate();
        Assert.assertEquals("Your NetworkMeUp Employee account was created!", view.getSuccessfullyFinishActivityMessage());
    }

    @Test
    public void testCreateExistingAccount(){
        //check when creating an account with any existing details in the system
        //password does not need to be unique

        //unique phone but existing email
        view.setEmailField("john.Brown12@gmail.com");
        view.setPhoneField("8795175838");
        view.setPasswordField("Test1234!");
        presenter.onCreate();
        Assert.assertEquals("Account Creation Error", view.getShowErrorMessageTitle());
        Assert.assertEquals("An employee account already exists with the same email or phone number!", view.getShowErrorMessageMsg());

        //unique email but existing phone
        view.setEmailField("random.email@yahoo.com");
        view.setPhoneField("6977264561");
        view.setPasswordField("Test1234!");
        presenter.onCreate();
        Assert.assertEquals("Account Creation Error", view.getShowErrorMessageTitle());
        Assert.assertEquals("An employee account already exists with the same email or phone number!", view.getShowErrorMessageMsg());

        //existing email and phone
        view.setEmailField("marygreen.188@gmail.com");
        view.setPhoneField("6953619405");
        view.setPasswordField("Test1234!");
        presenter.onCreate();
        Assert.assertEquals("Account Creation Error", view.getShowErrorMessageTitle());
        Assert.assertEquals("An employee account already exists with the same email or phone number!", view.getShowErrorMessageMsg());

    }
}
