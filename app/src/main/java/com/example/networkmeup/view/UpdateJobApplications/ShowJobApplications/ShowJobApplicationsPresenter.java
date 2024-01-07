package com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications;

import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Job;

public class ShowJobApplicationsPresenter {
    private ShowJobApplicationsView view;
    private String userToken;
    private Job job;

    public ShowJobApplicationsPresenter(ShowJobApplicationsView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    public void onItemClick(int position){
        view.showApplicationDetails(userToken,job,position);
    }
}
