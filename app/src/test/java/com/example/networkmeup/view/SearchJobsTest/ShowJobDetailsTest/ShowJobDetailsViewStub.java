package com.example.networkmeup.view.SearchJobsTest.ShowJobDetailsTest;

import com.example.networkmeup.view.SearchJobs.ShowJobDetails.ShowJobsDetailsView;

public class ShowJobDetailsViewStub implements ShowJobsDetailsView {
    private String lastTokenPassed;
    private String lastMessagePassed;
    private String coverLetter;
    @Override
    public void sendApplicationSuccess(String userToken) {
        lastTokenPassed = userToken;
    }
    @Override
    public String getCoverLetter() {
        return coverLetter;
    }

    @Override
    public void emptyCoverLetter(String message) {
        lastMessagePassed = message;
    }

    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    public String getLastMessagePassed() {
        return lastMessagePassed;
    }

    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }
}
