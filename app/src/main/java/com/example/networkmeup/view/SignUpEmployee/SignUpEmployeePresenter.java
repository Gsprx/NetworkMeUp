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

        boolean email_ok = true;
        boolean phone_ok = true;
        boolean pwd_ok = true;

        Email email = null;
        Phone phone = null;
        Password password = null;


        //check email field
        try{
            email = signUpEmployeeView.getEmail();
        }
        catch(RuntimeException e){
            signUpEmployeeView.showErrorMessage("Error!", e.getMessage());
            email_ok = false;
        }

        //check phone field
        try{
            phone = signUpEmployeeView.getPhone();
        }
        catch(RuntimeException e){
            signUpEmployeeView.showErrorMessage("Error!", e.getMessage());
            phone_ok = false;
        }

        //check password field
        try{
            password = signUpEmployeeView.getPassword();
        }
        catch(RuntimeException e){
            signUpEmployeeView.showErrorMessage("Error!", e.getMessage());
            pwd_ok = false;
        }

        //only create employee if all fields are valid
        if(email_ok && phone_ok && pwd_ok) {
            //create employee object and check if it exists
            Employee employee = new Employee(email, phone, password);

            if (employeeDAO.find(employee)) {
                signUpEmployeeView.showErrorMessage("Account Error", "An employee account already exists with the same email and/or phone number!");
            } else {
                employeeDAO.save(employee);
                signUpEmployeeView.successfullyFinishActivity("Your NetworkMeUp Employee account was created!");

            }
        }
        else {
            signUpEmployeeView.showErrorMessage("Error!", "Fields cannot be empty!");
        }
    }
}
