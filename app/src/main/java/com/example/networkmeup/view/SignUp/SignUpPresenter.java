package com.example.networkmeup.view.SignUp;

public class SignUpPresenter {
    private SignUpView signUpView;

    public SignUpPresenter(SignUpView view){
        signUpView = view;
    }

    public void onEmployee() {
        signUpView.employee();
    }

    public void onEmployer() {
        signUpView.employer();
    }
}
