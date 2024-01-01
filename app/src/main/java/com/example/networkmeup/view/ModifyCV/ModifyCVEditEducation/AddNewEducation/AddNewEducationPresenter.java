package com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.AddNewEducation;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.ExpertiseAreaDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.LevelOfStudies;

public class AddNewEducationPresenter {
    private AddNewEducationView view;
    private String userToken;

    public AddNewEducationPresenter(AddNewEducationView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    public void onAdd(){
        //get current employees data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userToken));

        //get exp area value using the dao alongside the position given by the spinner item selection
        ExpertiseAreaDAO expertiseAreaDAO = new ExpertiseAreaDAOMemory();
        ExpertiseArea newExpertiseArea = expertiseAreaDAO.getAll().get(view.getExpertiseArea());

        //get level of studies using the enum's ordinal alongside the position given by the spinner item selection
        LevelOfStudies newLevelOfStudies = LevelOfStudies.values()[view.getLevelOfStudies()];

        //create the new education and add it to the current employee
        Education newEducation = new Education(view.getDescription(), newExpertiseArea, newLevelOfStudies);
        currEmployee.getCV().setEducation(newEducation);

        //creation has been completed at this point, create success dialog
        view.successfulAdd("Education has been created successfully!", userToken);
    }
}
