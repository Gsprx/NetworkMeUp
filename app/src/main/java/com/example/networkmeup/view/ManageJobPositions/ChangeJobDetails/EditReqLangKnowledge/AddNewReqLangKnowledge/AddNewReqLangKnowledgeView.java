package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.AddNewReqLangKnowledge;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfKnowledge;

/**
 * The AddNewReqLangKnowledgeView interface provides methods for managing the addition of new required language knowledge.
 */
public interface AddNewReqLangKnowledgeView {
        /**
         * Method for activity continuity after a successful add.
         * @param message Message sent by the presenter.
         * @param userToken User token to be passed to next activity.
         * @param job Job object to be passed after being updated.
         */
        void successfulAdd(String message, String userToken, Job job);

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
}

