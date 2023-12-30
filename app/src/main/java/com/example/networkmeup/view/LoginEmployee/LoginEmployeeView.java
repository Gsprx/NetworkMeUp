package com.example.networkmeup.view.LoginEmployee;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;

/**
 * This interface defines the contract for the view responsible for Employee Login functionality.
 * It provides methods to retrieve login credentials, display error messages, and indicate a successful login attempt.
 */
public interface LoginEmployeeView {

    /**
     * Retrieves the email input from the user for login.
     *
     * @return An Email object containing the entered email address.
     * @throws RuntimeException if there's an issue acquiring the email.
     */
    Email getEmail() throws RuntimeException;

    /**
     * Retrieves the password input from the user for login.
     *
     * @return A Password object containing the entered password.
     * @throws RuntimeException if there's an issue acquiring the password.
     */
    Password getPassword() throws RuntimeException;

    /**
     * Displays an error message on the login screen.
     *
     * @param title   The title for the error message dialog.
     * @param message The error message to be displayed.
     */
    void showErrorMessage(String title, String message);

    /**
     * Indicates a successful login attempt and triggers navigation to the next screen.
     *
     * @param userToken token passed for user indexing for later pages.
     */
    void successfullyFinishLogin(String userToken);
}
