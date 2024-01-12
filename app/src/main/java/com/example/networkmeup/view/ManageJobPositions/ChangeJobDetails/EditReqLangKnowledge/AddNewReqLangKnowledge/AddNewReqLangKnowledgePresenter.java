package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.AddNewReqLangKnowledge;

import com.example.networkmeup.daoMemory.LanguageDAOMemory;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.LevelOfKnowledge;


/**
 * The AddNewReqLangKnowledgePresenter class is responsible for handling actions from the AddNewReqLangKnowledgeActivity view.
 */
public class AddNewReqLangKnowledgePresenter {
    private AddNewReqLangKnowledgeView view;
    private String userToken;
    private Job job;

    /**
     * Constructor for the AddNewReqLangKnowledgePresenter class.
     * @param view The view that this presenter is attached to.
     * @param userToken The token of the user.
     * @param job The job that is being updated.
     */
    public AddNewReqLangKnowledgePresenter(AddNewReqLangKnowledgeView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    /**
     * This method is called when the Add button is pressed.
     * It adds a new language knowledge to the job and notifies the view of a successful add.
     */
    public void onAdd() {
        Language newLanguage = new LanguageDAOMemory().getAll().get(view.getLanguage());
        LevelOfKnowledge newLevelOfKnowledge = LevelOfKnowledge.values()[view.getLevelOfKnowledge().ordinal()];
        job.addReqLanguageKnowledge(new LanguageKnowledge(view.getDescription(), newLanguage, newLevelOfKnowledge));

        view.successfulAdd("Required Language Knowledge was successfully created!", userToken, job);
    }
}

