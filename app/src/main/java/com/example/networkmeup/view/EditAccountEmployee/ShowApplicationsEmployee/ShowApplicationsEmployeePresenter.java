package com.example.networkmeup.view.EditAccountEmployee.ShowApplicationsEmployee;

import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;

import java.util.ArrayList;
/**
 * Presenter class for the Show Applications Employee view.
 * <p>
 * This class handles the business logic for retrieving and displaying the applications
 * associated with a specific employee. It communicates between the view and the model.
 * </p>
 */
public class ShowApplicationsEmployeePresenter {
    private String userEmail;
    private ShowApplicationsEmployeeView view;
    private Employee emp;
    /**
     * Constructor for ShowApplicationsEmployeePresenter.
     * <p>
     * Initializes the presenter with the user's email and retrieves the corresponding employee's data.
     * </p>
     * @param showApplicationsEmployeeActivity The view instance that this presenter is associated with.
     * @param userEmail The email of the user whose applications are to be displayed.
     */
    public ShowApplicationsEmployeePresenter(ShowApplicationsEmployeeView showApplicationsEmployeeActivity, String userEmail){
        this.emp = new EmployeeDAOMemory().getByEmail(new Email(userEmail));
    }
    /**
     * Retrieves the list of applications associated with the employee.
     * <p>
     * This method fetches and returns the applications that are linked to the employee
     * whose email is specified.
     * </p>
     * @return ArrayList of Application objects associated with the employee.
     */
    public ArrayList<Application> getApplications(){
        ArrayList<Application> applications = emp.getApplications();
        return applications;
    }
}
