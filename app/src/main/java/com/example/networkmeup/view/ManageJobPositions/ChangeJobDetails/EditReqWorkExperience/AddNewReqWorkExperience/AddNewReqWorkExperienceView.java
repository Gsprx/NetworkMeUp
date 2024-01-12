package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.AddNewReqWorkExperience;

import com.example.networkmeup.domain.Job;

/**
 * This interface represents the view for adding a new required work experience.
 * It contains methods that need to be implemented by any class that serves as a view for adding a new required work experience.
 */
public interface AddNewReqWorkExperienceView {
    /**
     * This method is called when a new required work experience is successfully added.
     * @param message The success message to be displayed.
     * @param userToken The token of the user.
     * @param job The job object.
     */
    void successfulAdd(String message, String userToken, Job job);

    /**
     * This method gets the description entered by the user.
     * @return The description entered by the user.
     */
    String getDescription();

    /**
     * This method gets the selected expertise area from the spinner.
     * @return The position of the selected expertise area in the spinner.
     */
    int getExpertiseArea();

    /**
     * This method gets the selected number of years from the spinner.
     * @return The position of the selected number of years in the spinner.
     */
    int getYears();
}
