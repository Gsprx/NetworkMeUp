package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation;

import com.example.networkmeup.domain.Job;

public interface EditReqEducationView {
    void changeEductionDetails(String userToken, int position, Job job);

    void addNewEducation(String userToken, Job job);
}
