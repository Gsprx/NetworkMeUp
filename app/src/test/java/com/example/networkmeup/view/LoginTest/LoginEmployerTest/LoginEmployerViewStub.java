package com.example.networkmeup.view.LoginTest.LoginEmployerTest;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.view.Login.LoginEmployer.LoginEmployerView;

/**
 * This class represents a stub of the Employer Login View used for testing purposes.
 * It implements the LoginEmployerView interface to simulate user interface actions and display feedback.
 */
public class LoginEmployerViewStub implements LoginEmployerView {

    private String emailField; // Simulated input field for email address
    private String passwordField; // Simulated input field for password
    private String showErrorMessageMsg; // Message to display for an error scenario
    private String showErrorMessageTitle; // Title to display for an error scenario
    private String successfullyFinishLoginMessage; // Message to display for a successful login

    /**
     * Default constructor to initialize the LoginEmployerViewStub.
     */
    public LoginEmployerViewStub() {
    }

    /**
     * Sets the value for the email field.
     * @param emailField Simulated input for the email address
     */
    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }

    /**
     * Sets the value for the password field.
     * @param passwordField Simulated input for the password
     */
    public void setPasswordField(String passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * Retrieves the error message to be displayed.
     * @return Error message content
     */
    public String getShowErrorMessageMsg() {
        return showErrorMessageMsg;
    }

    /**
     * Retrieves the error message title to be displayed.
     * @return Error message title
     */
    public String getShowErrorMessageTitle() {
        return showErrorMessageTitle;
    }

    /**
     * Retrieves the success message to be displayed upon successful login.
     * @return Success message content
     */
    public String getSuccessfullyFinishLoginMessage() {
        return successfullyFinishLoginMessage;
    }

    /**
     * Simulates retrieving the email information entered by the user.
     * @return Email object representing the entered email
     * @throws RuntimeException when an invalid email format is detected
     */
    @Override
    public Email getEmail() throws RuntimeException {
        return new Email(emailField);
    }

    /**
     * Simulates retrieving the password information entered by the user.
     * @return Password object representing the entered password
     * @throws RuntimeException when an invalid password format is detected
     */
    @Override
    public Password getPassword() throws RuntimeException {
        return new Password(passwordField);
    }

    /**
     * Simulates displaying an error message on the user interface.
     * @param title Title of the error message
     * @param message Content of the error message
     */
    @Override
    public void showErrorMessage(String title, String message) {
        this.showErrorMessageTitle = title;
        this.showErrorMessageMsg = message;
    }

    /**
     * Simulates displaying a success message on the user interface upon successful login.
     * @param message Content of the success message
     */
    @Override
    public void successfullyFinishLogin(String message) {
        this.successfullyFinishLoginMessage = message;
    }
}


