package com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge;

/**
 * Presenter class for handling user interactions in the view responsible for modifying language knowledge details.
 */
public class ModifyCVEditLanguageKnowledgePresenter {

    private ModifyCVEditLanguageKnowledgeView view;
    private String userToken;

    /**
     * Constructor for the presenter.
     *
     * @param view      The associated view interface.
     * @param userToken User token for identification.
     */
    public ModifyCVEditLanguageKnowledgePresenter(ModifyCVEditLanguageKnowledgeView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    /**
     * Handle item click event at the specified position.
     *
     * @param position Position of the language knowledge entry in the list.
     */
    public void onItemClick(int position){
        view.changeLanguageKnowledgeDetails(userToken, position);
    }

    /**
     * Handle the event when the user wants to add a new language knowledge entry.
     */
    public void onAddNew() {
        view.addNewLanguageKnowledge(userToken);
    }
}
