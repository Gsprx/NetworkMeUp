package com.example.networkmeup.view.SignUpEmployerTest;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;
import com.example.networkmeup.view.SignUpEmployer.SignUpEmployerPresenter;
import com.example.networkmeup.view.SignUpEmployer.SignUpEmployerView;
import com.example.networkmeup.view.SignUpEmployerTest.SignUpEmployerViewStub;
import com.example.networkmeup.view.SignUpEmployer.SignUpEmployerPresenter;
import com.example.networkmeup.view.SignUpEmployer.SignUpEmployerView;

/**
 * This class represents a stub of the View component for the Employer Sign-Up process used in testing.
 * It implements the SignUpEmployerView interface to simulate user interface actions and display feedback.
 */
public class SignUpEmployerViewStub implements SignUpEmployerView {

    private SignUpEmployerPresenter presenter; // Presenter instance associated with this view stub
    private String emailField; // Simulated input field for email address
    private String phoneField; // Simulated input field for phone number
    private String passwordField; // Simulated input field for password

    private String tinField; // Simulated input field for Tax Identification Number (TIN)
    private String  showErrorMessageMsg; // Message to display for an error scenario
    private String showErrorMessageTitle; // Title to display for an error scenario
    private String  successfullyFinishActivityMessage; // Message to display for a successful activity completion

    /**
     * Default constructor to initialize the SignUpEmployerViewStub.
     */
    public SignUpEmployerViewStub(){
    }

    /**
     * Sets the presenter associated with this view stub.
     * @param presenter SignUpEmployerPresenter instance
     */
    public void setPresenter(SignUpEmployerPresenter presenter){
        this.presenter = presenter;
    }

    /**
     * Retrieves the presenter associated with this view stub.
     * @return SignUpEmployerPresenter instance
     */
    public SignUpEmployerPresenter getPresenter(){
        return this.presenter;
    }

    /**
     * Retrieves the email information entered.
     * @return Email object representing the entered email
     * @throws RuntimeException when an invalid email format is detected
     */
    @Override
    public Email getEmail() throws RuntimeException {
        return new Email(emailField);
    }

    /**
     * Retrieves the password information entered.
     * @return Password object representing the entered password
     * @throws RuntimeException when an invalid password format is detected
     */
    @Override
    public Password getPassword() throws RuntimeException {
        return new Password(passwordField);
    }

    /**
     * Retrieves the phone number information entered.
     * @return Phone object representing the entered phone number
     * @throws RuntimeException when an invalid phone number format is detected
     */
    @Override
    public Phone getPhone() throws RuntimeException {
        return new Phone(phoneField);
    }

    /**
     * Retrieves the TIN information entered.
     * @return TIN object representing the entered Tax Identification Number
     * @throws RuntimeException when an invalid TIN format is detected
     */
    @Override
    public TIN getTIN() throws RuntimeException {
        return new TIN(tinField);
    }

    /**
     * Sets the value for the email field.
     * @param emailField Simulated input for email address
     */
    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }

    /**
     * Sets the value for the phone field.
     * @param phoneField Simulated input for phone number
     */
    public void setPhoneField(String phoneField) {
        this.phoneField = phoneField;
    }

    /**
     * Sets the value for the password field.
     * @param passwordField Simulated input for password
     */
    public void setPasswordField(String passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * Sets the value for the TIN field.
     * @param tinField Simulated input for Tax Identification Number
     */
    public void setTinField(String TinField) {
        this.tinField = TinField;
    }

    /**
     * Displays an error message on the simulated user interface.
     * @param title Title of the error message
     * @param message Content of the error message
     */
    @Override
    public void showErrorMessage(String title, String message) {
        this.showErrorMessageTitle =title;
        this.showErrorMessageMsg = message;
    }

    /**
     * Displays a success message on the simulated user interface.
     * @param message Content of the success message
     */
    @Override
    public void successfullyFinishActivity(String message) {
        this.successfullyFinishActivityMessage = message;
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
     * Retrieves the success message to be displayed upon completion.
     * @return Success message content
     */
    public String getSuccessfullyFinishActivityMessage() {
        return successfullyFinishActivityMessage;
    }
}
