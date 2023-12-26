package com.example.networkmeup.view.StartPageTest;

import com.example.networkmeup.view.StartPage.StartPagePresenter;
import com.example.networkmeup.view.StartPage.StartPageView;

/**
 * This class acts as a stub implementation of the StartPageView interface for testing purposes.
 * It mimics the behavior of the actual view to facilitate testing of the StartPagePresenter.
 */
public class StartPageViewStub implements StartPageView {
    private int loginClicks; // Counter to track the number of login button clicks
    private int signupClicks; // Counter to track the number of signup button clicks
    private StartPagePresenter presenter; // Reference to the associated presenter

    /**
     * Sets the presenter for this view stub.
     * @param presenter The presenter instance to be associated with this stub.
     */
    public void setPresenter(StartPagePresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Retrieves the presenter associated with this view stub.
     * @return The presenter instance associated with this stub.
     */
    public StartPagePresenter getPresenter() {
        return presenter;
    }

    /**
     * Simulates a user action of clicking the login button.
     * Increases the count of login button clicks recorded by this view stub.
     */
    public void login(){
        loginClicks++;
    }

    /**
     * Simulates a user action of clicking the signup button.
     * Increases the count of signup button clicks recorded by this view stub.
     */
    public void signup(){
        signupClicks++;
    }

    /**
     * Retrieves the number of recorded login button clicks.
     * @return The count of login button clicks registered by this view stub.
     */
    public int getLoginClicks() {
        return loginClicks;
    }

    /**
     * Retrieves the number of recorded signup button clicks.
     * @return The count of signup button clicks registered by this view stub.
     */
    public int getSignupClicks() {
        return signupClicks;
    }
}
