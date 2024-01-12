package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqWorkExperienceTest.AddNewReqWorkExperienceTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.AddNewReqWorkExperience.AddNewReqWorkExperienceView;

/**
 * This class is a stub of the AddNewReqWorkExperienceView interface for testing purposes.
 */
public class AddNewReqWorkExpViewStub implements AddNewReqWorkExperienceView {
    /**
     * The description of the work experience requirement.
     */
    private String description;

    /**
     * The number of years of work experience required.
     */
    private int yearsAtwork;

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
     * Displays a success message after adding a new work experience requirement.
     *
     * @param message The success message.
     * @param userToken The token of the user.
     * @param job The job to which the work experience requirement was added.
     */
    @Override
    public void successfulAdd(String message, String userToken, Job job) {
        lastDialogMessage = message;
        lastTokenPassed = userToken;
        lastPassedJob = job;
    }

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
        return yearsAtwork;
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
     * @param Years The number of years.
     */
    public void setYears(int Years) {
        this.yearsAtwork = Years;
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

