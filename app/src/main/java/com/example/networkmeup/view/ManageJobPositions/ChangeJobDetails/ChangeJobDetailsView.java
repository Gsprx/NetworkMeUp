package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails;

import com.example.networkmeup.domain.Job;

/**
 * The ChangeJobDetailsView interface provides methods for managing the change of job details.
 */
public interface ChangeJobDetailsView {
    /**
     * Method to obtain job description from a text field.
     * @return String value of the job description typed by the user.
     */
    String getJobDescription();

    /**
     * Method to obtain job title from a text field.
     * @return String value of the job title typed by the user.
     */
    String getJobTitle();

    /**
     * Method to obtain availability from a spinner.
     * @return Integer value of the selected availability.
     */
    int getAvailability();

    /**
     * Method to edit education details.
     * @param job Job object to be passed to next activity.
     * @param userToken User token to be passed to next activity.
     */
    void editEducation(Job job, String userToken);

    /**
     * Method to edit work experience details.
     * @param job Job object to be passed to next activity.
     * @param userToken User token to be passed to next activity.
     */
    void editWorkExperience(Job job, String userToken);

    /**
     * Method to edit language knowledge details.
     * @param job Job object to be passed to next activity.
     * @param userToken User token to be passed to next activity.
     */
    void editLangKnowledge(Job job, String userToken);

    /**
     * Method for activity continuity after a successful delete.
     * @param userToken User token to be passed to next activity.
     */
    void successfulDelete(String userToken);

    /**
     * Method for activity continuity after a successful save.
     * @param userToken User token to be passed to next activity.
     */
    void successfulSave(String userToken);
}

