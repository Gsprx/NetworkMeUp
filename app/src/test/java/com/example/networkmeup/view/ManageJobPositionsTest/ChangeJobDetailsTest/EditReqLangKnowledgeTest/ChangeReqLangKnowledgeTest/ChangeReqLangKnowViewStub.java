package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqLangKnowledgeTest.ChangeReqLangKnowledgeTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.ChangeReqLangKnowledgeDetails.ChangeReqLangKnowledgeDetailsView;

/**
 * This class is a stub of the ChangeReqLangKnowledgeDetailsView interface for testing purposes.
 */
public class ChangeReqLangKnowViewStub implements ChangeReqLangKnowledgeDetailsView {
    /**
     * The description of the language knowledge requirement.
     */
    private String description;

    /**
     * The level of knowledge required.
     */
    private LevelOfKnowledge levelOfKnowledge;

    /**
     * The language required.
     */
    private int language;

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
     * Returns the description of the language knowledge requirement.
     *
     * @return The description.
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Returns the language required.
     *
     * @return The language.
     */
    @Override
    public int getLanguage() {
        return language;
    }

    /**
     * Returns the level of knowledge required.
     *
     * @return The level of knowledge.
     */
    @Override
    public LevelOfKnowledge getLevelOfKnowledge() {
        return levelOfKnowledge;
    }

    /**
     * Displays a success message after deleting a language knowledge requirement.
     *
     * @param message The success message.
     * @param userToken The token of the user.
     * @param job The job from which the language knowledge requirement was deleted.
     */
    @Override
    public void successfulDelete(String message, String userToken, Job job) {
        lastDialogMessage = message;
        lastTokenPassed = userToken;
        lastPassedJob = job;
    }

    /**
     * Displays a success message after saving a language knowledge requirement.
     *
     * @param message The success message.
     * @param userToken The token of the user.
     * @param job The job to which the language knowledge requirement was saved.
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
     * Sets the description of the language knowledge requirement.
     *
     * @param description The description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the level of knowledge required.
     *
     * @param lvlOfKnowledge The level of knowledge.
     */
    public void setLevelOfKnowledge(LevelOfKnowledge lvlOfKnowledge) {
        this.levelOfKnowledge = lvlOfKnowledge;
    }

    /**
     * Sets the language required.
     *
     * @param Language The language.
     */
    public void setLanguage(int Language) {
        this.language = Language;
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

