package com.example.networkmeup.view.LoginTest;

import com.example.networkmeup.view.Login.LoginPresenter;
import com.example.networkmeup.view.Login.LoginView;
import com.example.networkmeup.view.SignUp.SignUpPresenter;

/**
 * This class acts as a stub implementation of the LoginView interface for testing purposes.
 * It simulates a view and keeps track of employee and employer login actions.
 */
public class LoginViewStub implements LoginView {

    private int employeeclicks; // Counter for employee login clicks

    private int employerclicks; // Counter for employer login clicks

    private LoginPresenter presenter; // Reference to the LoginPresenter

    /**
     * Default constructor.
     */
    public LoginViewStub(){}

    /**
     * Simulates an employee login action by incrementing the employee clicks counter.
     */
    public void EmployeeLogin(){
        employeeclicks++;
    }

    /**
     * Simulates an employer login action by incrementing the employer clicks counter.
     */
    public void EmployerLogin(){
        employerclicks++;
    }

    /**
     * Getter method for retrieving the presenter associated with this view stub.
     *
     * @return The LoginPresenter associated with this view stub.
     */
    public LoginPresenter getPresenter() {
        return presenter;
    }

    /**
     * Setter method for setting the presenter associated with this view stub.
     *
     * @param presenter The LoginPresenter to associate with this view stub.
     */
    public void setPresenter(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Getter method for retrieving the number of employee login clicks.
     *
     * @return The count of employee login clicks.
     */
    public int getEmployeeClicks() {
        return employeeclicks;
    }

    /**
     * Getter method for retrieving the number of employer login clicks.
     *
     * @return The count of employer login clicks.
     */
    public int getEmployerClicks() {
        return employerclicks;
    }
}
