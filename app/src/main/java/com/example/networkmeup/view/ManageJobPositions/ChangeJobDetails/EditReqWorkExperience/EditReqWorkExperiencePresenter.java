package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience;

import com.example.networkmeup.domain.Job;

public class EditReqWorkExperiencePresenter {
    private EditReqWorkExperienceView view;
    private String userToken;
    private Job job;

    public EditReqWorkExperiencePresenter(EditReqWorkExperienceView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    public void onItemClick(int position) {
        view.changeWorkExperienceDetails(userToken, position, job);
    }

    public void onAddNew() {
        view.addNewWorkExperience(userToken, job);
    }
}
