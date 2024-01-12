package com.example.networkmeup.view.SignUp;

/**
 * Presenter for the SignUp functionality in the application.
 * This class handles the logic for user actions related to signing up,
 * delegating UI-related tasks back to the view.
 */
public class SignUpPresenter {

    private SignUpView signUpView;

    /**
     * Constructor for SignUpPresenter.
     *
     * @param view The SignUpView that this presenter is responsible for.
     */
    public SignUpPresenter(SignUpView view) {
        signUpView = view;
    }

    /**
     * Invoked when the user chooses to sign up as an employee.
     * This method triggers the UI update to handle employee registration.
     */
    public void onEmployee() {
        signUpView.employee();
    }

    /**
     * Invoked when the user chooses to sign up as an employer.
     * This method triggers the UI update to handle employer registration.
     */
    public void onEmployer() {
        signUpView.employer();
    }
}