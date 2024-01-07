package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.ChangeReqLangKnowledgeDetails;

import com.example.networkmeup.daoMemory.LanguageDAOMemory;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.LevelOfKnowledge;

public class ChangeReqLangKnowledgeDetailsPresenter {
    private ChangeReqLangKnowledgeDetailsView view;
    private String userToken;
    private Job job;

    public ChangeReqLangKnowledgeDetailsPresenter(ChangeReqLangKnowledgeDetailsView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    public void onSave(int position){
        LanguageKnowledge updatedLanguageKnowledge = job.getReqLanguageKnowledge().get(position);

        updatedLanguageKnowledge.setLvlOfKnowledge(LevelOfKnowledge.values()[view.getLevelOfKnowledge().ordinal()]);
        updatedLanguageKnowledge.setDescription(view.getDescription());
        updatedLanguageKnowledge.setLanguage(new LanguageDAOMemory().getAll().get(view.getLanguage()));

        view.successfulSave("Language Knowledge was successfully updated!", userToken, job);
    }

    public void onDelete(int position){
        job.getReqLanguageKnowledge().remove(position);

        view.successfulDelete("Language Knowledge was successfully deleted!", userToken, job);
    }
}
