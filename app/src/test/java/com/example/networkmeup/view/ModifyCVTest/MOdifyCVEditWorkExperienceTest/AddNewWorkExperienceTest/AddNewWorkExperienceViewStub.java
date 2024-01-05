package com.example.networkmeup.view.ModifyCVTest.MOdifyCVEditWorkExperienceTest.AddNewWorkExperienceTest;

import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.AddNewWorkExperience.AddNewWorkExperienceView;

public class AddNewWorkExperienceViewStub implements AddNewWorkExperienceView {
    private String description;
    private int YearsAtWork;
    private int expertiseArea;
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
    public int getExpertiseArea() {
        return expertiseArea;
    }

    @Override
    public int getYearsAtWork() {
        return YearsAtWork;
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

    public void setYearsAtWork(int yearsAtWork) {
        this.YearsAtWork = YearsAtWork;
    }

    public void setExpertiseArea(int expertiseArea) {
        this.expertiseArea = expertiseArea;
    }
}
