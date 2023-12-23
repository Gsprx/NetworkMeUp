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

public class SignUpEmployerViewStub implements SignUpEmployerView {

    private SignUpEmployerPresenter presenter;
    private String emailField;
    private String phoneField;
    private String passwordField;

    private String tinField;
    private String  showErrorMessageMsg;
    private String showErrorMessageTitle;
    private String  successfullyFinishActivityMessage;

    public SignUpEmployerViewStub(){
    }

    public void setPresenter(SignUpEmployerPresenter presenter){
        this.presenter = presenter;
    }

    public SignUpEmployerPresenter getPresenter(){
        return this.presenter;
    }

    @Override
    public Email getEmail() throws RuntimeException {
        return new Email(emailField);
    }

    @Override
    public Password getPassword() throws RuntimeException {
        return new Password(passwordField);
    }

    @Override
    public Phone getPhone() throws RuntimeException {
        return new Phone(phoneField);
    }

    @Override
    public TIN getTIN() throws RuntimeException {
        return new TIN(tinField);
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

    public void setTinField(String TinField) {
        this.tinField = TinField;
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
