package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge;

import com.example.networkmeup.domain.Job;

/**
 * The EditReqLangKnowledgePresenter class is responsible for handling actions from the EditReqLangKnowledgeActivity view.
 */
public class EditReqLangKnowledgePresenter {
    private EditReqLangKnowledgeView view;
    private String userToken;
    private Job job;

    /**
     * Constructor for the EditReqLangKnowledgePresenter class.
     * @param view The view that this presenter is attached to.
     * @param userToken The token of the user.
     * @param job The job that is being updated.
     */
    public EditReqLangKnowledgePresenter(EditReqLangKnowledgeView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    /**
     * This method is called when an item in the list has been clicked.
     * It changes the language knowledge details at the given position.
     * @param position The position of the language knowledge in the list.
     */
    public void onItemClick(int position) {
        view.changeLanguageKnowledgeDetails(userToken, position, job);
    }

    /**
     * This method is called when the Add New button is pressed.
     * It adds a new language knowledge.
     */
    public void onAddNew() {
        view.addNewLanguageKnowledge(userToken, job);
    }
}

