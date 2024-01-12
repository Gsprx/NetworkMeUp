package com.example.networkmeup.view.EditAccountEmployer;

import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;
/**
 * Presenter for the EditAccountEmployer activity.
 * <p>
 * This class is responsible for handling the presentation logic for editing an employer's account details.
 * It interacts with the DAO (Data Access Object) to fetch and update employer information.
 * </p>
 */
public class EditAccountEmployerPresenter {

    private String userToken;
    private EditAccountEmployerView EditAccountEmployer;
    /**
     * Constructor for EditAccountEmployerPresenter.
     * <p>
     * Initializes the presenter with the user's token and the corresponding view.
     * </p>
     *
     * @param userToken                The user token (typically an email) of the employer.
     * @param editAccountEmployerView  The view associated with this presenter.
     */
    // Fetching employer data from DAO
    public EditAccountEmployerPresenter(String userToken, EditAccountEmployerView editAccountEmployerView){
        this.userToken = userToken;
        this.EditAccountEmployer = editAccountEmployerView;
    }
    /**
     * Saves the updated account details of the employer.
     * <p>
     * Validates and updates the employer's details like email, phone number, TIN, and password.
     * Displays error messages in case of invalid inputs and updates the employer's details
     * in the database upon successful validation.
     * </p>
     */
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

            EditAccountEmployer.successfullyFinishActivity("Account details successfully changed!", userToken);

        }

    }
    /**
     * Deletes the employer's account.
     * <p>
     * Removes the employer's details from the database. This action is typically irreversible.
     * </p>
     */
    public void Delete(){

        Employer employer = new EmployerDAOMemory().getByEmail(new Email(userToken));
        new EmployerDAOMemory().delete(employer);
    }

}
