package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge;

import com.example.networkmeup.domain.Job;

/**
 * The EditReqLangKnowledgeView interface provides methods for managing the editing of required language knowledge.
 */
public interface EditReqLangKnowledgeView {
    /**
     * Method to change language knowledge details.
     * @param userToken User token to be passed to next activity.
     * @param position The position of the language knowledge in the list.
     * @param job Job object to be passed after being updated.
     */
    void changeLanguageKnowledgeDetails(String userToken, int position, Job job);

    /**
     * Method to add new language knowledge.
     * @param userToken User token to be passed to next activity.
     * @param job Job object to be passed after being updated.
     */
    void addNewLanguageKnowledge(String userToken, Job job);
}

