package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.ChangeReqEducationDetails;

import com.example.networkmeup.domain.Job;

public interface ChangeReqEducationDetailsView {
    String getDescription();

    int getExpertiseArea();

    int getLevelOfStudies();

    void successfulDelete(String message, String userToken, Job job);

    void successfulSave(String message, String userToken, Job job);
}
