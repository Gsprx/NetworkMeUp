package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditEducationTest.AddNewEducationTest;

import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.AddNewEducation.AddNewEducationView;

public class AddNewEducationViewStub implements AddNewEducationView {
    private String description;
    private int levelOfStudies;
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
    public int getLevelOfStudies() {
        return levelOfStudies;
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
