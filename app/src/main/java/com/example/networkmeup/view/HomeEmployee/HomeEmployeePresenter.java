package com.example.networkmeup.view.HomeEmployee;

public class HomeEmployeePresenter {
    private HomeEmployeeView view;
    //user token is the email of the employee
    private String userToken;

    public HomeEmployeePresenter(HomeEmployeeView view, String userToken){
        validateToken(userToken);
        this.view = view;
        this.userToken = userToken;
    }
    private void validateToken(Object obj){
        if (obj == null){
            view.showTokenErrorMessage("An error has occurred during login, please try again.");
        }
    }
    public void onModifyCV(){
        view.modifyCV(userToken);
    }
    public void onSearchJobs(){
        view.searchJobs(userToken);
    }
    public void onEditAccount(){
        view.editAccount(userToken);
    }
}

