package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation;

import com.example.networkmeup.domain.Job;

public interface AddNewReqEducationView {
    void successfulAdd(String message, String userToken, Job job);

    String getDescription();

    int getExpertiseArea();

    int getLevelOfStudies();
}
