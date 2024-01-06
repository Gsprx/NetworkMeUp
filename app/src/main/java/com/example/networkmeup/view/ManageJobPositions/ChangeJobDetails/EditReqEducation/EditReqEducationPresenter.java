package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation;

import com.example.networkmeup.domain.Job;

public class EditReqEducationPresenter {
    private EditReqEducationView view;
    private String userToken;
    private Job job;

    public EditReqEducationPresenter(EditReqEducationView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    public void onItemClick(int position) {
        view.changeEductionDetails(userToken, position, job);
    }

    public void onAddNew() {
        view.addNewEducation(userToken, job);
    }
}
