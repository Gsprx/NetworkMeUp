package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqWorkExperienceTest.ChangeReqWorkExpTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.ChangeReqWorkExperienceDetails.ChangeReqWorkExperienceDetailsView;

public class ChangeReqWorkExpViewStub implements ChangeReqWorkExperienceDetailsView {
    private String description;
    private int Years;
    private int expertiseArea;
    private String lastTokenPassed;
    private String lastDialogMessage;
    private Job lastPassedJob;
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getExpertiseArea() {
        return expertiseArea;
    }

    @Override
    public int getYears() {
        return Years;
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

    public void setYears(int years) {
        this.Years = years;
    }

    public void setExpertiseArea(int expertiseArea) {
        this.expertiseArea = expertiseArea;
    }

    public Job getLastPassedJob() {
        return lastPassedJob;
    }
}
