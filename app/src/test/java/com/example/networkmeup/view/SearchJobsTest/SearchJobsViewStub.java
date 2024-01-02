package com.example.networkmeup.view.SearchJobsTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.SearchJobs.SearchJobsView;

public class SearchJobsViewStub implements SearchJobsView {
    private String lastTokenPassed;
    private String lastMessagePassed;
    private String jobDescription;
    private String jobTitle;

    @Override
    public void noJobsFound(String message, String userToken) {
        lastMessagePassed = message;
        lastTokenPassed = userToken;
    }

    @Override
    public void showJobDetails(String userToken, Job job) {
        lastTokenPassed = userToken;
        jobDescription = job.getDescription();
        jobTitle = job.getTitle();
    }

    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    public String getLastMessagePassed() {
        return lastMessagePassed;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
