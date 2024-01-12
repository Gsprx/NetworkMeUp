package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqLangKnowledgeTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.EditReqLangKnowledgeView;

/**
 * This class is a stub of the EditReqLangKnowledgeView interface for testing purposes.
 */
public class EditReqLangKnowledgeViewStub implements EditReqLangKnowledgeView {
    /**
     * The number of times the change language knowledge details method was called.
     */
    private int changeClicks;

    /**
     * The number of times the add new language knowledge method was called.
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
     * Changes the details of a language knowledge requirement.
     *
     * @param userToken The token of the user.
     * @param position The position of the language knowledge requirement.
     * @param job The job to which the language knowledge requirement belongs.
     */
    @Override
    public void changeLanguageKnowledgeDetails(String userToken, int position, Job job) {
        changeClicks++;
        lastPositionPassed = position;
        lastTokenPassed = userToken;
        lastJobPassed = job;
    }

    /**
     * Adds a new language knowledge requirement.
     *
     * @param userToken The token of the user.
     * @param job The job to which the language knowledge requirement will be added.
     */
    @Override
    public void addNewLanguageKnowledge(String userToken, Job job) {
        addNewClicks++;
        lastTokenPassed = userToken;
        lastJobPassed = job;
    }

    /**
     * Returns the number of times the change language knowledge details method was called.
     *
     * @return The number of clicks.
     */
    public int getChangeClicks() {
        return changeClicks;
    }

    /**
     * Returns the number of times the add new language knowledge method was called.
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

