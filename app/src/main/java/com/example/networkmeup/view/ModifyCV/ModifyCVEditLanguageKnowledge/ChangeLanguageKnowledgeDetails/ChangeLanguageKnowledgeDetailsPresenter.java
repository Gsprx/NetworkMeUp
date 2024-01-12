package com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ChangeLanguageKnowledgeDetails;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.LanguageDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.LanguageDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.LevelOfKnowledge;

/**
 * Presenter class for handling the modification of language knowledge details.
 * It communicates with the associated view to retrieve updated information
 * and notifies the view about the success of deletion or saving.
 */
public class ChangeLanguageKnowledgeDetailsPresenter {
    private ChangeLanguageKnowledgeDetailsView view;
    private String userToken;

    /**
     * Constructor for the presenter.
     *
     * @param view      The associated view for language knowledge details modification.
     * @param userToken The user token for identification.
     */
    public ChangeLanguageKnowledgeDetailsPresenter(ChangeLanguageKnowledgeDetailsView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    /**
     * Handles the save action for modifying language knowledge details.
     *
     * @param position The position of the language knowledge item to be updated.
     */
    public void onSave(int position) {
        //get current employees data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userToken));
        //keep education that we want to update
        LanguageKnowledge updatedLanguageKnowledge = currEmployee.getCV().getLanguageKnowledge().get(position);
        //use education class setters to modify and update the fields
        updatedLanguageKnowledge.setDescription(view.getDescription());
        //get language value using the dao alongside the position given by the spinner item selection
        LanguageDAO languageDAO = new LanguageDAOMemory();
        Language newLanguage = languageDAO.getAll().get(view.getLanguage());
        updatedLanguageKnowledge.setLanguage(newLanguage);

        //get level of knowledge using the enum's ordinal alongside the position given by the spinner item selection
        LevelOfKnowledge newLevelOfKnowledge = LevelOfKnowledge.values()[view.getLevelOfKnowledge().ordinal()];
        updatedLanguageKnowledge.setLvlOfKnowledge(newLevelOfKnowledge);
        //update has been completed at this point, create success dialog
        view.successfulSave("This language knowledge has been updated successfully!", userToken);

    }

    /**
     * Handles the delete action for removing a language knowledge item.
     *
     * @param position The position of the language knowledge item to be deleted.
     */
    public void onDelete(int position) {
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userToken));
        currEmployee.getCV().getLanguageKnowledge().remove(position);
        view.successfulDelete("This language knowledge has been deleted successfully!", userToken);
    }
}
