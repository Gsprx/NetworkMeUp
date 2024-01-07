package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.ChangeReqLangKnowledgeDetails;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfKnowledge;

public interface ChangeReqLangKnowledgeDetailsView {
    public String getDescription();
    public int getLanguage();
    public LevelOfKnowledge getLevelOfKnowledge();
    void successfulDelete(String message, String userToken, Job job);
    void successfulSave(String message, String userToken, Job job);
}
