package com.example.networkmeup.view.SignUpEmployeeTest;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.view.SignUpEmployee.SignUpEmployeePresenter;
import com.example.networkmeup.view.SignUpEmployee.SignUpEmployeeView;

/**
 * This class acts as a stub implementation of the SignUpEmployeeView interface for testing purposes.
 * It simulates a view and provides methods to retrieve input values and handle messages.
 */
public class SignUpEmployeeViewStub implements SignUpEmployeeView {
    private SignUpEmployeePresenter presenter;
    private String emailField;
    private String phoneField;
    private String passwordField;
    private String  showErrorMessageMsg;
    private String showErrorMessageTitle;
    private String  successfullyFinishActivityMessage;

    /**
     * Default constructor.
     */
    public SignUpEmployeeViewStub(){
    }

    /**
     * Getter method for retrieving the presenter associated with this view stub.
     *
     * @return The SignUpEmployeePresenter associated with this view stub.
     */
    public SignUpEmployeePresenter getPresenter() {
        return presenter;
    }

    /**
     * Setter method for setting the presenter associated with this view stub.
     *
     * @param presenter The SignUpEmployeePresenter to associate with this view stub.
     */
    public void setPresenter(SignUpEmployeePresenter presenter) {
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
     * Retrieves the phone input from the view stub.
     *
     * @return Phone object from the provided phone field.
     * @throws RuntimeException if the phone field is not properly set.
     */
    @Override
    public Phone getPhone() throws  RuntimeException{
        return new Phone(phoneField);
    }

    /**
     * Retrieves the password input from the view stub.
     *
     * @return Password object from the provided password field.
     * @throws RuntimeException if the password field is not properly set.
     */
    @Override
    public Password getPassword() throws RuntimeException{
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
        this.showErrorMessageTitle =title;
        this.showErrorMessageMsg = message;
    }

    /**
     * Notifies the view stub about a successful finish action with a message.
     *
     * @param message Message to display upon successful completion.
     */
    @Override
    public void successfullyFinishActivity(String message) {
        this.successfullyFinishActivityMessage = message;
    }

    /**
     * Setter method for setting the email field in the view stub.
     *
     * @param emailField Email string to set in the view stub.
     */
    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }

    /**
     * Setter method for setting the phone field in the view stub.
     *
     * @param phoneField Phone string to set in the view stub.
     */
    public void setPhoneField(String phoneField) {
        this.phoneField = phoneField;
    }

    /**
     * Setter method for setting the password field in the view stub.
     *
     * @param passwordField Password string to set in the view stub.
     */
    public void setPasswordField(String passwordField) {
        this.passwordField = passwordField;
    }

    /**
     * Getter method for retrieving the content of the showErrorMessageMsg field in the view stub.
     *
     * @return Content of the error message displayed in the view stub.
     */
    public String getShowErrorMessageMsg() {
        return showErrorMessageMsg;
    }

    /**
     * Getter method for retrieving the content of the showErrorMessageTitle field in the view stub.
     *
     * @return Title of the error message displayed in the view stub.
     */
    public String getShowErrorMessageTitle() {
        return showErrorMessageTitle;
    }

    /**
     * Getter method for retrieving the successfullyFinishActivityMessage field in the view stub.
     *
     * @return Content of the message displayed upon successful activity completion.
     */
    public String getSuccessfullyFinishActivityMessage() {
        return successfullyFinishActivityMessage;
    }
}
