package com.example.networkmeup.view.EditAccountEmployer;

import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;
public class EditAccountEmployerPresenter {

    private EditAccountEmployerView EditAccountEmployer;

    // Fetching employer data from DAO
    EmployerDAO employerDAO = new EmployerDAOMemory();

    public EditAccountEmployerPresenter(EditAccountEmployerActivity editAccountEmployerActivity) {
        this.EditAccountEmployer = editAccountEmployerActivity;
    }

    public void onCreate() {
        boolean email_ok = true;
        boolean phone_ok = true;
        boolean tin_ok = true;
        boolean pwd_ok = true;

        Email email = null;
        Phone phone = null;
        TIN tin = null;
        Password password = null;


        //check email field
        try {
            email = EditAccountEmployer.getEmail();
        } catch (RuntimeException e) {
            EditAccountEmployer.showErrorMessage("Error!", e.getMessage());
            email_ok = false;
        }

        //check phone field
        try {
            phone = EditAccountEmployer.getPhoneNumber();
        } catch (RuntimeException e) {
            EditAccountEmployer.showErrorMessage("Error!", e.getMessage());
            phone_ok = false;
        }

        //check tin field
        try {
            tin = EditAccountEmployer.getTIN();
        } catch (RuntimeException e) {
            EditAccountEmployer.showErrorMessage("Error!", e.getMessage());
            tin_ok = false;
        }

        //check password field
        try {
            password = EditAccountEmployer.getPassword();
        } catch (RuntimeException e) {
            EditAccountEmployer.showErrorMessage("Error!", e.getMessage());
            pwd_ok = false;
        }

        //only update employee if all fields are valid
        if (email_ok && phone_ok && pwd_ok) {

            EditAccountEmployer.getCurrEmployer().setEmail(email);
            EditAccountEmployer.getCurrEmployer().setPassword(password);
            EditAccountEmployer.getCurrEmployer().setPhone(phone);

        }

    }

    public void Delete(Employer curEmployer){
        employerDAO.delete(curEmployer);
    }
}
