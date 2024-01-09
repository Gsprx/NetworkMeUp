package com.example.networkmeup.view.EditAccountEmployee.ShowApplicationsEmployee;

import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;

import java.util.ArrayList;

public class ShowApplicationsEmployeePresenter {
    private String userEmail;
    private ShowApplicationsEmployeeView view;
    private Employee emp;
    public ShowApplicationsEmployeePresenter(ShowApplicationsEmployeeActivity showApplicationsEmployeeActivity, String userEmail){
        emp = new EmployeeDAOMemory().getByEmail(new Email(userEmail));
    }
    public ArrayList<Application> getApplications(){
        ArrayList<Application> applications = emp.getApplications();
        return applications;
    }
}
