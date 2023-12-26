package com.example.networkmeup.view.StartPageTest;

import com.example.networkmeup.view.StartPage.StartPagePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * This class is responsible for testing the functionality of the StartPagePresenter.
 * It verifies the behavior of the presenter by simulating user interactions with the associated view.
 */
public class StartPagePresenterTest {
    private StartPagePresenter presenter; // The presenter being tested
    private StartPageViewStub view; // Stub of the StartPageView for testing

    /**
     * Method to set up the initial conditions for each test case.
     * It creates a new StartPageViewStub and associates it with the StartPagePresenter.
     */
    @Before
    public void setup(){
        view = new StartPageViewStub(); // Creating a stub for the view
        presenter = new StartPagePresenter(view); // Creating a presenter with the stubbed view
        view.setPresenter(presenter); // Setting the presenter for the view
    }

    /**
     * Test method to verify the functionality of the onLogin method in the presenter.
     * It simulates 10 login button clicks and checks if the presenter records the clicks accurately.
     */
    @Test
    public void test10LoginClicks(){
        for (int i = 0; i < 10 ; i++){
            presenter.onLogin(); // Simulating a click on the login button
        }
        Assert.assertEquals(10,view.getLoginClicks()); // Verifying the count of login clicks recorded by the view
    }

    /**
     * Test method to verify the functionality of the onSignUp method in the presenter.
     * It simulates 13 sign-up button clicks and checks if the presenter records the clicks accurately.
     */
    @Test
    public void test13SignupClicks(){
        for (int i = 0; i < 13 ; i++){
            presenter.onSignUp(); // Simulating a click on the sign-up button
        }
        Assert.assertEquals(13,view.getSignupClicks()); // Verifying the count of sign-up clicks recorded by the view
    }
}
