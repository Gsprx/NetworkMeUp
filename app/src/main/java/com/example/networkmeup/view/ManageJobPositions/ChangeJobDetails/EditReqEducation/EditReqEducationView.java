package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation;

import com.example.networkmeup.domain.Job;

/**
 * The EditReqEducationView interface provides methods for managing the editing of required education.
 */
public interface EditReqEducationView {
    /**
     * Method to change education details.
     * @param userToken User token to be passed to next activity.
     * @param position The position of the education in the list.
     * @param job Job object to be passed after being updated.
     */
    void changeEductionDetails(String userToken, int position, Job job);

    /**
     * Method to add new education.
     * @param userToken User token to be passed to next activity.
     * @param job Job object to be passed after being updated.
     */
    void addNewEducation(String userToken, Job job);
}

