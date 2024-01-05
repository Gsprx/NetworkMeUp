package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsView;

public class ChangeJobDetailsViewStub implements ChangeJobDetailsView {
    private String lastTokenPassed;
    private String desc = "";
    private String title = "";
    private int availab = 0;
    private Job lastJobPassed;
    private int editEducationClicks;
    private int editWorkExpClicks;
    private int editLangKnowClicks;
    private int saveClicks;
    private int deleteClicks;

    @Override
    public String getJobDescription() {
        return desc;
    }

    @Override
    public String getJobTitle() {
        return title;
    }

    @Override
    public int getAvailability() {
        return availab;
    }

    @Override
    public void editEducation(Job job, String userToken) {
        editEducationClicks++;
        lastJobPassed = job;
        lastTokenPassed = userToken;
    }

    @Override
    public void editWorkExperience(Job job, String userToken) {
        editWorkExpClicks++;
        lastJobPassed = job;
        lastTokenPassed = userToken;
    }

    @Override
    public void editLangKnowledge(Job job, String userToken) {
        editLangKnowClicks++;
        lastJobPassed = job;
        lastTokenPassed = userToken;
    }

    @Override
    public void successfulDelete(String userToken) {
        deleteClicks++;
        lastTokenPassed = userToken;
    }

    @Override
    public void successfulSave(String userToken) {
        saveClicks++;
        lastTokenPassed = userToken;
    }

    public int getSaveClicks() {
        return saveClicks;
    }

    public int getDeleteClicks() {
        return deleteClicks;
    }

    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    public Job getLastJobPassed() {
        return lastJobPassed;
    }

    public int getEditEducationClicks() {
        return editEducationClicks;
    }

    public int getEditWorkExpClicks() {
        return editWorkExpClicks;
    }

    public int getEditLangKnowClicks() {
        return editLangKnowClicks;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAvailab(int availab) {
        this.availab = availab;
    }
}
