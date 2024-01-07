package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.ChangeReqWorkExperienceDetails;

import com.example.networkmeup.domain.Job;

public interface ChangeReqWorkExperienceDetailsView {
    String getDescription();

    int getExpertiseArea();

    int getYears();

    void successfulDelete(String message, String userToken, Job job);

    void successfulSave(String message, String userToken, Job job);
}
