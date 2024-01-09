package com.example.networkmeup.view.EditAccountEmployee;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;

public class EditAccountEmployeePresenter {

    private EditAccountEmployeeView view;
    private String userEmail;

    public EditAccountEmployeePresenter(EditAccountEmployeeView editAccountEmployeeActivity,String userEmail) {
        this.view = editAccountEmployeeActivity;
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        this.userEmail = userEmail;
    }

    public void Save() {

        boolean email_ok = true;
        boolean phone_ok = true;
        boolean pwd_ok = true;

        Email email = null;
        Phone phone = null;
        Password password = null;


        //check email field
        try {
            email = view.getEmail();
        } catch (RuntimeException e) {
            view.showErrorMessage("Error!", e.getMessage());
            email_ok = false;
        }

        //check phone field
        try {
            phone = view.getPhoneNumber();
        } catch (RuntimeException e) {
            view.showErrorMessage("Error!", e.getMessage());
            phone_ok = false;
        }

        //check password field
        try {
            password = view.getPassword();
        } catch (RuntimeException e) {
            view.showErrorMessage("Error!", e.getMessage());
            pwd_ok = false;
        }

        //only update employee if all fields are valid
        if (email_ok && phone_ok && pwd_ok) {

            Employee currEmployee = new EmployeeDAOMemory().getByEmail(new Email(userEmail));
            currEmployee.setEmail(email);
            currEmployee.setPassword(password);
            currEmployee.setPhone(phone);
            currEmployee.setName(view.getName());
            currEmployee.setAddress(view.getAddress());
            view.successfullySaved("Account changes were successfully saved!");
        }

    }

    public void Delete(){
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = new EmployeeDAOMemory().getByEmail(new Email(userEmail));
        employeeDAO.delete(currEmployee);
    }

    public void ApplicationArchive() {
        view.ApplicationArchive(userEmail);
    }
}
