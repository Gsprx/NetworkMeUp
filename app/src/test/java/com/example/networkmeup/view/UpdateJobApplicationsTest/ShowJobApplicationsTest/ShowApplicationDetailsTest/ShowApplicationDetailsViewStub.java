package com.example.networkmeup.view.UpdateJobApplicationsTest.ShowJobApplicationsTest.ShowApplicationDetailsTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowApplicationDetails.ShowApplicationDetailsView;

public class ShowApplicationDetailsViewStub implements ShowApplicationDetailsView {
    private String lastPassedToken;
    private Job lastPassedJob;
    @Override
    public void acceptedApplicant(String userToken, Job job) {
        lastPassedJob = job;
        lastPassedToken = userToken;
    }

    @Override
    public void rejectedApplicant(String userToken, Job job) {
        lastPassedJob = job;
        lastPassedToken = userToken;
    }

    public Job getLastPassedJob() {
        return lastPassedJob;
    }

    public String getLastPassedToken() {
        return lastPassedToken;
    }
}
