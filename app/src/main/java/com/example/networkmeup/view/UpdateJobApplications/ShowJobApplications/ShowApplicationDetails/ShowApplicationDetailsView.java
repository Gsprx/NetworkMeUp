package com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowApplicationDetails;

import com.example.networkmeup.domain.Job;

/**
 * Interface representing the contract for the Show Application Details View in the application.
 * This interface defines methods for handling various outcomes related to viewing job application details.
 */
public interface ShowApplicationDetailsView {

    /**
     * Callback method to handle the scenario when an applicant is accepted for a job application.
     *
     * @param userToken The authentication token of the user performing the action.
     * @param job       The Job object representing the details of the job.
     */
    void acceptedApplicant(String userToken, Job job);

    /**
     * Callback method to handle the scenario when an applicant is rejected for a job application.
     *
     * @param userToken The authentication token of the user performing the action.
     * @param job       The Job object representing the details of the job.
     */
    void rejectedApplicant(String userToken, Job job);
}
