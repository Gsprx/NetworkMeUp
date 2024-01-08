package com.example.networkmeup.view.EditAccountEmployee;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;

public class EditAccountEmployeePresenter {

    private EditAccountEmployeeView EditAccountEmployee;
    private Employee currEmployee;

    public EditAccountEmployeePresenter(EditAccountEmployeeView editAccountEmployeeActivity,String userEmail) {
        this.EditAccountEmployee = editAccountEmployeeActivity;
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        currEmployee = employeeDAO.getByEmail(new Email(userEmail));

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
            email = EditAccountEmployee.getEmail();
        } catch (RuntimeException e) {
            EditAccountEmployee.showErrorMessage("Error!", e.getMessage());
            email_ok = false;
        }

        //check phone field
        try {
            phone = EditAccountEmployee.getPhoneNumber();
        } catch (RuntimeException e) {
            EditAccountEmployee.showErrorMessage("Error!", e.getMessage());
            phone_ok = false;
        }

        //check password field
        try {
            password = EditAccountEmployee.getPassword();
        } catch (RuntimeException e) {
            EditAccountEmployee.showErrorMessage("Error!", e.getMessage());
            pwd_ok = false;
        }

        //only update employee if all fields are valid
        if (email_ok && phone_ok && pwd_ok) {

            currEmployee.setEmail(email);
            currEmployee.setPassword(password);
            currEmployee.setPhone(phone);
            currEmployee.setName(EditAccountEmployee.getName());
            currEmployee.setAddress(EditAccountEmployee.getAddress());
        }

    }

    public void Delete(){
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        employeeDAO.delete(currEmployee);
    }

}
