package com.example.networkmeup.view.ModifyCVTest.ModifyCVEditLanguageKnowledgeTest;

import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ModifyCVEditLanguageKnowledgeView;

public class ModifyCVEditLanguageKnowledgeViewStub implements ModifyCVEditLanguageKnowledgeView {
    private int changeClicks;
    private int addNewClicks;
    private int lastPositionPassed;
    private String lastTokenPassed;
    @Override
    public void changeLanguageKnowledgeDetails(String userToken, int position) {
        changeClicks++;
        lastPositionPassed = position;
        lastTokenPassed = userToken;
    }

    @Override
    public void addNewLanguageKnowledge(String userToken) {
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
