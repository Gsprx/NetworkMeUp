package com.example.networkmeup.view.EditAccountEmployeeTest.ShowApplicationsEmployeeTest;

import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.view.EditAccountEmployee.ShowApplicationsEmployee.ShowApplicationsEmployeeActivity;
import com.example.networkmeup.view.EditAccountEmployee.ShowApplicationsEmployee.ShowApplicationsEmployeeView;

import java.util.ArrayList;

public class ShowApplicationsEmployeeViewStub implements ShowApplicationsEmployeeView {
    private String userEmail;
    private ShowApplicationsEmployeeView view;
    private Employee emp;

    public ShowApplicationsEmployeeViewStub(ShowApplicationsEmployeeView showApplicationsEmployeeActivity, String userEmail){
        this.userEmail = userEmail;
    }

    public ArrayList<Application> getApplications(){
        return new ArrayList<Application>();
    }
}
