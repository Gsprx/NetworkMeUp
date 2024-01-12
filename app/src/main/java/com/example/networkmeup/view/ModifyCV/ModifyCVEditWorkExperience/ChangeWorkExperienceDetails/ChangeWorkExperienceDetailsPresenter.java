package com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.ChangeWorkExperienceDetails;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.ExpertiseAreaDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.LevelOfStudies;
import com.example.networkmeup.domain.WorkExperience;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.ChangeEducationDetails.ChangeEducationDetailsView;
/**
 * Presenter for the ChangeWorkExperienceDetails view.
 * This class handles the business logic for changing the details of a work experience in the user's CV.
 */
public class ChangeWorkExperienceDetailsPresenter {
    private ChangeWorkExperienceDetailsView view;
    private String userToken;
    /**
     * Constructor for ChangeWorkExperienceDetailsPresenter.
     *
     * @param view      The view interface associated with this presenter.
     * @param userToken The token identifying the user, used for operations requiring authentication.
     */
    public ChangeWorkExperienceDetailsPresenter(ChangeWorkExperienceDetailsView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }
    /**
     * Handles the save operation for updating work experience details.
     * This method is invoked when the user saves changes to a work experience.
     *
     * @param position The position of the work experience in the user's CV.
     */
    public void onSave(int position) {
        //get current employees data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userToken));
        //keep work experience that we want to update
        WorkExperience updatedworkexp = currEmployee.getCV().getWorkExperiences().get(position);
        //use work experience class setters to modify and update the fields
        updatedworkexp.setDescription(view.getDescription());
        //get exp area value using the dao alongside the position given by the spinner item selection
        ExpertiseAreaDAO expertiseAreaDAO = new ExpertiseAreaDAOMemory();
        ExpertiseArea newExpertiseArea = expertiseAreaDAO.getAll().get(view.getExpertiseArea());
        updatedworkexp.setExpArea(newExpertiseArea);

        updatedworkexp.setYears(view.getYearsAtWork()+1);
        //update has been completed at this point, create success dialog
        view.successfulSave("This Work Experience has been updated successfully!", userToken);

    }
    /**
     * Handles the delete operation for a work experience.
     * This method is invoked when the user decides to remove a work experience from their CV.
     *
     * @param position The position of the work experience in the user's CV that is to be deleted.
     */
    public void onDelete(int position) {
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userToken));
        currEmployee.getCV().getWorkExperiences().remove(position);
        view.successfulDelete("This Work Experience has been deleted successfully!", userToken);
    }
}
