package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge;

import com.example.networkmeup.domain.Job;

public class EditReqLangKnowledgePresenter {
    private EditReqLangKnowledgeView view;
    private String userToken;
    private Job job;

    public EditReqLangKnowledgePresenter(EditReqLangKnowledgeView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    public void onItemClick(int position) {
        view.changeLanguageKnowledgeDetails(userToken, position, job);
    }

    public void onAddNew() {
        view.addNewLanguageKnowledge(userToken, job);
    }
}
