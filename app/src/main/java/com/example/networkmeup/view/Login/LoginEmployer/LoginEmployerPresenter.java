package com.example.networkmeup.view.Login.LoginEmployer;

import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;

/**
 * The presenter class responsible for handling employer login functionality.
 * It interacts with the LoginEmployerView and EmployerDAO to facilitate the login process.
 */
public class LoginEmployerPresenter {

    private LoginEmployerView view;
    private EmployerDAO employerDAO;

    /**
     * Constructor for the LoginEmployerPresenter.
     *
     * @param view        The associated LoginEmployerView.
     * @param employerDAO The EmployerDAO instance used for employer authentication.
     */
    public LoginEmployerPresenter(LoginEmployerView view, EmployerDAO employerDAO) {
        this.view = view;
        this.employerDAO = employerDAO;
    }

    /**
     * Method triggered when the employer attempts to log in.
     * Validates the email and password provided by the employer.
     * It authenticates the employer and manages the subsequent actions based on the authentication result.
     */
    public void onLogin() {
        boolean email_ok = true;
        boolean pwd_ok = true;

        Email email = null;
        Password password = null;

        // Check email field
        try {
            email = view.getEmail();
        } catch (RuntimeException e) {
            view.showErrorMessage("Error!", e.getMessage());
            email_ok = false;
        }

        // Check password field
        try {
            password = view.getPassword();
        } catch (RuntimeException e) {
            view.showErrorMessage("Error!", e.getMessage());
            pwd_ok = false;
        }

        // Proceed with login only if both email and password are valid
        if (email_ok && pwd_ok) {
            // Authenticate employer credentials
            boolean isAuthenticated = employerDAO.authenticate(email, password);

            if (isAuthenticated) {
                // If the employer exists, finish login successfully
                view.successfullyFinishLogin(email.getAddress());
            } else {
                // If the employer doesn't exist, show an error message
                view.showErrorMessage("Login Error", "Invalid credentials!");
            }
        }
    }
}

