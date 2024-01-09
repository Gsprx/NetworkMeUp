package com.example.networkmeup.domain;

import java.io.Serializable;

/**
 * The Application class represents a job application submitted by an Employee.
 */
public class Application implements Serializable {
    private Employee applicant; // Represents the applicant who submitted the application
    private static Integer classCount = 0; // Keeps track of the number of Application instances
    private Integer ID; // Unique identifier for each application
    private boolean status; // Indicates the status of the application (accepted/rejected)
    private boolean answered; //Indicates if the application has been answered by the employer
    private String coverLetter; // The cover letter submitted with the application


    /**
     * Constructor to create an Application object with an applicant and a cover letter.
     * @param applicant The employee who is the applicant.
     * @param coverLetter The cover letter submitted with the application.
     */
    public Application(Employee applicant, String coverLetter){
        validateData(applicant, coverLetter); // Validate the input data
        this.applicant = applicant;
        this.coverLetter = coverLetter;
        classCount++; // Increment the count of Application instances
        this.ID = classCount; // Assign a unique ID to the application
        this.answered = false;
    }

    /**
     * Validates the input data for the application.
     * @param employee The applicant employee.
     * @param coverLetter The cover letter submitted with the application.
     */
    private void validateData(Employee employee, String coverLetter){
        // Check if the employee or cover letter is null and throw exceptions if so
        if(employee == null){
            throw new NullPointerException("Employee field cannot be null.");
        }
        if(coverLetter == null){
            throw new NullPointerException("Cover letter field cannot be null.");
        }
        return;
    }
    /**
     * Gets the status of the application.
     * @return The status of the application (true if accepted, false if rejected).
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Sets the status of the application.
     * @param status The status to be set (true for accepted, false for rejected).
     */
    public void setStatus(boolean status) {
        this.status = status;
        this.answered = true;
    }
    public boolean getAnswered(){
        return this.answered;
    }

    /**
     * Gets the applicant employee.
     * @return The employee who submitted the application.
     */
    public Employee getEmployee() {
        return applicant;
    }

    /**
     * Gets the unique ID of the application.
     * @return The ID of the application.
     */
    public Integer getID() {
        return ID;
    }


    //ONLY FOR TESTING PURPOSES!!!
    /**
     * Sets the ID of the application (only for testing purposes).
     * @param id The ID to be set.
     */
    public void setID(Integer id){
        this.ID = id;
    }
    //ONLY FOR TESTING PURPOSES!!!

    /**
     * Gets the cover letter submitted with the application.
     * @return The cover letter of the application.
     */
    public String getCoverLetter() {
        return coverLetter;
    }
}
