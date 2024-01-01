package com.example.networkmeup.view.SearchJobs.ShowJobDetails;

public interface ShowJobsDetailsView {
    public void sendApplicationSuccess(String userToken);
    public String getCoverLetter();
    public void emptyCoverLetter(String message);
}
