package com.example.networkmeup.view.LoginTest;

import com.example.networkmeup.view.Login.LoginPresenter;
import com.example.networkmeup.view.Login.LoginView;
import com.example.networkmeup.view.SignUp.SignUpPresenter;
import com.example.networkmeup.view.SignUpTest.SignUpViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains test cases for the LoginPresenter class.
 * It tests the functionality of the LoginPresenter regarding user login actions.
 */
public class LoginPresenterTest {

    private LoginViewStub view;

    private LoginPresenter presenter;

    /**
     * Initializes necessary objects before each test case.
     * Sets up the LoginPresenter with a stub view and associates the presenter with the view.
     */
    @Before
    public void setup(){
        view = new LoginViewStub();
        presenter = new LoginPresenter(view);
        view.setPresenter(presenter);
    }

    /**
     * Tests if the onLoginEmployee method in the presenter correctly increments the employee login clicks.
     */
    @Test
    public void test9EmployeeClicks(){
        for (int i = 0; i < 9 ; i++){
            presenter.onLoginEmployee();
        }
        Assert.assertEquals(9,view.getEmployeeClicks());
    }

    /**
     * Tests if the onLoginEmployer method in the presenter correctly increments the employer login clicks.
     */
    @Test
    public void test7EmployerClicks(){
        for (int i = 0; i <7 ; i++){
            presenter.onLoginEmployer();
        }
        Assert.assertEquals(7,view.getEmployerClicks());
    }
}
