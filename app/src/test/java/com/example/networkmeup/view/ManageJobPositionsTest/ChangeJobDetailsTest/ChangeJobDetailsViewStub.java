package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsView;

/**
 * This class implements the ChangeJobDetailsView interface.
 * It is used to change the job details of a user.
 */
public class ChangeJobDetailsViewStub implements ChangeJobDetailsView {
    private String lastTokenPassed;
    private String desc = "";
    private String title = "";
    private int availab = 0;
    private Job lastJobPassed;
    private int editEducationClicks;
    private int editWorkExpClicks;
    private int editLangKnowClicks;
    private int saveClicks;
    private int deleteClicks;

    /**
     * Gets the job description.
     *
     * @return The job description.
     */
    @Override
    public String getJobDescription() {
        return desc;
    }

    /**
     * Gets the job title.
     *
     * @return The job title.
     */
    @Override
    public String getJobTitle() {
        return title;
    }

    /**
     * Gets the availability of the job.
     *
     * @return The availability.
     */
    @Override
    public int getAvailability() {
        return availab;
    }

    /**
     * Edits the education of a job.
     *
     * @param job The job to be edited.
     * @param userToken The token of the user.
     */
    @Override
    public void editEducation(Job job, String userToken) {
        editEducationClicks++;
        lastJobPassed = job;
        lastTokenPassed = userToken;
    }

    /**
     * Edits the work experience of a job.
     *
     * @param job The job to be edited.
     * @param userToken The token of the user.
     */
    @Override
    public void editWorkExperience(Job job, String userToken) {
        editWorkExpClicks++;
        lastJobPassed = job;
        lastTokenPassed = userToken;
    }

    /**
     * Edits the language knowledge of a job.
     *
     * @param job The job to be edited.
     * @param userToken The token of the user.
     */
    @Override
    public void editLangKnowledge(Job job, String userToken) {
        editLangKnowClicks++;
        lastJobPassed = job;
        lastTokenPassed = userToken;
    }

    /**
     * Deletes a job successfully.
     *
     * @param userToken The token of the user.
     */
    @Override
    public void successfulDelete(String userToken) {
        deleteClicks++;
        lastTokenPassed = userToken;
    }

    /**
     * Saves a job successfully.
     *
     * @param userToken The token of the user.
     */
    @Override
    public void successfulSave(String userToken) {
        saveClicks++;
        lastTokenPassed = userToken;
    }

    /**
     * Gets the number of times a job was saved.
     *
     * @return The number of saves.
     */
    public int getSaveClicks() {
        return saveClicks;
    }

    /**
     * Gets the number of times a job was deleted.
     *
     * @return The number of deletions.
     */
    public int getDeleteClicks() {
        return deleteClicks;
    }

    /**
     * Gets the last token passed to the editEducation, editWorkExperience, editLangKnowledge, successfulDelete, or successfulSave method.
     *
     * @return The last token.
     */
    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    /**
     * Gets the last job passed to the editEducation, editWorkExperience, or editLangKnowledge method.
     *
     * @return The last job.
     */
    public Job getLastJobPassed() {
        return lastJobPassed;
    }

    /**
     * Gets the number of times the education of a job was edited.
     *
     * @return The number of edits.
     */
    public int getEditEducationClicks() {
        return editEducationClicks;
    }

    /**
     * Gets the number of times the work experience of a job was edited.
     *
     * @return The number of edits.
     */
    public int getEditWorkExpClicks() {
        return editWorkExpClicks;
    }

    /**
     * Gets the number of times the language knowledge of a job was edited.
     *
     * @return The number of edits.
     */
    public int getEditLangKnowClicks() {
        return editLangKnowClicks;
    }

    /**
     * Sets the description of a job.
     *
     * @param desc The description to be set.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Sets the title of a job.
     *
     * @param title The title to be set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the availability of a job.
     *
     * @param availab The availability to be set.
     */
    public void setAvailab(int availab) {
        this.availab = availab;
    }
}

