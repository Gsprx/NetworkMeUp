package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.AddNewReqLangKnowledge;

import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.daoMemory.LanguageDAOMemory;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.LevelOfKnowledge;
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
        Language newLanguage = new LanguageDAOMemory().getAll().get(view.getLanguage());
        LevelOfKnowledge newLevelOfKnowledge = LevelOfKnowledge.values()[view.getLevelOfKnowledge().ordinal()];
        job.addReqLanguageKnowledge(new LanguageKnowledge(view.getDescription(), newLanguage, newLevelOfKnowledge));

        view.successfulAdd("Required Language Knowledge was successfully created!", userToken, job);
    }
}
