package com.example.networkmeup.view.Login;
/**
 * LoginPresenter is responsible for handling the user actions from the LoginActivity.
 * <p>
 * This class acts as an intermediary between the view (LoginActivity) and the model.
 * It processes the user interactions, making calls to view methods based on the user's actions.
 * </p>
 */
public class LoginPresenter {
    private LoginView view;
    /**
     * Constructor for LoginPresenter.
     *
     * @param view The interface to the view that this presenter manages.
     */
    public LoginPresenter(LoginView view){
        this.view = view;
    }
    /**
     * Handles the action when the user decides to log in as an employee.
     * <p>
     * This method is called when the user presses the button to log in as an employee.
     * It triggers the corresponding method in the view to navigate to the Employee login screen.
     * </p>
     */
    public void onLoginEmployee() {
        view.EmployeeLogin();
    }
    /**
     * Handles the action when the user decides to log in as an employer.
     * <p>
     * This method is called when the user presses the button to log in as an employer.
     * It triggers the corresponding method in the view to navigate to the Employer login screen.
     * </p>
     */
    public void onLoginEmployer(){
        view.EmployerLogin();
    }
}


