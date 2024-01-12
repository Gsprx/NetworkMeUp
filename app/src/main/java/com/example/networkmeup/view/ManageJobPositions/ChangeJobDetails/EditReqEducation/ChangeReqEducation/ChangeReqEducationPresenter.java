package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.ChangeReqEducation;

import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfStudies;

/**
 * The ChangeReqEducationPresenter class is responsible for handling actions from the ChangeReqEducationActivity view.
 */
public class ChangeReqEducationPresenter {
    private ChangeReqEducationView view;
    private String userToken;
    private Job job;

    /**
     * Constructor for the ChangeReqEducationPresenter class.
     * @param view The view that this presenter is attached to.
     * @param userToken The token of the user.
     * @param job The job that is being updated.
     */
    public ChangeReqEducationPresenter(ChangeReqEducationView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    /**
     * This method is called when the save button is pressed.
     * It updates the education at the given position and notifies the view of a successful save.
     * @param position The position of the education in the list.
     */
    public void onSave(int position){
        Education updatedEducation = job.getReqEducation().get(position);

        updatedEducation.setLvlOfStudies(LevelOfStudies.values()[view.getLevelOfStudies()]);
        updatedEducation.setDescription(view.getDescription());
        updatedEducation.setExpArea(new ExpertiseAreaDAOMemory().getAll().get(view.getExpertiseArea()));

        view.successfulSave("Education was successfully updated!", userToken, job);
    }

    /**
     * This method is called when the delete button is pressed.
     * It removes the education at the given position and notifies the view of a successful delete.
     * @param position The position of the education in the list.
     */
    public void onDelete(int position){
        job.getReqEducation().remove(position);

        view.successfulDelete("Education was successfully deleted!", userToken, job);
    }
}

