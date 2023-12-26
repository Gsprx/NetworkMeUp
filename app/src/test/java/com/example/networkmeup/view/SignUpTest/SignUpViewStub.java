package com.example.networkmeup.view.SignUpTest;

import com.example.networkmeup.view.SignUp.SignUpPresenter;
import com.example.networkmeup.view.SignUp.SignUpView;

/**
 * This class represents a stub of the SignUpView interface. It's used for testing SignUpPresenter functionality.
 */
public class SignUpViewStub implements SignUpView {
    private int employeeClicks; // Counter to track the number of clicks on the Employee sign-up button
    private int employerClicks; // Counter to track the number of clicks on the Employer sign-up button
    private SignUpPresenter presenter; // Reference to the associated SignUpPresenter

    /**
     * Default constructor for SignUpViewStub.
     */
    public SignUpViewStub (){
    }

    /**
     * Method to simulate a click on the Employee sign-up button.
     * It increments the employeeClicks counter.
     */
    public void employee(){
        employeeClicks++;
    }

    /**
     * Method to simulate a click on the Employer sign-up button.
     * It increments the employerClicks counter.
     */
    public void employer(){
        employerClicks++;
    }

    /**
     * Getter method to retrieve the associated SignUpPresenter.
     * @return The SignUpPresenter instance associated with this view.
     */
    public SignUpPresenter getPresenter() {
        return presenter;
    }

    /**
     * Setter method to set the SignUpPresenter for this view.
     * @param presenter The SignUpPresenter instance to be set for this view.
     */
    public void setPresenter(SignUpPresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Getter method to retrieve the number of clicks on the Employee sign-up button.
     * @return The count of clicks on the Employee sign-up button.
     */
    public int getEmployeeClicks() {
        return employeeClicks;
    }

    /**
     * Getter method to retrieve the number of clicks on the Employer sign-up button.
     * @return The count of clicks on the Employer sign-up button.
     */
    public int getEmployerClicks() {
        return employerClicks;
    }
}
