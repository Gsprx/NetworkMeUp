package com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge;

/**
 * Interface for the view responsible for modifying language knowledge details and adding new language knowledge entries.
 */
public interface ModifyCVEditLanguageKnowledgeView {

    /**
     * Navigate to the activity for changing language knowledge details.
     *
     * @param userToken User token for identification.
     * @param position  Position of the language knowledge entry in the list.
     */
    public void changeLanguageKnowledgeDetails(String userToken, int position);

    /**
     * Navigate to the activity for adding new language knowledge.
     *
     * @param userToken User token for identification.
     */
    public void addNewLanguageKnowledge(String userToken);
}
