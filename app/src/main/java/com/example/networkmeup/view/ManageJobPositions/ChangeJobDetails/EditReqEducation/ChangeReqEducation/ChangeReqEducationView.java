package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.ChangeReqEducation;

import com.example.networkmeup.domain.Job;

public interface ChangeReqEducationView {
    String getDescription();

    int getExpertiseArea();

    int getLevelOfStudies();

    void successfulDelete(String message, String userToken, Job job);

    void successfulSave(String message, String userToken, Job job);
}
