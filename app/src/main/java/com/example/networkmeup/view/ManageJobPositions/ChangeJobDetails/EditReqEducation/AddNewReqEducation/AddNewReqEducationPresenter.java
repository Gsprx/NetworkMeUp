package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation;

import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfStudies;

import java.util.logging.Level;

/**
 * Presenter of the adding new required education activity
 */
public class AddNewReqEducationPresenter {
    private AddNewReqEducationView view;
    private String userToken;
    private Job job;

    /**
     * Constructor for the class
     * @param view View of the owner activity
     * @param userToken String value of the token to be used
     * @param job Job to be updated
     */
    public AddNewReqEducationPresenter(AddNewReqEducationView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    /**
     * Method that adds a new required education the the Job member using the user's input
     */
    public void onAdd() {
        ExpertiseArea newExpArea = new ExpertiseAreaDAOMemory().getAll().get(view.getExpertiseArea());
        LevelOfStudies newLevelOfStudies = LevelOfStudies.values()[view.getLevelOfStudies()];
        job.addReqEducation(new Education(view.getDescription(), newExpArea, newLevelOfStudies));

        view.successfulAdd("Required Education was successfully created!", userToken, job);
    }
}
