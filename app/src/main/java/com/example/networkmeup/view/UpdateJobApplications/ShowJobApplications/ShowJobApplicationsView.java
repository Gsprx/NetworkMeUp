package com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications;

import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Job;

public interface ShowJobApplicationsView {
    void showApplicationDetails(String userToken, Job job, Application application);
}
