package com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowApplicationDetails;

import com.example.networkmeup.domain.Job;

public interface ShowApplicationDetailsView {
    void acceptedApplicant(String userToken, Job job);

    void rejectedApplicant(String userToken, Job job);
}
