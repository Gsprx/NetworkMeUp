package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience;

import com.example.networkmeup.domain.Job;

/**
 * This interface represents the view for editing the required work experiences.
 * It contains methods that need to be implemented by any class that serves as a view for editing the required work experiences.
 */
public interface EditReqWorkExperienceView {
    /**
     * This method is called to change the details of a work experience.
     * @param userToken The token of the user.
     * @param position The position of the work experience in the list.
     * @param job The job object.
     */
    void changeWorkExperienceDetails(String userToken, int position, Job job);

    /**
     * This method is called to add a new work experience.
     * @param userToken The token of the user.
     * @param job The job object.
     */
    void addNewWorkExperience(String userToken, Job job);
}
