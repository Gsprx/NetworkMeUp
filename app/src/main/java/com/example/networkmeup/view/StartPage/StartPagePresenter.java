package com.example.networkmeup.view.StartPage;

public class StartPagePresenter {
    private StartPageView startPageView;

    public StartPagePresenter (StartPageView startPageView){
        this.startPageView = startPageView;
    }

    public void onLogin(){
        startPageView.login();
    }
}
