package com.example.networkmeup.view.EditAccountEmployee.ShowApplicationsEmployee;

import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;

import java.util.ArrayList;

public class ShowApplicationPresenter {
    private String userEmail;
    private ShowApplicationsEmployeeView view;
    public ShowApplicationPresenter(ShowApplicationsEmployeeActivity showApplicationsEmployeeActivity, String userEmail){

    }
    public ArrayList<Application> getApplications(){
        Employee emp = new EmployeeDAOMemory().getByEmail(new Email(userEmail));
        ArrayList<Application> applications = emp.getApplications();
        return applications;
    }
}
