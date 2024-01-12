package com.example.networkmeup.view.SignUp.SignUpEmployee;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;

/**
 * Presenter for the SignUpEmployee view.
 * <p>
 * This class handles the business logic associated with signing up a new employee.
 * It communicates with the view for input and validation feedback and uses the EmployeeDAO for data persistence.
 * </p>
 */
public class SignUpEmployeePresenter {
    private SignUpEmployeeView signUpEmployeeView;
    private EmployeeDAO employeeDAO;

    /**
     * Constructs a SignUpEmployeePresenter with the specified view and data access object.
     *
     * @param view        The SignUpEmployee view interface
     * @param employeeDAO The data access object for Employee
     */
    public SignUpEmployeePresenter(SignUpEmployeeView view, EmployeeDAO employeeDAO){
        this.signUpEmployeeView = view;
        this.employeeDAO = employeeDAO;
    }

    /**
     * Handles the creation of a new employee account.
     * <p>
     * This method validates the user input for email, phone, and password.
     * If validation passes, it checks if an employee with the same email or phone already exists.
     * If no such employee exists, it proceeds to create a new employee account.
     * </p>
     */

    public void onCreate(){

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
                signUpEmployeeView.showErrorMessage("Account Creation Error", "An employee account already exists with the same email or phone number!");
            }
            else {
                employeeDAO.save(employee);
                signUpEmployeeView.successfullyFinishActivity("Your NetworkMeUp Employee account was created!");
            }
        }
    }
}
