package com.example.networkmeup.view.EditAccountEmployer;

import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;
public class EditAccountEmployerPresenter {

    private String userToken;
    private EditAccountEmployerView EditAccountEmployer;

    // Fetching employer data from DAO
    public EditAccountEmployerPresenter(String userToken, EditAccountEmployerView editAccountEmployerView){
        this.userToken = userToken;
        this.EditAccountEmployer = editAccountEmployerView;
    }

    public void Save() {
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
        if (email_ok && phone_ok && pwd_ok && tin_ok) {
            Employer employer = new EmployerDAOMemory().getByEmail(new Email(userToken));

            employer.setCompanyName(EditAccountEmployer.getCompanyName());
            employer.setSector(EditAccountEmployer.getSector());
            employer.setEmail(email);
            employer.setPassword(password);
            employer.setPhone(phone);
            employer.setTin(tin);

        }

    }
    public void Delete(){

        Employer employer = new EmployerDAOMemory().getByEmail(new Email(userToken));
        new EmployerDAOMemory().delete(employer);
    }

}
