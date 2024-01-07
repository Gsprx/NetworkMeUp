package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience;

import com.example.networkmeup.domain.Job;

public interface EditReqWorkExperienceView {
    void changeWorkExperienceDetails(String userToken, int position, Job job);

    void addNewWorkExperience(String userToken, Job job);
}
