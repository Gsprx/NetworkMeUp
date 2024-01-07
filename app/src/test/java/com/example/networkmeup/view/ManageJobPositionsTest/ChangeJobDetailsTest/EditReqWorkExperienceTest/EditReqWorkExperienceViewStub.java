package com.example.networkmeup.view.ManageJobPositionsTest.ChangeJobDetailsTest.EditReqWorkExperienceTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.EditReqWorkExperienceView;

public class EditReqWorkExperienceViewStub implements EditReqWorkExperienceView {
    private int changeClicks;
    private int addNewClicks;
    private int lastPositionPassed;
    private String lastTokenPassed;
    private Job lastJobPassed;

    @Override
    public void changeWorkExperienceDetails(String userToken, int position, Job job) {
        changeClicks++;
        lastPositionPassed = position;
        lastTokenPassed = userToken;
        lastJobPassed = job;
    }

    @Override
    public void addNewWorkExperience(String userToken, Job job) {
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
