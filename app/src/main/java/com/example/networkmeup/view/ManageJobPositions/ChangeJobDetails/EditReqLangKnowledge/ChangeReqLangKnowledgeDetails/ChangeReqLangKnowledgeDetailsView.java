package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.ChangeReqLangKnowledgeDetails;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfKnowledge;

/**
 * The ChangeReqLangKnowledgeDetailsView interface provides methods for managing the change of required language knowledge details.
 */
public interface ChangeReqLangKnowledgeDetailsView {
    /**
     * Method to obtain description from a text field.
     * @return String value of the description typed by the user.
     */
    String getDescription();

    /**
     * Method to obtain language from a spinner.
     * @return Integer value of the selected language.
     */
    int getLanguage();

    /**
     * Method to obtain level of knowledge from a spinner.
     * @return LevelOfKnowledge value of the selected level of knowledge.
     */
    LevelOfKnowledge getLevelOfKnowledge();

    /**
     * Method for activity continuity after a successful delete.
     * @param message Message sent by the presenter.
     * @param userToken User token to be passed to next activity.
     * @param job Job object to be passed after being updated.
     */
    void successfulDelete(String message, String userToken, Job job);

    /**
     * Method for activity continuity after a successful save.
     * @param message Message sent by the presenter.
     * @param userToken User token to be passed to next activity.
     * @param job Job object to be passed after being updated.
     */
    void successfulSave(String message, String userToken, Job job);
}

