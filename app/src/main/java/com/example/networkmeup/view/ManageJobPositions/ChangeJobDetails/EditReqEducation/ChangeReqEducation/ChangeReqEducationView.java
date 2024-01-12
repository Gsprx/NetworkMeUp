package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.ChangeReqEducation;

import com.example.networkmeup.domain.Job;

/**
 * The ChangeReqEducationView interface provides methods for managing the change of required education.
 */
public interface ChangeReqEducationView {
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

    /**
     * Method for activity continuity after a successful delete.
     * @param message Message sent by the presenter.
     * @param userToken User token to be passed to next activity.
     * @param job Job object to be passed after being updated.
     */
    void successfulDelete(String message, String userToken, Job job);

    /**
     * Method for activity continuity after a successful save.
     * @param message Message sent by the presenter.
     * @param userToken User token to be passed to next activity.
     * @param job Job object to be passed after being updated.
     */
    void successfulSave(String message, String userToken, Job job);
}
