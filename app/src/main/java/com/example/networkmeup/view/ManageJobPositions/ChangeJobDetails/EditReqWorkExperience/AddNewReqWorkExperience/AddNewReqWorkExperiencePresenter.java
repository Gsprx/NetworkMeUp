package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.AddNewReqWorkExperience;

import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfStudies;
import com.example.networkmeup.domain.WorkExperience;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation.AddNewReqEducationView;

/**
 * This class represents a presenter for adding a new required work experience.
 * It contains methods to handle the addition of a new required work experience.
 */
public class AddNewReqWorkExperiencePresenter {
    private AddNewReqWorkExperienceView view;
    private String userToken;
    private Job job;

    /**
     * Constructor for the AddNewReqWorkExperiencePresenter class.
     * @param view The view associated with this presenter.
     * @param userToken The token of the user.
     * @param job The job object.
     */
    public AddNewReqWorkExperiencePresenter(AddNewReqWorkExperienceView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    /**
     * This method is called when the add button is pressed.
     * It creates a new work experience and adds it to the job.
     * Then, it calls the successfulAdd method of the view.
     */
    public void onAdd() {
        ExpertiseArea newExpArea = new ExpertiseAreaDAOMemory().getAll().get(view.getExpertiseArea());
        job.addReqWorkExperience(new WorkExperience(view.getYears()+1,view.getDescription(), newExpArea));

        view.successfulAdd("Required Work Experience was successfully created!", userToken, job);
    }
}
