package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditLanguageKnowledgeTest.AddNewLanguageKnowledgeTest;

import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.AddNewLanguageKnowledge.AddNewLanguageKnowledgeView;

/**
 * This class represents a stub implementation of the AddNewLanguageKnowledgeView interface.
 * It is used for testing or providing a basic implementation of the view interface.
 */
public class AddNewLanguageKnowledgeViewStub implements AddNewLanguageKnowledgeView {
    private String description; // Holds the description of the language knowledge
    private int language; // Represents the selected language position in the list/enum
    private LevelOfKnowledge levelOfKnowledge; // Represents the selected level of knowledge
    private String successMessage; // Stores the success message upon successful addition
    private String userToken; // Stores the user token

    /**
     * Method invoked when language addition is successful.
     * @param message The success message to be displayed
     * @param userToken The user token associated with the addition
     */
    @Override
    public void successfulAdd(String message, String userToken) {
        this.successMessage = message;
        this.userToken = userToken;
        // Additional logic can be added here for successful addition if needed
    }

    /**
     * Gets the description of the language knowledge.
     * @return The description of the language knowledge
     */
    @Override
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the language knowledge.
     * @param description The description of the language knowledge to be set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the position/index representing the selected language.
     * @return The position/index representing the selected language
     */
    @Override
    public int getLanguage() {
        return language;
    }

    /**
     * Sets the position/index representing the selected language.
     * @param language The position/index representing the selected language to be set
     */
    public void setLanguage(int language) {
        this.language = language;
    }

    /**
     * Gets the level of knowledge for the selected language.
     * @return The level of knowledge for the selected language
     */
    @Override
    public LevelOfKnowledge getLevelOfKnowledge() {
        return levelOfKnowledge;
    }

    /**
     * Sets the level of knowledge for the selected language.
     * @param levelOfKnowledge The level of knowledge for the selected language to be set
     */
    public void setLevelOfKnowledge(LevelOfKnowledge levelOfKnowledge) {
        this.levelOfKnowledge = levelOfKnowledge;
    }

    /**
     * Gets the success message after language addition.
     * @return The success message after a successful addition
     */
    public String getSuccessMessage() {
        return successMessage;
    }

    /**
     * Gets the user token associated with the addition.
     * @return The user token associated with the addition
     */
    public String getUserToken() {
        return userToken;
    }
}
