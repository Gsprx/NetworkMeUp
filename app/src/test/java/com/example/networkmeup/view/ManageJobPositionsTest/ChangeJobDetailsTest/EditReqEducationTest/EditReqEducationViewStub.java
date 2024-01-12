package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqEducationTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.EditReqEducationView;

/**
 * This class is a stub of the EditReqEducationView interface for testing purposes.
 */
public class EditReqEducationViewStub implements EditReqEducationView {
    /**
     * The number of times the change education details method was called.
     */
    private int changeClicks;

    /**
     * The number of times the add new education method was called.
     */
    private int addNewClicks;

    /**
     * The last position passed to the view.
     */
    private int lastPositionPassed;

    /**
     * The last token passed to the view.
     */
    private String lastTokenPassed;

    /**
     * The last job passed to the view.
     */
    private Job lastJobPassed;

    /**
     * Changes the details of an education requirement.
     *
     * @param userToken The token of the user.
     * @param position The position of the education requirement.
     * @param job The job to which the education requirement belongs.
     */
    @Override
    public void changeEductionDetails(String userToken, int position, Job job) {
        changeClicks++;
        lastPositionPassed = position;
        lastTokenPassed = userToken;
        lastJobPassed = job;
    }

    /**
     * Adds a new education requirement.
     *
     * @param userToken The token of the user.
     * @param job The job to which the education requirement will be added.
     */
    @Override
    public void addNewEducation(String userToken, Job job) {
        addNewClicks++;
        lastTokenPassed = userToken;
        lastJobPassed = job;
    }

    /**
     * Returns the number of times the change education details method was called.
     *
     * @return The number of clicks.
     */
    public int getChangeClicks() {
        return changeClicks;
    }

    /**
     * Returns the number of times the add new education method was called.
     *
     * @return The number of clicks.
     */
    public int getAddNewClicks() {
        return addNewClicks;
    }

    /**
     * Returns the last position passed to the view.
     *
     * @return The last position.
     */
    public int getLastPositionPassed() {
        return lastPositionPassed;
    }

    /**
     * Returns the last token passed to the view.
     *
     * @return The last token.
     */
    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    /**
     * Returns the last job passed to the view.
     *
     * @return The last job.
     */
    public Job getLastJobPassed() {
        return lastJobPassed;
    }
}

