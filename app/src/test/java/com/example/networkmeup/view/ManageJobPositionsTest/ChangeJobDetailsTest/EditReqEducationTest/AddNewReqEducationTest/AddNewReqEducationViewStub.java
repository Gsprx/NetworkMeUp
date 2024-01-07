package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqEducationTest.AddNewReqEducationTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation.AddNewReqEducationView;

public class AddNewReqEducationViewStub implements AddNewReqEducationView {
    private String description;
    private int levelOfStudies;
    private int expertiseArea;
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
    public int getExpertiseArea() {
        return expertiseArea;
    }

    @Override
    public int getLevelOfStudies() {
        return levelOfStudies;
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

    public void setLevelOfStudies(int levelOfStudies) {
        this.levelOfStudies = levelOfStudies;
    }

    public void setExpertiseArea(int expertiseArea) {
        this.expertiseArea = expertiseArea;
    }
}
