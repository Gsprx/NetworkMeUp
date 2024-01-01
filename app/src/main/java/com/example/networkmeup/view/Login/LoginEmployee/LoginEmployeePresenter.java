package com.example.networkmeup.view.Login.LoginEmployee;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;

public class LoginEmployeePresenter {
    private final LoginEmployeeView loginEmployeeView;
    private final EmployeeDAO employeeDAO;

    // Constructor initializing the presenter with a view and an EmployeeDAO instance
    public LoginEmployeePresenter(LoginEmployeeView view, EmployeeDAO employeeDAO) {
        this.loginEmployeeView = view;
        this.employeeDAO = employeeDAO;
    }

    // Method triggered when the login button is clicked
    public void onLogin() {
        boolean email_ok = true;
        boolean pwd_ok = true;

        Email email = null;
        Password password = null;

        // Validate email field
        try {
            email = loginEmployeeView.getEmail();
        } catch (RuntimeException e) {
            loginEmployeeView.showErrorMessage("Error!", e.getMessage());
            email_ok = false;
        }

        // Validate password field
        try {
            password = loginEmployeeView.getPassword();
        } catch (RuntimeException e) {
            loginEmployeeView.showErrorMessage("Error!", e.getMessage());
            pwd_ok = false;
        }

        // Proceed with login only if both email and password are valid
        if (email_ok && pwd_ok) {
            // Create an Employee object for authentication
            // For login functionality, check if the employee exists in the database
            // In a real application, there would likely be additional authentication logic
            // But here, we are simply checking if the employee exists in the DAO
            boolean isAuthenticated = employeeDAO.authenticate(email, password);

            if (isAuthenticated) {
                // If the employee exists, finish login successfully
                // pass user email as login token
                loginEmployeeView.successfullyFinishLogin(email.getAddress());
            } else {
                // If the employee doesn't exist, show an error message
                loginEmployeeView.showErrorMessage("Login Error", "Invalid credentials!");
            }
        }
    }
}
