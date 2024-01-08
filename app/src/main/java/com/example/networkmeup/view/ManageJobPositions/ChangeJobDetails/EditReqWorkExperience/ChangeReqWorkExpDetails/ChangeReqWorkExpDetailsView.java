package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.ChangeReqWorkExpDetails;

import com.example.networkmeup.domain.Job;

public interface ChangeReqWorkExpDetailsView {
    String getDescription();

    int getExpertiseArea();

    int getYears();

    void successfulDelete(String message, String userToken, Job job);

    void successfulSave(String message, String userToken, Job job);
}
