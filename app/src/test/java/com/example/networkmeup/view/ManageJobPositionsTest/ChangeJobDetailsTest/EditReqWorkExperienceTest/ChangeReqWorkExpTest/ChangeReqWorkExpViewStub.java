package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqWorkExperienceTest.ChangeReqWorkExpTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.ChangeReqWorkExpDetails.ChangeReqWorkExpDetailsView;

/**
 * This class is a stub of the ChangeReqWorkExpDetailsView interface for testing purposes.
 */
public class ChangeReqWorkExpViewStub implements ChangeReqWorkExpDetailsView {
    /**
     * The description of the work experience requirement.
     */
    private String description;

    /**
     * The number of years of work experience required.
     */
    private int Years;

    /**
     * The area of expertise required.
     */
    private int expertiseArea;

    /**
     * The last token passed to the view.
     */
    private String lastTokenPassed;

    /**
     * The last dialog message displayed by the view.
     */
    private String lastDialogMessage;

    /**
     * The last job passed to the view.
     */
    private Job lastPassedJob;

    /**
     * Returns the description of the work experience requirement.
     *
     * @return The description.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Returns the area of expertise required.
     *
     * @return The area of expertise.
     */
    @Override
    public int getExpertiseArea() {
        return expertiseArea;
    }

    /**
     * Returns the number of years of work experience required.
     *
     * @return The number of years.
     */
    @Override
    public int getYears() {
        return Years;
    }

    /**
     * Displays a success message after deleting a work experience requirement.
     *
     * @param message The success message.
     * @param userToken The token of the user.
     * @param job The job from which the work experience requirement was deleted.
     */
    @Override
    public void successfulDelete(String message, String userToken, Job job) {
        lastDialogMessage = message;
        lastTokenPassed = userToken;
        lastPassedJob = job;
    }

    /**
     * Displays a success message after saving a work experience requirement.
     *
     * @param message The success message.
     * @param userToken The token of the user.
     * @param job The job to which the work experience requirement was saved.
     */
    @Override
    public void successfulSave(String message, String userToken, Job job) {
        lastDialogMessage = message;
        lastTokenPassed = userToken;
        lastPassedJob = job;
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
     * Returns the last dialog message displayed by the view.
     *
     * @return The last dialog message.
     */
    public String getLastDialogMessage() {
        return lastDialogMessage;
    }

    /**
     * Sets the description of the work experience requirement.
     *
     * @param description The description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the number of years of work experience required.
     *
     * @param years The number of years.
     */
    public void setYears(int years) {
        this.Years = years;
    }

    /**
     * Sets the area of expertise required.
     *
     * @param expertiseArea The area of expertise.
     */
    public void setExpertiseArea(int expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    /**
     * Returns the last job passed to the view.
     *
     * @return The last job.
     */
    public Job getLastPassedJob() {
        return lastPassedJob;
    }
}
