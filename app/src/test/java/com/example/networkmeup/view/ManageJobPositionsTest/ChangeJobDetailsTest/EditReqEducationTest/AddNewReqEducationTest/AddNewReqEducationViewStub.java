package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqEducationTest.AddNewReqEducationTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation.AddNewReqEducationView;

/**
 * This class is a stub of the AddNewReqEducationView interface for testing purposes.
 */
public class AddNewReqEducationViewStub implements AddNewReqEducationView {
    /**
     * The description of the education requirement.
     */
    private String description;

    /**
     * The level of studies required.
     */
    private int levelOfStudies;

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
     * Displays a success message after adding a new education requirement.
     *
     * @param message The success message.
     * @param userToken The token of the user.
     * @param job The job to which the education requirement was added.
     */
    @Override
    public void successfulAdd(String message, String userToken, Job job) {
        lastDialogMessage = message;
        lastTokenPassed = userToken;
        lastPassedJob = job;
    }

    /**
     * Returns the description of the education requirement.
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
     * Returns the level of studies required.
     *
     * @return The level of studies.
     */
    @Override
    public int getLevelOfStudies() {
        return levelOfStudies;
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
     * Returns the last job passed to the view.
     *
     * @return The last job.
     */
    public Job getLastPassedJob() {
        return lastPassedJob;
    }

    /**
     * Sets the description of the education requirement.
     *
     * @param description The description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the level of studies required.
     *
     * @param levelOfStudies The level of studies.
     */
    public void setLevelOfStudies(int levelOfStudies) {
        this.levelOfStudies = levelOfStudies;
    }

    /**
     * Sets the area of expertise required.
     *
     * @param expertiseArea The area of expertise.
     */
    public void setExpertiseArea(int expertiseArea) {
        this.expertiseArea = expertiseArea;
    }
}

