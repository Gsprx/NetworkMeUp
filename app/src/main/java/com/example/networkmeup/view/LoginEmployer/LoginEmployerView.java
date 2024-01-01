package com.example.networkmeup.view.LoginEmployer;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;

/**
 * This interface defines the methods to be implemented by the LoginEmployerActivity.
 * It provides a contract for the presenter to interact with the activity to handle employer login functionality.
 */
public interface LoginEmployerView {

    /**
     * Retrieves the email entered by the employer attempting to log in.
     *
     * @return Email object representing the employer's email.
     * @throws RuntimeException if there's an issue retrieving or parsing the email input.
     */
    Email getEmail() throws RuntimeException;

    /**
     * Retrieves the password entered by the employer attempting to log in.
     *
     * @return Password object representing the employer's password.
     * @throws RuntimeException if there's an issue retrieving or parsing the password input.
     */
    Password getPassword() throws RuntimeException;

    /**
     * Displays an error message in the UI.
     *
     * @param title   Title for the error message dialog box.
     * @param message Content of the error message to be displayed.
     */
    void showErrorMessage(String title, String message);

    /**
     * Indicates a successful login attempt to the activity.
     *
     * @param message Message to be displayed upon successful login.
     */
    void successfullyFinishLogin(String message);
}
