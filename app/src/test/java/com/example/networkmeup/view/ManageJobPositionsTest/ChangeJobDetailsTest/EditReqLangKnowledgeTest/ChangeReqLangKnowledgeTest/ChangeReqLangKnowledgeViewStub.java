package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqLangKnowledgeTest.ChangeReqLangKnowledgeTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.ChangeReqLangKnowledgeDetails.ChangeReqLangKnowledgeDetailsView;

public class ChangeReqLangKnowledgeViewStub implements ChangeReqLangKnowledgeDetailsView {
    private String description;
    private LevelOfKnowledge levelOfKnowledge;
    private int language;
    private String lastTokenPassed;
    private String lastDialogMessage;
    private Job lastPassedJob;
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

    @Override
    public void successfulDelete(String message, String userToken, Job job) {
        lastDialogMessage = message;
        lastTokenPassed = userToken;
        lastPassedJob = job;
    }

    @Override
    public void successfulSave(String message, String userToken, Job job) {
        lastDialogMessage = message;
        lastTokenPassed = userToken;
        lastPassedJob = job;
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

    public void setLanguage(int Language) {
        this.language = Language;
    }

    public Job getLastPassedJob() {
        return lastPassedJob;
    }
}
