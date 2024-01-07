package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditWorkExperienceTest.ChangeWorkExperienceDetailsTest;

import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.ChangeWorkExperienceDetails.ChangeWorkExperienceDetailsView;

public class ChangeWorkExperienceDetailsViewStub implements ChangeWorkExperienceDetailsView {
    private String description;
    private int YearsAtWork;
    private int expertiseArea;
    private String lastTokenPassed;
    private String lastDialogMessage;
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

    @Override
    public void successfulDelete(String message, String userToken) {
        lastDialogMessage = message;
        lastTokenPassed = userToken;

    }

    @Override
    public void successfulSave(String message, String userToken) {
        lastDialogMessage = message;
        lastTokenPassed = userToken;
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

    public void setYearsAtWork(int YearsAtwork) {
        this.YearsAtWork = YearsAtwork;
    }

    public void setExpertiseArea(int expertiseArea) {
        this.expertiseArea = expertiseArea;
    }
}
