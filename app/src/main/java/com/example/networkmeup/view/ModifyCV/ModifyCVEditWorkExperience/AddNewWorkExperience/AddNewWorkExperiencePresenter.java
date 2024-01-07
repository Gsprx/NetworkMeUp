package com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.AddNewWorkExperience;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.ExpertiseAreaDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.LevelOfStudies;
import com.example.networkmeup.domain.WorkExperience;

public class AddNewWorkExperiencePresenter {
    private AddNewWorkExperienceView view;
    private String userToken;

    public AddNewWorkExperiencePresenter(AddNewWorkExperienceView view, String userToken) {
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

        //create the new WorkExperience and add it to the current employee
        WorkExperience newexp = new WorkExperience(view.getYearsAtWork()+1,view.getDescription(), newExpertiseArea);
        currEmployee.getCV().setWorkExperience(newexp);

        //creation has been completed at this point, create success dialog
        view.successfulAdd("Work Experience has been created successfully!", userToken);
    }
}
