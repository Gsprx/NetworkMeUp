package com.example.networkmeup.view.UpdateJobApplications;

import com.example.networkmeup.domain.Job;

/**
 * Interface for the Update Job Applications View, defining a method to display job applications.
 */
public interface UpdateJobApplicationsView {

    /**
     * Displays the job applications for a specific job.
     *
     * @param userToken The authentication token of the user viewing the job applications.
     * @param job       The Job object representing the details of the job associated with the applications.
     */
    void showJobApplications(String userToken, Job job);
}
