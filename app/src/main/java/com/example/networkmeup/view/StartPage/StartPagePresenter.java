package com.example.networkmeup.view.StartPage;

/**
 * The presenter class for the Start Page, responsible for handling user interactions
 * and communicating with the associated view ({@link StartPageView}).
 */
public class StartPagePresenter {

    private StartPageView startPageView;

    /**
     * Constructs a new StartPagePresenter with the specified StartPageView.
     *
     * @param startPageView The associated StartPageView for this presenter.
     */
    public StartPagePresenter(StartPageView startPageView) {
        this.startPageView = startPageView;
    }

    /**
     * Invoked when the login action is triggered. Delegates the login action to
     * the associated StartPageView.
     */
    public void onLogin() {
        startPageView.login();
    }

    /**
     * Invoked when the sign-up action is triggered. Delegates the sign-up action to
     * the associated StartPageView.
     */
    public void onSignUp() {
        startPageView.signup();
    }
}