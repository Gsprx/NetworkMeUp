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
/**
 * The presenter for the Add New Work Experience view in the application.
 * This class handles the business logic for adding new work experiences to an employee's CV.
 * It interacts with the model layer to retrieve and update data and updates the view accordingly.
 */
public class AddNewWorkExperiencePresenter {
    private AddNewWorkExperienceView view;
    private String userToken;
    /**
     * Constructor for AddNewWorkExperiencePresenter.
     *
     * @param view      The view interface associated with this presenter.
     * @param userToken The token identifying the current user.
     */
    public AddNewWorkExperiencePresenter(AddNewWorkExperienceView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }
    /**
     * Handles the addition of a new work experience entry.
     * Retrieves user input from the view, creates a new WorkExperience object, and adds it to the
     * current employee's CV. Then, it informs the view to display a success message.
     */
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
