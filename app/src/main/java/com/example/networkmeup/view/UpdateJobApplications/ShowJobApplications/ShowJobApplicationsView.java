package com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications;

import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Job;

/**
 * Interface for the Show Job Applications View, defining methods to display job applications.
 */
public interface ShowJobApplicationsView {

    /**
     * Displays the details of a job application.
     *
     * @param userToken   The authentication token of the user viewing the application details.
     * @param job         The Job object representing the details of the job associated with the application.
     * @param application The Application object representing the details of the job application.
     */
    void showApplicationDetails(String userToken, Job job, Application application);
}
