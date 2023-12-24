package com.example.networkmeup.view.Login;

public class LoginPresenter {
    private LoginView view;
    public LoginPresenter(LoginView view){
        this.view = view;
    }

    public void onLoginEmployee() {
        view.EmployeeLogin();
    }

    public void onLoginEmployer(){
        view.EmployerLogin();
    }
}


