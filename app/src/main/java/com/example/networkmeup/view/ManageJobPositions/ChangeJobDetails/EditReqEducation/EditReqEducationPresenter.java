package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation;

import com.example.networkmeup.domain.Job;

/**
 * The EditReqEducationPresenter class is responsible for handling actions from the EditReqEducationActivity view.
 */
public class EditReqEducationPresenter {
    private EditReqEducationView view;
    private String userToken;
    private Job job;

    /**
     * Constructor for the EditReqEducationPresenter class.
     * @param view The view that this presenter is attached to.
     * @param userToken The token of the user.
     * @param job The job that is being updated.
     */
    public EditReqEducationPresenter(EditReqEducationView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    /**
     * This method is called when an item in the list has been clicked.
     * It changes the education details at the given position.
     * @param position The position of the education in the list.
     */
    public void onItemClick(int position) {
        view.changeEductionDetails(userToken, position, job);
    }

    /**
     * This method is called when the Add New button is pressed.
     * It adds a new education.
     */
    public void onAddNew() {
        view.addNewEducation(userToken, job);
    }
}

