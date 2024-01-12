package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.ChangeReqLangKnowledgeDetails;

import com.example.networkmeup.daoMemory.LanguageDAOMemory;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.LevelOfKnowledge;

/**
 * The ChangeReqLangKnowledgeDetailsPresenter class is responsible for handling actions from the ChangeReqLangKnowledgeDetailsActivity view.
 */
public class ChangeReqLangKnowledgeDetailsPresenter {
    private ChangeReqLangKnowledgeDetailsView view;
    private String userToken;
    private Job job;

    /**
     * Constructor for the ChangeReqLangKnowledgeDetailsPresenter class.
     * @param view The view that this presenter is attached to.
     * @param userToken The token of the user.
     * @param job The job that is being updated.
     */
    public ChangeReqLangKnowledgeDetailsPresenter(ChangeReqLangKnowledgeDetailsView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    /**
     * This method is called when the save button is pressed.
     * It updates the language knowledge at the given position and notifies the view of a successful save.
     * @param position The position of the language knowledge in the list.
     */
    public void onSave(int position){
        LanguageKnowledge updatedLanguageKnowledge = job.getReqLanguageKnowledge().get(position);

        updatedLanguageKnowledge.setLvlOfKnowledge(LevelOfKnowledge.values()[view.getLevelOfKnowledge().ordinal()]);
        updatedLanguageKnowledge.setDescription(view.getDescription());
        updatedLanguageKnowledge.setLanguage(new LanguageDAOMemory().getAll().get(view.getLanguage()));

        view.successfulSave("Language Knowledge was successfully updated!", userToken, job);
    }

    /**
     * This method is called when the delete button is pressed.
     * It removes the language knowledge at the given position and notifies the view of a successful delete.
     * @param position The position of the language knowledge in the list.
     */
    public void onDelete(int position){
        job.getReqLanguageKnowledge().remove(position);

        view.successfulDelete("Language Knowledge was successfully deleted!", userToken, job);
    }
}

