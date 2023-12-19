package com.example.networkmeup.view.StartPageTest;

import com.example.networkmeup.view.StartPage.StartPagePresenter;
import com.example.networkmeup.view.StartPage.StartPageView;

public class StartPageViewStub implements StartPageView {
    private int loginClicks;
    private int signupClicks;
    private StartPagePresenter presenter;

    public StartPageViewStub() {
    }

    public void setPresenter(StartPagePresenter presenter) {
        this.presenter = presenter;
    }

    public StartPagePresenter getPresenter() {
        return presenter;
    }

    public void login(){
        loginClicks++;
    }

    public void signup(){
        signupClicks++;
    }

    public int getLoginClicks() {
        return loginClicks;
    }

    public int getSignupClicks() {
        return signupClicks;
    }
}
