package com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ChangeLanguageKnowledgeDetails;

import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.LevelOfKnowledge;

/**
 * Interface for the view responsible for changing language knowledge details.
 * It defines methods to retrieve updated language knowledge details from the UI
 * and notifies the presenter about the success of deletion or saving.
 */
public interface ChangeLanguageKnowledgeDetailsView {

    /**
     * Get the updated description of language knowledge from the UI.
     *
     * @return The updated description entered by the user.
     */
    public String getDescription();

    /**
     * Get the updated position of the language from the spinner.
     *
     * @return The updated position of the selected language in the spinner.
     */
    public int getLanguage();

    /**
     * Get the updated level of knowledge from the spinner.
     *
     * @return The updated LevelOfKnowledge based on the user's selection.
     */
    public LevelOfKnowledge getLevelOfKnowledge();

    /**
     * Notify the presenter about the successful deletion of language knowledge.
     *
     * @param message   The success message to display.
     * @param userToken The user token for navigation.
     */
    public void successfulDelete(String message, String userToken);

    /**
     * Notify the presenter about the successful saving of language knowledge changes.
     *
     * @param message   The success message to display.
     * @param userToken The user token for navigation.
     */
    public void successfulSave(String message, String userToken);
}
