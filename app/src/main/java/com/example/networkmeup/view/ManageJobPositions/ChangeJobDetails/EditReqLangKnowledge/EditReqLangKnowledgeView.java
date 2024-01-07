package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge;

import com.example.networkmeup.domain.Job;

public interface EditReqLangKnowledgeView {
    public void changeLanguageKnowledgeDetails(String userToken, int position, Job job);
    public void addNewLanguageKnowledge(String userToken, Job job);
}
