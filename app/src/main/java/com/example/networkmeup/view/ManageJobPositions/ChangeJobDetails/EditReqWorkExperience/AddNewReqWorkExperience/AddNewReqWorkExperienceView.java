package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.AddNewReqWorkExperience;

import com.example.networkmeup.domain.Job;

public interface AddNewReqWorkExperienceView {
    void successfulAdd(String message, String userToken, Job job);

    String getDescription();

    int getExpertiseArea();

    int getYears();
}
