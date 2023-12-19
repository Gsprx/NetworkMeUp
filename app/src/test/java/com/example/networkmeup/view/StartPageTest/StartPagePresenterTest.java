package com.example.networkmeup.view.StartPageTest;

import com.example.networkmeup.view.StartPage.StartPagePresenter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StartPagePresenterTest {
    private StartPagePresenter presenter;
    private StartPageViewStub view;

    @Before
    public void setup(){
        view = new StartPageViewStub();
        presenter = new StartPagePresenter(view);
        view.setPresenter(presenter);
    }

    @Test
    public void test10LoginClicks(){
        for (int i = 0; i < 10 ; i++){
            presenter.onLogin();
        }
        Assert.assertEquals(10,view.getLoginClicks());
    }

    @Test
    public void test13SignupClicks(){
        for (int i = 0; i < 13 ; i++){
            presenter.onSignUp();
        }
        Assert.assertEquals(13,view.getSignupClicks());
    }
}
