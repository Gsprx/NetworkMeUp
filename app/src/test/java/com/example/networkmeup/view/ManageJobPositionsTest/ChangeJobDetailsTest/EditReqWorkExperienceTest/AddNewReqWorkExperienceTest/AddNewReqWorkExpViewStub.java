package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqWorkExperienceTest.AddNewReqWorkExperienceTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.AddNewReqWorkExperience.AddNewReqWorkExperienceView;

public class AddNewReqWorkExpViewStub implements AddNewReqWorkExperienceView {
    private String description;
    private int yearsAtwork;
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
    public int getYears() {
        return yearsAtwork;
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

    public void setYears(int Years) {
        this.yearsAtwork = Years;
    }

    public void setExpertiseArea(int expertiseArea) {
        this.expertiseArea = expertiseArea;
    }
}
