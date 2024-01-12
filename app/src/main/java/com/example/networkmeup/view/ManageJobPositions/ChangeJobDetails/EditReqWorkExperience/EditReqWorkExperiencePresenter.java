package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience;

import com.example.networkmeup.domain.Job;

/**
 * This class represents a presenter for editing the required work experiences.
 * It contains methods to handle the click on an item and the addition of a new work experience.
 */
public class EditReqWorkExperiencePresenter {
    private EditReqWorkExperienceView view;
    private String userToken;
    private Job job;

    /**
     * Constructor for the EditReqWorkExperiencePresenter class.
     * @param view The view associated with this presenter.
     * @param userToken The token of the user.
     * @param job The job object.
     */
    public EditReqWorkExperiencePresenter(EditReqWorkExperienceView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    /**
     * This method is called when an item is clicked.
     * It calls the changeWorkExperienceDetails method of the view.
     * @param position The position of the clicked item in the list.
     */
    public void onItemClick(int position) {
        view.changeWorkExperienceDetails(userToken, position, job);
    }

    /**
     * This method is called when the add new button is pressed.
     * It calls the addNewWorkExperience method of the view.
     */
    public void onAddNew() {
        view.addNewWorkExperience(userToken, job);
    }
}

