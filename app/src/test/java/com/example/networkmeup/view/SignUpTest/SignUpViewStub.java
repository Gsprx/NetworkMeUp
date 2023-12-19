package com.example.networkmeup.view.SignUpTest;

import com.example.networkmeup.view.SignUp.SignUpPresenter;
import com.example.networkmeup.view.SignUp.SignUpView;

public class SignUpViewStub implements SignUpView {
    private int employeeClicks;
    private int employerClicks;
    private SignUpPresenter presenter;
    public SignUpViewStub (){
    }

    public void employee(){
        employeeClicks++;
    }

    public void employer(){
        employerClicks++;
    }

    public SignUpPresenter getPresenter() {
        return presenter;
    }

    public void setPresenter(SignUpPresenter presenter) {
        this.presenter = presenter;
    }

    public int getEmployeeClicks() {
        return employeeClicks;
    }

    public int getEmployerClicks() {
        return employerClicks;
    }
}
