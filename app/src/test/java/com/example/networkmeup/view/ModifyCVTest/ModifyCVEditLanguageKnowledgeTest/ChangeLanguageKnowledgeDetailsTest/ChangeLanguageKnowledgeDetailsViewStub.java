package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditLanguageKnowledgeTest.ChangeLanguageKnowledgeDetailsTest;

import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ChangeLanguageKnowledgeDetails.ChangeLanguageKnowledgeDetailsView;

/**
 * Stub implementation of the ChangeLanguageKnowledgeDetailsView interface for testing purposes.
 * Simulates the behavior of the view to facilitate testing of presenter logic.
 */
public class ChangeLanguageKnowledgeDetailsViewStub implements ChangeLanguageKnowledgeDetailsView {
    private String description;
    private int language;
    private LevelOfKnowledge levelOfKnowledge;
    private String lastSuccessfulDeleteMessage;
    private String lastSuccessfulSaveMessage;
    private String lastUserToken;

    /**
     * Get the description provided by the user.
     *
     * @return The description
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Set the description to simulate user input.
     *
     * @param description The description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the selected language.
     *
     * @return The selected language index
     */
    @Override
    public int getLanguage() {
        return language;
    }

    /**
     * Set the selected language index to simulate user input.
     *
     * @param language The selected language index
     */
    public void setLanguage(int language) {
        this.language = language;
    }

    /**
     * Get the selected level of knowledge.
     *
     * @return The selected LevelOfKnowledge
     */
    @Override
    public LevelOfKnowledge getLevelOfKnowledge() {
        return levelOfKnowledge;
    }

    /**
     * Set the selected level of knowledge to simulate user input.
     *
     * @param levelOfKnowledge The selected LevelOfKnowledge
     */
    public void setLevelOfKnowledge(LevelOfKnowledge levelOfKnowledge) {
        this.levelOfKnowledge = levelOfKnowledge;
    }

    /**
     * Simulates a successful deletion with the provided message and user token.
     *
     * @param message   The success message
     * @param userToken The user token
     */
    @Override
    public void successfulDelete(String message, String userToken) {
        lastSuccessfulDeleteMessage = message;
        lastUserToken = userToken;
        // Additional logic can be added here for successful deletion if needed
    }

    /**
     * Simulates a successful save operation with the provided message and user token.
     *
     * @param message   The success message
     * @param userToken The user token
     */
    @Override
    public void successfulSave(String message, String userToken) {
        lastSuccessfulSaveMessage = message;
        lastUserToken = userToken;
        // Additional logic can be added here for successful save if needed
    }

    /**
     * Get the last successful delete message for testing verification.
     *
     * @return The last successful delete message
     */
    public String getLastSuccessfulDeleteMessage() {
        return lastSuccessfulDeleteMessage;
    }

    /**
     * Get the last successful save message for testing verification.
     *
     * @return The last successful save message
     */
    public String getLastSuccessfulSaveMessage() {
        return lastSuccessfulSaveMessage;
    }

    /**
     * Get the last user token for testing verification.
     *
     * @return The last user token
     */
    public String getLastUserToken() {
        return lastUserToken;
    }
}

