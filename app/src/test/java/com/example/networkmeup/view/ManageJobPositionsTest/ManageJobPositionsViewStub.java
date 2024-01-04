package com.example.networkmeup.view.ManageJobPositionsTest;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.ManageJobPositions.ManageJobPositionsView;

public class ManageJobPositionsViewStub implements ManageJobPositionsView {
    private String lastTokenPassed;
    private Job lastJobPassed;
    private int addNewClicks;
    private int changeJobClicks;
    @Override
    public void addNewJobPosition(String userToken) {
        addNewClicks++;
        lastTokenPassed = userToken;
        lastJobPassed = null;
    }

    @Override
    public void changeJobDetails(String userToken, Job job) {
        changeJobClicks++;
        lastTokenPassed = userToken;
        lastJobPassed = job;
    }

    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    public Job getLastJobPassed() {
        return lastJobPassed;
    }

    public int getAddNewClicks() {
        return addNewClicks;
    }

    public int getChangeJobClicks() {
        return changeJobClicks;
    }
}
