package com.example.networkmeup.view.SearchJobs;

import com.example.networkmeup.domain.Job;

/**
 * Interface representing the contract for the Search Jobs View in the application.
 * This interface defines methods for handling various outcomes related to job search functionality.
 */
public interface SearchJobsView {

    /**
     * Callback method to handle the scenario when no jobs are found during a search.
     *
     * @param message   A descriptive message explaining the lack of job results.
     * @param userToken The authentication token of the user performing the search.
     */
    public void noJobsFound(String message, String userToken);

    /**
     * Callback method to display the details of a specific job.
     *
     * @param userToken The authentication token of the user viewing the job details.
     * @param job       The Job object containing details of the job to be displayed.
     */
    public void showJobDetails(String userToken, Job job);
}
