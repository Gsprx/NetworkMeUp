package com.example.networkmeup.view.UpdateJobApplications;

import com.example.networkmeup.domain.Job;

/**
 * Presenter class for handling interactions between the Update Job Applications View and the data models.
 * This class manages the actions related to updating and displaying job applications.
 */
public class UpdateJobApplicationsPresenter {
    private UpdateJobApplicationsView view;
    private String userToken;

    /**
     * Constructor for the UpdateJobApplicationsPresenter class.
     *
     * @param view      The associated UpdateJobApplicationsView interface implementation.
     * @param userToken The authentication token of the user updating job applications.
     */
    public UpdateJobApplicationsPresenter(UpdateJobApplicationsView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    /**
     * Method called when an individual job is clicked.
     * Opens the job applications associated with the selected job.
     *
     * @param job The Job object representing the details of the selected job.
     *
     */
    public void onItemClick(Job job){
        view.showJobApplications(userToken, job);
    }
}
