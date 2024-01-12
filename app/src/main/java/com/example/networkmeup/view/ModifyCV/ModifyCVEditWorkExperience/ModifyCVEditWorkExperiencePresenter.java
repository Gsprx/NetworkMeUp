package com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience;
/**
 * Presenter for the ModifyCVEditWorkExperienceActivity.
 * This class handles the business logic for the Modify CV Edit Work Experience screen.
 */
public class ModifyCVEditWorkExperiencePresenter {
    private ModifyCVEditWorkExperienceView view;
    private String userToken;
    /**
     * Constructor for ModifyCVEditWorkExperiencePresenter.
     *
     * @param view The view interface associated with this presenter.
     * @param userToken The token identifying the user, used for operations requiring authentication.
     */
    public ModifyCVEditWorkExperiencePresenter(ModifyCVEditWorkExperienceView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }
    /**
     * Handles the action when an item (a work experience) in the list is clicked.
     * This method is invoked to edit the details of the selected work experience.
     *
     * @param position The position of the clicked item in the list.
     */
    public void onItemClick(int position){
        view.changeWorkExperienceDetails(userToken, position);
    }
    /**
     * Handles the action when the user opts to add a new work experience.
     * This method is called to initiate the process of adding a new work experience to the user's CV.
     */
    public void onAddNew() {
        view.addNewWorkExperience(userToken);
    }
}
