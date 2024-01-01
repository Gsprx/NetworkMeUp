package com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation;

public class ModifyCVEditEducationPresenter {
    private ModifyCVEditEducationView view;
    private String userToken;

    public ModifyCVEditEducationPresenter(ModifyCVEditEducationView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    public void onItemClick(int position){
        view.changeEductionDetails(userToken, position);
    }

    public void onAddNew() {
        view.addNewEducation(userToken);
    }
}
