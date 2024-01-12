package com.example.networkmeup.view.ManageJobPositions;

import com.example.networkmeup.domain.Job;

/**
 * This class is responsible for managing job positions.
 */
public class ManageJobPositionsPresenter {
    /**
     * The view associated with this presenter.
     */
    private ManageJobPositionsView view;

    /**
     * The token associated with the user.
     */
    private String userToken;

    /**
     * Constructs a new ManageJobPositionsPresenter with the specified view and user token.
     *
     * @param view The view to be managed by this presenter.
     * @param userToken The token of the user.
     */
    public ManageJobPositionsPresenter(ManageJobPositionsView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    /**
     * Adds a new job position.
     */
    public void onAddNew(){
        view.addNewJobPosition(userToken);
    }

    /**
     * Changes the details of a job.
     *
     * @param job The job whose details are to be changed.
     */
    public void onItemClick(Job job){
        view.changeJobDetails(userToken, job);
    }
}
