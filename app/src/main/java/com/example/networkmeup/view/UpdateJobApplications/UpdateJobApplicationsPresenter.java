package com.example.networkmeup.view.UpdateJobApplications;

import com.example.networkmeup.domain.Job;

public class UpdateJobApplicationsPresenter {
    private UpdateJobApplicationsView view;
    private String userToken;

    public UpdateJobApplicationsPresenter(UpdateJobApplicationsView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    public void onItemClick(Job job){
        view.showJobApplications(userToken, job);
    }
}
