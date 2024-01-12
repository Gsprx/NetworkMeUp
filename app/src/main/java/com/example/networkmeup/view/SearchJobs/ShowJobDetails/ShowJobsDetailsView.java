package com.example.networkmeup.view.SearchJobs.ShowJobDetails;

/**
 * Interface representing the contract for the Show Job Details View in the application.
 * This interface defines methods for handling various outcomes related to job details and application submission.
 */
public interface ShowJobsDetailsView {

    /**
     * Callback method to handle the scenario when a job application is successfully submitted.
     *
     * @param userToken The authentication token of the user who submitted the application.
     */
    public void sendApplicationSuccess(String userToken);

    /**
     * Method to retrieve the cover letter entered by the user for job application.
     *
     * @return A string representing the cover letter entered by the user.
     */
    public String getCoverLetter();

    /**
     * Callback method to handle the scenario when the user attempts to submit an empty cover letter.
     *
     * @param message A descriptive message explaining the issue with the empty cover letter.
     */
    public void emptyCoverLetter(String message);
}
