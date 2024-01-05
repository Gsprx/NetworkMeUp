package com.example.networkmeup.view.ModifyCVTest.MOdifyCVEditWorkExperienceTest;

import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.ModifyCVEditWorkExperienceView;

public class ModifyCVEditWorkExperienceViewStub implements ModifyCVEditWorkExperienceView {
    private int changeClicks;
    private int addNewClicks;
    private int lastPositionPassed;
    private String lastTokenPassed;
    @Override
    public void changeWorkExperienceDetails(String userToken, int position) {
        changeClicks++;
        lastPositionPassed = position;
        lastTokenPassed = userToken;
    }

    @Override
    public void addNewWorkExperience(String userToken) {
        addNewClicks++;
        lastTokenPassed = userToken;
    }

    public int getChangeClicks() {
        return changeClicks;
    }

    public int getAddNewClicks() {
        return addNewClicks;
    }

    public int getLastPositionPassed() {
        return lastPositionPassed;
    }

    public String getLastTokenPassed() {
        return lastTokenPassed;
    }
}
