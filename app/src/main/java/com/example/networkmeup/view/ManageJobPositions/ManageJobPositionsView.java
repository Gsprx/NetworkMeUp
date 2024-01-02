package com.example.networkmeup.view.ManageJobPositions;

import com.example.networkmeup.domain.Job;

public interface ManageJobPositionsView {
    public void addNewJobPosition(String userToken);
    public void changeJobPosition(String userToken, Job job);
}
