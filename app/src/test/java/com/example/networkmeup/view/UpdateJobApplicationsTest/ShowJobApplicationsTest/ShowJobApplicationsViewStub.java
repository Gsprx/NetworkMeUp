package com.example.networkmeup.view.UpdateJobApplicationsTest.ShowJobApplicationsTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowJobApplicationsView;

public class ShowJobApplicationsViewStub implements ShowJobApplicationsView {
    private String lastPassedToken;
    private Job lastPassedJob;
    private int lastPassedPosition;
    @Override
    public void showApplicationDetails(String userToken, Job job, int position) {
        lastPassedToken = userToken;
        lastPassedJob = job;
        lastPassedPosition = position;
    }

    public Job getLastPassedJob() {
        return lastPassedJob;
    }

    public String getLastPassedToken() {
        return lastPassedToken;
    }

    public int getLastPassedPosition() {
        return lastPassedPosition;
    }
}
