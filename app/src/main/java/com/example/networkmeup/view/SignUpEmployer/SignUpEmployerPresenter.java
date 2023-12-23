package com.example.networkmeup.view.SignUpEmployer;

import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;

public class SignUpEmployerPresenter {

    private SignUpEmployerView view;
    private EmployerDAO employerDAO;
    public SignUpEmployerPresenter(SignUpEmployerView view, EmployerDAO employerDAO){
        this.view = view;
        this.employerDAO= employerDAO;
    }


    public void onCreate(){
        boolean email_ok = true;
        boolean phone_ok = true;
        boolean pwd_ok = true;
        boolean tin_ok = true;

        Email email = null;
        Phone phone = null;
        Password password = null;
        TIN tin =null;

        //check email field
        try{
            email = view.getEmail();
        }
        catch(RuntimeException e){
            view.showErrorMessage("Error!", e.getMessage());
            email_ok = false;
        }

        //check phone field
        try{
            phone = view.getPhone();
        }
        catch(RuntimeException e){
            view.showErrorMessage("Error!", e.getMessage());
            phone_ok = false;
        }

        //check password field
        try{
            password = view.getPassword();
        }
        catch(RuntimeException e){
            view.showErrorMessage("Error!", e.getMessage());
            pwd_ok = false;
        }

        //check TIN field
        try{
            tin = view.getTIN();
        }
        catch(RuntimeException e){
            view.showErrorMessage("Error!", e.getMessage());
            tin_ok = false;
        }

        //only create employer if all fields are valid
        if(email_ok && phone_ok && pwd_ok && tin_ok) {
            //create employer object and check if it exists
            Employer employer = new Employer(email, phone, password,tin);

            if (employerDAO.find(employer)) {
                view.showErrorMessage("Account Creation Error", "An employer account already exists with the same email or phone number or TIN!");
            }
            else {
                employerDAO.save(employer);
                view.successfullyFinishActivity("Your NetworkMeUp Employer account was created!");
            }
        }
    }
}
