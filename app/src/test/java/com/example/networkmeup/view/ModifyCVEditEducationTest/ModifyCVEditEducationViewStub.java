package com.example.networkmeup.view.ModifyCVEditEducationTest;

import com.example.networkmeup.view.ModifyCVEditEducation.ModifyCVEditEducationView;

public class ModifyCVEditEducationViewStub implements ModifyCVEditEducationView {
    private int changeClicks;
    private int addNewClicks;
    private int lastPositionPassed;
    private String lastTokenPassed;
    @Override
    public void changeEductionDetails(String userToken, int position) {
        changeClicks++;
        lastPositionPassed = position;
        lastTokenPassed = userToken;
    }

    @Override
    public void addNewEducation(String userToken) {
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
