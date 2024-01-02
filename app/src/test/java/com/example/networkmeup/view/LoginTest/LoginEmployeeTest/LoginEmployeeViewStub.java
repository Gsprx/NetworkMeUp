package com.example.networkmeup.view.LoginTest.LoginEmployeeTest;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.view.Login.LoginEmployee.LoginEmployeePresenter;
import com.example.networkmeup.view.Login.LoginEmployee.LoginEmployeeView;

/**
 * Stub implementation of the LoginEmployeeView interface for testing purposes.
 * It simulates a view and provides methods to retrieve input values and handle messages.
 */
public class LoginEmployeeViewStub implements LoginEmployeeView {
    private LoginEmployeePresenter presenter;
    private String emailField;
    private String passwordField;
    private String showErrorMessageMsg;
    private String showErrorMessageTitle;
    private String successfullyFinishLoginToken;

    /**
     * Default constructor.
     */
    public LoginEmployeeViewStub() {
    }

    /**
     * Getter method to retrieve the presenter associated with this view stub.
     *
     * @return The LoginEmployeePresenter associated with this view stub.
     */
    public LoginEmployeePresenter getPresenter() {
        return presenter;
    }

    /**
     * Setter method to set the presenter associated with this view stub.
     *
     * @param presenter The LoginEmployeePresenter to associate with this view stub.
     */
    public void setPresenter(LoginEmployeePresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Retrieves the email input from the view stub.
     *
     * @return Email object from the provided email field.
     * @throws RuntimeException if the email field is not properly set.
     */
    @Override
    public Email getEmail() throws RuntimeException {
        return new Email(emailField);
    }

    /**
     * Retrieves the password input from the view stub.
     *
     * @return Password object from the provided password field.
     * @throws RuntimeException if the password field is not properly set.
     */
    @Override
    public Password getPassword() throws RuntimeException {
        return new Password(passwordField);
    }

    /**
     * Displays an error message on the view stub.
     *
     * @param title   Title of the error message.
     * @param message Content of the error message.
     */
    @Override
    public void showErrorMessage(String title, String message) {
        this.showErrorMessageTitle = title;
        this.showErrorMessageMsg = message;
    }

    /**
     * Notifies the view stub about a successful finish action with a message.
     *
     * @param userToken
     */
    @Override
    public void successfullyFinishLogin(String userToken) {
        this.successfullyFinishLoginToken = userToken;
    }

    /**
     * Setter method to set the email field in the view stub.
     *
     * @param emailField Email string to set in the view stub.
     */
    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }

    /**
     * Setter method to set the password field in the view stub.
     *
     * @param passwordField Password string to set in the view stub.
     */
    public void setPasswordField(String passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * Getter method to retrieve the content of the showErrorMessageMsg field in the view stub.
     *
     * @return Content of the error message displayed in the view stub.
     */
    public String getShowErrorMessageMsg() {
        return showErrorMessageMsg;
    }

    /**
     * Getter method to retrieve the content of the showErrorMessageTitle field in the view stub.
     *
     * @return Title of the error message displayed in the view stub.
     */
    public String getShowErrorMessageTitle() {
        return showErrorMessageTitle;
    }

    /**
     * Getter method to retrieve the successfullyFinishLoginToken field in the view stub.
     *
     * @return Content of the message displayed upon successful login.
     */
    public String getSuccessfullyFinishLoginToken() {
        return successfullyFinishLoginToken;
    }
}
