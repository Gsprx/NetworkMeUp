package com.example.networkmeup.view.SignUpTest;

import com.example.networkmeup.view.SignUp.SignUpPresenter;
import com.example.networkmeup.view.SignUp.SignUpView;
import com.example.networkmeup.view.StartPage.StartPagePresenter;
import com.example.networkmeup.view.StartPageTest.StartPageViewStub;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SignUpPresenterTest {
    private SignUpViewStub view;
    private SignUpPresenter presenter;

    @Before
    public void setup(){
        view = new SignUpViewStub();
        presenter = new SignUpPresenter(view);
        view.setPresenter(presenter);
    }

    @Test
    public void test7EmployeeClicks(){
        for (int i = 0; i < 7 ; i++){
            presenter.onEmployee();
        }
        Assert.assertEquals(7,view.getEmployeeClicks());
    }

    @Test
    public void test4EmployerClicks(){
        for (int i = 0; i < 4 ; i++){
            presenter.onEmployer();
        }
        Assert.assertEquals(4,view.getEmployerClicks());
    }
}
