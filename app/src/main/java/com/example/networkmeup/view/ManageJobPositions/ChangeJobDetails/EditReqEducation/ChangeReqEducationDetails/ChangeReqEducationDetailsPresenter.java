package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.ChangeReqEducationDetails;

import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfStudies;

public class ChangeReqEducationDetailsPresenter {
    private ChangeReqEducationDetailsView view;
    private String userToken;
    private Job job;

    public ChangeReqEducationDetailsPresenter(ChangeReqEducationDetailsView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    public void onSave(int position){
        Education updatedEducation = job.getReqEducation().get(position);

        updatedEducation.setLvlOfStudies(LevelOfStudies.values()[view.getLevelOfStudies()]);
        updatedEducation.setDescription(view.getDescription());
        updatedEducation.setExpArea(new ExpertiseAreaDAOMemory().getAll().get(view.getExpertiseArea()));

        view.successfulSave("Education was successfully updated!", userToken, job);
    }

    public void onDelete(int position){
        job.getReqEducation().remove(position);

        view.successfulDelete("Education was successfully deleted!", userToken, job);
    }
}
