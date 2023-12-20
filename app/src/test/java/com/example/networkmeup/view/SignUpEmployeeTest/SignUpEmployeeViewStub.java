package com.example.networkmeup.view.SignUpEmployeeTest;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.view.SignUpEmployee.SignUpEmployeePresenter;
import com.example.networkmeup.view.SignUpEmployee.SignUpEmployeeView;

public class SignUpEmployeeViewStub implements SignUpEmployeeView {
    private SignUpEmployeePresenter presenter;
    private String emailField;
    private String phoneField;
    private String passwordField;
    private String  showErrorMessageMsg;
    private String showErrorMessageTitle;
    private String  successfullyFinishActivityMessage;

    public SignUpEmployeeViewStub(){
    }

    public SignUpEmployeePresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(SignUpEmployeePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Email getEmail() throws RuntimeException {
        return new Email(emailField);
    }

    @Override
    public Phone getPhone() throws  RuntimeException{
        return new Phone(phoneField);
    }

    @Override
    public Password getPassword() throws RuntimeException{
        return new Password(passwordField);
    }

    @Override
    public void showErrorMessage(String title, String message) {
        this.showErrorMessageTitle =title;
        this.showErrorMessageMsg = message;
    }

    @Override
    public void successfullyFinishActivity(String message) {
        this.successfullyFinishActivityMessage = message;
    }

    public void setEmailField(String emailField) {
        this.emailField = emailField;
    }

    public void setPhoneField(String phoneField) {
        this.phoneField = phoneField;
    }

    public void setPasswordField(String passwordField) {
        this.passwordField = passwordField;
    }

    public String getShowErrorMessageMsg() {
        return showErrorMessageMsg;
    }

    public String getShowErrorMessageTitle() {
        return showErrorMessageTitle;
    }

    public String getSuccessfullyFinishActivityMessage() {
        return successfullyFinishActivityMessage;
    }
}
