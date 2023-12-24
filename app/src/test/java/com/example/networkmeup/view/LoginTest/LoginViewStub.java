package com.example.networkmeup.view.LoginTest;

import com.example.networkmeup.view.Login.LoginPresenter;
import com.example.networkmeup.view.Login.LoginView;
import com.example.networkmeup.view.SignUp.SignUpPresenter;

public class LoginViewStub implements LoginView {

    private int employeeclicks;

    private int employerclicks;

    private LoginPresenter presenter;

    public LoginViewStub(){}

    public void EmployeeLogin(){
        employeeclicks++;
    }

    public void EmployerLogin(){
        employerclicks++;
    }
    public LoginPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    public int getEmployeeClicks() {
        return employeeclicks;
    }

    public int getEmployerClicks() {
        return employerclicks;
    }
}
