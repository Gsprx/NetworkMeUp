package com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience;

public class ModifyCVEditWorkExperiencePresenter {
    private ModifyCVEditWorkExperienceView view;
    private String userToken;

    public ModifyCVEditWorkExperiencePresenter(ModifyCVEditWorkExperienceView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    public void onItemClick(int position){
        view.changeWorkExperienceDetails(userToken, position);
    }

    public void onAddNew() {
        view.addNewWorkExperience(userToken);
    }
}
