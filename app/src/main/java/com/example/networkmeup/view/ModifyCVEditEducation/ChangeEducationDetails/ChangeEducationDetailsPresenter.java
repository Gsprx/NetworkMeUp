package com.example.networkmeup.view.ModifyCVEditEducation.ChangeEducationDetails;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.ExpertiseAreaDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.LevelOfStudies;

public class ChangeEducationDetailsPresenter {
    private ChangeEducationDetailsView view;
    private String userToken;

    public ChangeEducationDetailsPresenter(ChangeEducationDetailsView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    public void onSave(int position) {
        //get current employees data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userToken));
        //keep education that we want to update
        Education updatedEducation = currEmployee.getCV().getEducation().get(position);
        //use education class setters to modify and update the fields
        updatedEducation.setDescription(view.getDescription());
            //get exp area value using the dao alongside the position given by the spinner item selection
            ExpertiseAreaDAO expertiseAreaDAO = new ExpertiseAreaDAOMemory();
            ExpertiseArea newExpertiseArea = expertiseAreaDAO.getAll().get(view.getExpertiseArea());
        updatedEducation.setExpArea(newExpertiseArea);

            //get level of studies using the enum's ordinal alongside the position given by the spinner item selection
            LevelOfStudies newLevelOfStudies = LevelOfStudies.values()[view.getLevelOfStudies()];
        updatedEducation.setLvlOfStudies(newLevelOfStudies);
        //update has been completed at this point, create success dialog
        view.successfulSave("This education has been updated successfully!", userToken);

    }

    public void onDelete(int position) {
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userToken));
        currEmployee.getCV().getEducation().remove(position);
        view.successfulDelete("This education has been deleted successfully!", userToken);
    }
}
