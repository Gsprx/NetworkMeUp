package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqLangKnowledgeTest.AddNewReqLangKnowTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.AddNewReqLangKnowledge.AddNewReqLangKnowledgeView;

public class AddNewReqLangKnowViewStub implements AddNewReqLangKnowledgeView {
    private String description;
    private LevelOfKnowledge levelOfKnowledge;
    private int language;
    private String lastTokenPassed;
    private String lastDialogMessage;
    private Job lastPassedJob;
    @Override
    public void successfulAdd(String message, String userToken, Job job) {
        lastDialogMessage = message;
        lastTokenPassed = userToken;
        lastPassedJob = job;
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

    public Job getLastPassedJob() {
        return lastPassedJob;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLevelOfKnowledge(LevelOfKnowledge LevelOfKnowledge) {
        this.levelOfKnowledge = LevelOfKnowledge;
    }

    public void setLanguage(int Language) {
        this.language = Language;
    }
}
