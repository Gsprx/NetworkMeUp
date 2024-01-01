package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditEducationTest.ChangeEducationDetailsTest;

import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.ChangeEducationDetails.ChangeEducationDetailsView;

public class ChangeEducationDetailsViewStub implements ChangeEducationDetailsView {
    private String description;
    private int levelOfStudies;
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
    public int getLevelOfStudies() {
        return levelOfStudies;
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

    public void setLevelOfStudies(int levelOfStudies) {
        this.levelOfStudies = levelOfStudies;
    }

    public void setExpertiseArea(int expertiseArea) {
        this.expertiseArea = expertiseArea;
    }
}
