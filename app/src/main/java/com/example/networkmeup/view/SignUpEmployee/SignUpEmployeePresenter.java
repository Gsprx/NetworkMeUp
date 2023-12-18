package com.example.networkmeup.view.SignUpEmployee;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;

public class SignUpEmployeePresenter {
    private SignUpEmployeeView signUpEmployeeView;

    public SignUpEmployeePresenter(SignUpEmployeeView view){
        signUpEmployeeView = view;
    }

    public void onCreate(){
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Email email = null;
        Phone phone = null;
        Password password = null;


        //check email field
        try{
            email = signUpEmployeeView.getEmail();
        }
        catch(Exception e){
            signUpEmployeeView.showErrorMessage("Error!", e.getMessage());
        }

        //check phone field
        try{
            phone = signUpEmployeeView.getPhone();
        }
        catch(Exception e){
            signUpEmployeeView.showErrorMessage("Error!", e.getMessage());
        }

        //check password field
        try{
            password = signUpEmployeeView.getPassword();
        }
        catch(Exception e){
            signUpEmployeeView.showErrorMessage("Error!", e.getMessage());
        }

        //create employee object and check if it exists
        Employee employee = new Employee(email,phone,password);

        if (employeeDAO.find(employee)){
            signUpEmployeeView.showErrorMessage("Account Error", "An employee account already exists with the same email and/or phone number!");
        }
        else{
            employeeDAO.save(employee);
            signUpEmployeeView.successfullyFinishActivity("Your NetworkMeUp Employee account was created!");

        }
    }
}
