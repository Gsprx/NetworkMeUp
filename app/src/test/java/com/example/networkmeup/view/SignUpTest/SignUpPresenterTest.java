package com.example.networkmeup.view.SignUpTest;

import com.example.networkmeup.view.SignUp.SignUpPresenter;
import com.example.networkmeup.view.SignUp.SignUpView;
import com.example.networkmeup.view.StartPage.StartPagePresenter;
import com.example.networkmeup.view.StartPageTest.StartPageViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is responsible for testing the functionality of the SignUpPresenter class
 * that manages interactions between the SignUpView and user input during sign-up processes.
 */
public class SignUpPresenterTest {
    private SignUpViewStub view; // Instance of a stub for the SignUpView interface
    private SignUpPresenter presenter; // Instance of the SignUpPresenter being tested

    /**
     * Method executed before each test to set up the necessary components.
     */
    @Before
    public void setup(){
        view = new SignUpViewStub(); // Initializing a stub of the SignUpView
        presenter = new SignUpPresenter(view); // Creating an instance of SignUpPresenter with the view
        view.setPresenter(presenter); // Setting the presenter for the view
    }

    /**
     * Test method to verify the number of clicks on the Employee sign-up button.
     */
    @Test
    public void test7EmployeeClicks(){
        // Simulating 7 clicks on the Employee sign-up button
        for (int i = 0; i < 7 ; i++){
            presenter.onEmployee(); // Triggering the employee sign-up event in the presenter
        }
        // Verifying if the view recorded 7 clicks on the Employee sign-up button
        Assert.assertEquals(7,view.getEmployeeClicks());
    }

    /**
     * Test method to verify the number of clicks on the Employer sign-up button.
     */
    @Test
    public void test4EmployerClicks(){
        // Simulating 4 clicks on the Employer sign-up button
        for (int i = 0; i < 4 ; i++){
            presenter.onEmployer(); // Triggering the employer sign-up event in the presenter
        }
        // Verifying if the view recorded 4 clicks on the Employer sign-up button
        Assert.assertEquals(4,view.getEmployerClicks());
    }
}
