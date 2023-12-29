package com.example.networkmeup.view.ModifyCVTest;

import com.example.networkmeup.view.ModifyCV.ModifyCVView;

public class ModifyCVViewStub implements ModifyCVView {
    private String lastTokenPassed;
    private int editEduClicks;
    private int editWorkExpClicks;
    private int editLangKnowClicks;
    @Override
    public void editEducation(String userToken) {
        lastTokenPassed = userToken;
        editEduClicks++;
    }

    @Override
    public void editWorkExperience(String userToken) {
        lastTokenPassed = userToken;
        editWorkExpClicks++;
    }

    @Override
    public void editLanguageKnowledge(String userToken) {
        lastTokenPassed = userToken;
        editLangKnowClicks++;
    }

    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    public int getEditEduClicks() {
        return editEduClicks;
    }

    public int getEditWorkExpClicks() {
        return editWorkExpClicks;
    }

    public int getEditLangKnowClicks() {
        return editLangKnowClicks;
    }
}
