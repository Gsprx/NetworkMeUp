package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditLanguageKnowledgeTest.AddNewLanguageKnowledgeTest;

import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.AddNewLanguageKnowledge.AddNewLanguageKnowledgeView;

/**
 * This class represents a stub implementation of the AddNewLanguageKnowledgeView interface.
 * It is used for testing or providing a basic implementation of the view interface.
 */
public class AddNewLanguageKnowledgeViewStub implements AddNewLanguageKnowledgeView {
    private String description;
    private LevelOfKnowledge levelOfKnowledge;
    private int language;
    private String lastTokenPassed;
    private String lastDialogMessage;
    @Override
    public void successfulAdd(String message, String userToken) {
        lastDialogMessage = message;
        lastTokenPassed = userToken;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getLanguage() {
        return language;
    }

    @Override
    public LevelOfKnowledge getLevelOfKnowledge() {
        return levelOfKnowledge;
    }

    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    public String getLastDialogMessage() {
        return lastDialogMessage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLevelOfKnowledge(LevelOfKnowledge lvlOfKnowledge) {
        this.levelOfKnowledge = lvlOfKnowledge;
    }

    public void setLanguage(int lang) {
        this.language = lang;
    }
}
