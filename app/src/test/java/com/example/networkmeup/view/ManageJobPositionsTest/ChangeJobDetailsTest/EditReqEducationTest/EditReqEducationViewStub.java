package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqEducationTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.EditReqEducationView;

public class EditReqEducationViewStub implements EditReqEducationView {
    private int changeClicks;
    private int addNewClicks;
    private int lastPositionPassed;
    private String lastTokenPassed;
    private Job lastJobPassed;

    @Override
    public void changeEductionDetails(String userToken, int position, Job job) {
        changeClicks++;
        lastPositionPassed = position;
        lastTokenPassed = userToken;
        lastJobPassed = job;
    }

    @Override
    public void addNewEducation(String userToken, Job job) {
        addNewClicks++;
        lastTokenPassed = userToken;
        lastJobPassed = job;
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

    public Job getLastJobPassed() {
        return lastJobPassed;
    }
}
