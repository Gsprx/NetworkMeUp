package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqWorkExperienceTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.EditReqWorkExperienceView;

/**
 * This class implements the EditReqWorkExperienceView interface.
 * It is used to edit the work experience of a user.
 */
public class EditReqWorkExperienceViewStub implements EditReqWorkExperienceView {
    private int changeClicks;
    private int addNewClicks;
    private int lastPositionPassed;
    private String lastTokenPassed;
    private Job lastJobPassed;

    /**
     * Changes the work experience details of a user.
     *
     * @param userToken The token of the user.
     * @param position The position of the job in the list.
     * @param job The job to be changed.
     */
    @Override
    public void changeWorkExperienceDetails(String userToken, int position, Job job) {
        changeClicks++;
        lastPositionPassed = position;
        lastTokenPassed = userToken;
        lastJobPassed = job;
    }

    /**
     * Adds a new work experience for a user.
     *
     * @param userToken The token of the user.
     * @param job The job to be added.
     */
    @Override
    public void addNewWorkExperience(String userToken, Job job) {
        addNewClicks++;
        lastTokenPassed = userToken;
        lastJobPassed = job;
    }

    /**
     * Gets the number of times the work experience details were changed.
     *
     * @return The number of changes.
     */
    public int getChangeClicks() {
        return changeClicks;
    }

    /**
     * Gets the number of times a new work experience was added.
     *
     * @return The number of additions.
     */
    public int getAddNewClicks() {
        return addNewClicks;
    }

    /**
     * Gets the last position passed to the changeWorkExperienceDetails method.
     *
     * @return The last position.
     */
    public int getLastPositionPassed() {
        return lastPositionPassed;
    }

    /**
     * Gets the last token passed to the changeWorkExperienceDetails or addNewWorkExperience method.
     *
     * @return The last token.
     */
    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    /**
     * Gets the last job passed to the changeWorkExperienceDetails or addNewWorkExperience method.
     *
     * @return The last job.
     */
    public Job getLastJobPassed() {
        return lastJobPassed;
    }
}

