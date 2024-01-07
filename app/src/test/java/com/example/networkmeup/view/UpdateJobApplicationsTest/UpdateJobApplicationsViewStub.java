package com.example.networkmeup.view.UpdateJobApplicationsTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.UpdateJobApplications.UpdateJobApplicationsView;

public class UpdateJobApplicationsViewStub implements UpdateJobApplicationsView {
    private String lastPassedToken;
    private Job lastPassedJob;
    @Override
    public void showJobApplications(String userToken, Job job) {
        lastPassedToken = userToken;
        lastPassedJob = job;
    }

    public Job getLastPassedJob() {
        return lastPassedJob;
    }

    public String getLastPassedToken() {
        return lastPassedToken;
    }
}
