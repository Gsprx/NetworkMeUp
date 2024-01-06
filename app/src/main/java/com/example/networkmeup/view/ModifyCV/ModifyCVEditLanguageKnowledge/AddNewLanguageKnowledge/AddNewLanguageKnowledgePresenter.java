package com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.AddNewLanguageKnowledge;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.LanguageDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.LanguageDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.domain.LanguageKnowledge;

public class AddNewLanguageKnowledgePresenter {

    private AddNewLanguageKnowledgeView view;
    private String userToken;

    public AddNewLanguageKnowledgePresenter(AddNewLanguageKnowledgeView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    public void onAdd() {
        //get current employees data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userToken));

        //get Language value using the dao alongside the position given by the spinner item selection
        LanguageDAO languageKnowledgeDAO = new LanguageDAOMemory();
        Language newLanguage = languageKnowledgeDAO.getAll().get(view.getLanguage());

        //get level of knowledge using the enum's ordinal alongside the position given by the spinner item selection
        LevelOfKnowledge newLevelOfKnowledge = LevelOfKnowledge.values()[view.getLevelOfKnowledge().ordinal()];

        //create the new Language and add it to the current employee
        LanguageKnowledge newlanguage = new LanguageKnowledge(view.getDescription(), newLanguage, newLevelOfKnowledge);
        currEmployee.getCV().setLanguageKnowledge(newlanguage);

        //creation has been completed at this point, create success dialog
        view.successfulAdd("Language Knowledge has been created successfully!", userToken);
    }
}
