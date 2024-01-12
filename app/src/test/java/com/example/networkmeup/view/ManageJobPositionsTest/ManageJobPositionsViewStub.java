package com.example.networkmeup.view.ManageJobPositionsTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ManageJobPositionsView;

/**
 * This class implements the ManageJobPositionsView interface.
 * It is used to manage the job positions of a user.
 */
public class ManageJobPositionsViewStub implements ManageJobPositionsView {
    private String lastTokenPassed;
    private Job lastJobPassed;
    private int addNewClicks;
    private int changeJobClicks;

    /**
     * Adds a new job position for a user.
     *
     * @param userToken The token of the user.
     */
    @Override
    public void addNewJobPosition(String userToken) {
        addNewClicks++;
        lastTokenPassed = userToken;
        lastJobPassed = null;
    }

    /**
     * Changes the details of a job.
     *
     * @param userToken The token of the user.
     * @param job The job to be changed.
     */
    @Override
    public void changeJobDetails(String userToken, Job job) {
        changeJobClicks++;
        lastTokenPassed = userToken;
        lastJobPassed = job;
    }

    /**
     * Gets the last token passed to the addNewJobPosition or changeJobDetails method.
     *
     * @return The last token.
     */
    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    /**
     * Gets the last job passed to the changeJobDetails method.
     *
     * @return The last job.
     */
    public Job getLastJobPassed() {
        return lastJobPassed;
    }

    /**
     * Gets the number of times a new job position was added.
     *
     * @return The number of additions.
     */
    public int getAddNewClicks() {
        return addNewClicks;
    }

    /**
     * Gets the number of times the details of a job were changed.
     *
     * @return The number of changes.
     */
    public int getChangeJobClicks() {
        return changeJobClicks;
    }
}

