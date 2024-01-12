package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation;

import com.example.networkmeup.domain.Job;

/**
 * The AddNewReqEducationView interface provides methods for managing the addition of new required education.
 */
public interface AddNewReqEducationView {
    /**
     * Method for activity continuity after a successful add.
     * @param message Message sent by the presenter.
     * @param userToken User token to be passed to next activity.
     * @param job Job object to be passed after being updated.
     */
    void successfulAdd(String message, String userToken, Job job);

    /**
     * Method to obtain description from a text field.
     * @return String value of the description typed by the user.
     */
    String getDescription();

    /**
     * Method to obtain expertise area from a spinner.
     * @return Integer value of the selected expertise area.
     */
    int getExpertiseArea();

    /**
     * Method to obtain level of studies from a spinner.
     * @return Integer value of the selected level of studies.
     */
    int getLevelOfStudies();
}
