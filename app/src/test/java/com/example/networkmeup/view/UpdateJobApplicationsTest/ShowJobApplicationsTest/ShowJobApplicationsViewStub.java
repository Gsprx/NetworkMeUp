package com.example.networkmeup.view.UpdateJobApplicationsTest.ShowJobApplicationsTest;

import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowJobApplicationsPresenter;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowJobApplicationsView;

import java.util.ArrayList;

public class ShowJobApplicationsViewStub implements ShowJobApplicationsView {
    private String lastPassedToken;
    private Job lastPassedJob;
    private Application lastPassedApplication;
    @Override
    public void showApplicationDetails(String userToken, Job job, Application application) {
        lastPassedToken = userToken;
        lastPassedJob = job;
        lastPassedApplication = application;
    }

    public Job getLastPassedJob() {
        return lastPassedJob;
    }

    public String getLastPassedToken() {
        return lastPassedToken;
    }

    public Application getLastPassedApplication() {
        return lastPassedApplication;
    }
}
