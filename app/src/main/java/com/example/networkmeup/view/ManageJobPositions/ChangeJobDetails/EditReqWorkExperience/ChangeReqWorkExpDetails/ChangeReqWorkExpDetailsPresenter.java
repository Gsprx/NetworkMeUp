package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.ChangeReqWorkExpDetails;

import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.WorkExperience;

/**
 * This class represents a presenter for changing the details of a required work experience.
 * It contains methods to handle the saving and deletion of a required work experience.
 */
public class ChangeReqWorkExpDetailsPresenter {
    private ChangeReqWorkExpDetailsView view;
    private String userToken;
    private Job job;

    /**
     * Constructor for the ChangeReqWorkExpDetailsPresenter class.
     * @param view The view associated with this presenter.
     * @param userToken The token of the user.
     * @param job The job object.
     */
    public ChangeReqWorkExpDetailsPresenter(ChangeReqWorkExpDetailsView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    /**
     * This method is called when the save button is pressed.
     * It updates the work experience at the given position and calls the successfulSave method of the view.
     * @param position The position of the work experience in the list.
     */
    public void onSave(int position){
        WorkExperience updatedWorkExp = job.getReqWorkExperience().get(position);

        updatedWorkExp.setYears(view.getYears()+1);
        updatedWorkExp.setDescription(view.getDescription());
        updatedWorkExp.setExpArea(new ExpertiseAreaDAOMemory().getAll().get(view.getExpertiseArea()));

        view.successfulSave("Work Experience was successfully updated!", userToken, job);
    }

    /**
     * This method is called when the delete button is pressed.
     * It removes the work experience at the given position and calls the successfulDelete method of the view.
     * @param position The position of the work experience in the list.
     */
    public void onDelete(int position){
        job.getReqWorkExperience().remove(position);

        view.successfulDelete("Work Experience was successfully deleted!", userToken, job);
    }
}
