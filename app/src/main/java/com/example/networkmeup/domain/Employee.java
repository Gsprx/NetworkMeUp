package com.example.networkmeup.domain;

import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * The Employee class represents an individual working within a network and holds various personal and professional details.
 */
public class Employee implements Serializable {
    private String name; // Employee's name
    private Date dateOfBirth; // Employee's date of birth
    private String address; // Employee's address
    private String profileImage; // Path to the employee's profile image
    private Email email; // Employee's email address
    private Phone phone; // Employee's phone number
    private Password password; // Employee's password
    private CV cv; // Employee's curriculum vitae
    private ArrayList<Application> applications; // List of job applications made by the employee

    /**
     * Constructor to create an Employee object with email, phone, and password.
     * Initializes the applications list and CV for the employee.
     * @param email The employee's email.
     * @param phone The employee's phone number.
     * @param password The employee's password.
     * @throws NullPointerException if any of the parameters is null.
     */
    public Employee(Email email, Phone phone, Password password) {
        validateData(email,phone,password);
        applications = new ArrayList<>();
        cv = new CV();
    }

    /**
     * Validates the email, phone, and password parameters.
     * @param email The employee's email.
     * @param phone The employee's phone number.
     * @param password The employee's password.
     * @throws NullPointerException if any of the parameters is null.
     */
    private void validateData(Email email, Phone phone, Password password){
        if(email == null){
            throw new NullPointerException("Email cannot be null.");
        }
        if(phone == null){
            throw new NullPointerException("Phone cannot be null.");
        }
        if(password == null){
            throw new NullPointerException("Password cannot be null.");
        }
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    /**
     * Validates if the object is null.
     * @param obj The object to be validated.
     * @throws NullPointerException if the object is null.
     */
    private void validateObject(Object obj){
        if(obj == null){
            throw new NullPointerException("Object cannot be null");
        }
    }

    /**
     * Retrieves the employee's name.
     * @return The employee's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the employee's name.
     * @param name The name to set for the employee.
     * @throws NullPointerException if the name is null.
     */
    public void setName(String name) {
        validateObject(name); // Validates if the name is not null
        this.name = name;
    }

    /**
     * Retrieves the employee's date of birth.
     * @return The employee's date of birth.
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the employee's date of birth.
     * @param dateOfBirth The date of birth to set for the employee.
     * @throws NullPointerException if the date of birth is null.
     */
    public void setDateOfBirth(Date dateOfBirth) {
        validateObject(dateOfBirth); // Validates if the date of birth is not null
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Retrieves the employee's address.
     * @return The employee's address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the employee's address.
     * @param address The address to set for the employee.
     * @throws NullPointerException if the address is null.
     */
    public void setAddress(String address) {
        validateObject(address); // Validates if the address is not null
        this.address = address;
    }

    /**
     * Retrieves the employee's email address.
     * @return The employee's email address.
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Sets the employee's email address.
     * @param email The email address to set for the employee.
     * @throws NullPointerException if the email is null.
     */
    public void setEmail(Email email) {
        validateData(email,this.phone, this.password);
    }

    /**
     * Retrieves the employee's phone number.
     * @return The employee's phone number.
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * Sets the employee's phone number.
     * @param phone The phone number to set for the employee.
     * @throws NullPointerException if the phone number is null.
     */
    public void setPhone(Phone phone) {
        validateData(this.email,phone, this.password);
    }

    /**
     * Retrieves the employee's password.
     * @return The employee's password.
     */
    public Password getPassword() {
        return password;
    }

    /**
     * Sets the employee's password.
     * @param password The password to set for the employee.
     * @throws NullPointerException if the password is null.
     */
    public void setPassword(Password password) {
        validateData(this.email,this.phone, password);
    }

    /**
     * Sets the profile image path for the employee.
     * @param imagepath The path to the profile image.
     * @throws NullPointerException if the image path is null.
     */
    public void setProfileImage(String imagepath){
        validateObject(imagepath); // Validates if the image path is not null
        this.profileImage = imagepath;
    }

    /**
     * Retrieves the profile image path of the employee.
     * @return The path to the profile image.
     */
    public String getProfileImage(){
        return profileImage;
    }

    /**
     * Retrieves the list of job applications made by the employee.
     * @return ArrayList containing job applications.
     */
    public ArrayList<Application> getApplications(){
        return applications;
    }

    /**
     * Adds a job application to the list of applications made by the employee.
     * @param appl The application to add.
     * @throws NullPointerException if the application is null.
     */
    public void addApplication(Application appl){
        validateObject(appl); // Validates if the application is not null
        applications.add(appl);
    }

    /**
     * Sets the curriculum vitae (CV) for the employee.
     * @param cv The CV to set for the employee.
     * @throws NullPointerException if the CV is null.
     */
    public void setCV(CV cv){
        validateObject(cv); // Validates if the CV is not null
        this.cv = cv;
    }

    /**
     * Retrieves the curriculum vitae (CV) of the employee.
     * @return The employee's curriculum vitae (CV).
     */
    public CV getCV(){
        return cv;
    }

    /**
     * Checks equality between two Employee objects based on email or phone.
     * @param e Another Employee object to compare.
     * @return true if the emails or phones are equal, false otherwise.
     */
    public boolean equals(Employee e) {
        validateObject(e);
        //we consider two employees equal if they have the same phone and or email
        return (this.email.equals(e.getEmail()) || this.phone.equals(e.getPhone()));
    }

    /**
     * Checks if the employee has a specific email.
     * @param email The email to check.
     * @return true if the employee's email matches the provided email, false otherwise.
     */
    public boolean hasEmail(Email email){
        return this.email.equals(email);
    }
}


