package com.example.networkmeup.view.SearchJobs;

import com.example.networkmeup.domain.Job;

public interface SearchJobsView {
    public void noJobsFound(String message, String userToken);
    public void showJobDetails(String userToken, Job job);
}
