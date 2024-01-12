package com.example.networkmeup.view.ManageJobPositions;

import com.example.networkmeup.domain.Job;

/**
 * This interface defines the methods for managing job positions.
 */
public interface ManageJobPositionsView {
    /**
     * Adds a new job position.
     *
     * @param userToken The token of the user.
     */
    public void addNewJobPosition(String userToken);

    /**
     * Changes the details of a job.
     *
     * @param userToken The token of the user.
     * @param job The job whose details are to be changed.
     */
    public void changeJobDetails(String userToken, Job job);
}
