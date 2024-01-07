package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.AddNewReqLangKnowledge;

import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfStudies;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation.AddNewReqEducationView;

public class AddNewReqLangKnowledgePresenter {
    private AddNewReqLangKnowledgeView view;
    private String userToken;
    private Job job;

    public AddNewReqLangKnowledgePresenter(AddNewReqLangKnowledgeView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    public void onAdd() {
        ExpertiseArea newExpArea = new ExpertiseAreaDAOMemory().getAll().get(view.getExpertiseArea());
        LevelOfStudies newLevelOfStudies = LevelOfStudies.values()[view.getLevelOfStudies()];
        job.addReqEducation(new Education(view.getDescription(), newExpArea, newLevelOfStudies));

        view.successfulAdd("Required Education was successfully created!", userToken, job);
    }
}
