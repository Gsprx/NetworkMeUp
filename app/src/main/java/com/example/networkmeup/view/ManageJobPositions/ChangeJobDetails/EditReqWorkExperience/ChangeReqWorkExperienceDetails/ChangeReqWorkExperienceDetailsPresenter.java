package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.ChangeReqWorkExperienceDetails;

import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.WorkExperience;

public class ChangeReqWorkExperienceDetailsPresenter {
    private ChangeReqWorkExperienceDetailsView view;
    private String userToken;
    private Job job;

    public ChangeReqWorkExperienceDetailsPresenter(ChangeReqWorkExperienceDetailsView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    public void onSave(int position){
        WorkExperience updatedWorkExp = job.getReqWorkExperience().get(position);

        updatedWorkExp.setYears(view.getYears());
        updatedWorkExp.setDescription(view.getDescription());
        updatedWorkExp.setExpArea(new ExpertiseAreaDAOMemory().getAll().get(view.getExpertiseArea()));

        view.successfulSave("Work Experience was successfully updated!", userToken, job);
    }

    public void onDelete(int position){
        job.getReqWorkExperience().remove(position);

        view.successfulDelete("Work Experience was successfully deleted!", userToken, job);
    }
}
