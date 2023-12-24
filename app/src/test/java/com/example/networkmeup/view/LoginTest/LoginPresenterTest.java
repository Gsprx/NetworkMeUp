package com.example.networkmeup.view.LoginTest;

import com.example.networkmeup.view.Login.LoginPresenter;
import com.example.networkmeup.view.Login.LoginView;
import com.example.networkmeup.view.SignUp.SignUpPresenter;
import com.example.networkmeup.view.SignUpTest.SignUpViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginPresenterTest {

    private LoginViewStub view;

    private LoginPresenter presenter;

    @Before
    public void setup(){
        view = new LoginViewStub();
        presenter = new LoginPresenter(view);
        view.setPresenter(presenter);
    }

    @Test
    public void test9EmployeeClicks(){
        for (int i = 0; i < 9 ; i++){
            presenter.onLoginEmployee();
        }
        Assert.assertEquals(9,view.getEmployeeClicks());
    }

    @Test
    public void test7EmployerClicks(){
        for (int i = 0; i <7 ; i++){
            presenter.onLoginEmployer();
        }
        Assert.assertEquals(7,view.getEmployerClicks());
    }
}
