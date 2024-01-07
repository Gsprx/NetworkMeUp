package com.example.networkmeup.domain;

import java.util.ArrayList;

/**
 * The Employer class represents an entity or company seeking employees for jobs, containing company details and job listings.
 */
public class Employer {
    private String companyName; // Name of the company
    private String sector; // Industry sector of the company
    private Email email; // Email address of the employer
    private Phone phone; // Phone number of the employer
    private Password password; // Password for employer authentication
    private TIN tin; // Tax Identification Number for the company
    private ArrayList<Job> jobs; // List of job listings by the employer

    /**
     * Constructor to create an Employer object with email, phone, password, and TIN.
     * Initializes the jobs list for the employer.
     * @param email The employer's email.
     * @param phone The employer's phone number.
     * @param password The employer's password.
     * @param tin The Tax Identification Number (TIN) for the company.
     * @throws NullPointerException if any of the parameters is null.
     */
    public Employer(Email email, Phone phone, Password password, TIN tin){
        validateData(email,phone,password,tin);
        jobs = new ArrayList<>();
        companyName = "";
        sector = "";
    }

    /**
     * Validates the email, phone, password, and TIN parameters.
     * @param email The employer's email.
     * @param phone The employer's phone number.
     * @param password The employer's password.
     * @param tin The Tax Identification Number (TIN) for the company.
     * @throws NullPointerException if any of the parameters is null.
     */
    private void validateData(Email email, Phone phone, Password password, TIN tin){
        if(email == null){
            throw new NullPointerException("Email cannot be null.");
        }
        if(phone == null){
            throw new NullPointerException("Phone cannot be null.");
        }
        if(password == null){
            throw new NullPointerException("Password cannot be null.");
        }
        if(tin == null){
            throw new NullPointerException("TIN cannot be null");
        }
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.tin = tin;
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
     * Sets the email for the employer.
     * @param email The email to set for the employer.
     * @throws NullPointerException if the email is null.
     */
    public void setEmail(Email email){
        validateData(email,this.phone, this.password, this.tin);
    }

    /**
     * Sets the phone number for the employer.
     * @param phone The phone number to set for the employer.
     * @throws NullPointerException if the phone number is null.
     */
    public void setPhone(Phone phone){
        validateData(this.email,phone, this.password, this.tin);
    }

    /**
     * Sets the password for the employer.
     * @param password The password to set for the employer.
     * @throws NullPointerException if the password is null.
     */
    public void setPassword(Password password){
        validateData(this.email,this.phone, password, this.tin);
    }

    /**
     * Sets the Tax Identification Number (TIN) for the employer's company.
     * @param tin The Tax Identification Number (TIN) to set for the employer.
     * @throws NullPointerException if the TIN is null.
     */
    public void setTin(TIN tin){
        validateData(this.email,this.phone, this.password, tin);
    }

    /**
     * Retrieves the email of the employer.
     * @return The email of the employer.
     */
    public Email getEmail() {
        return email;
    }

    /**
     * Retrieves the phone number of the employer.
     * @return The phone number of the employer.
     */
    public Phone getPhone() {
        return phone;
    }

    /**
     * Retrieves the password of the employer.
     * @return The password of the employer.
     */
    public Password getPassword() {
        return password;
    }

    /**
     * Retrieves the Tax Identification Number (TIN) of the employer's company.
     * @return The Tax Identification Number (TIN) of the employer.
     */
    public TIN getTin() {
        return tin;
    }

    /**
     * Retrieves the company name of the employer.
     * @return The company name of the employer.
     */

    public String getCompanyName() {
        return companyName;
    }

    /**
     * Sets the company name for the employer.
     * @param companyName The company name to set for the employer.
     * @throws NullPointerException if the company name is null.
     */
    public void setCompanyName(String companyName) {
        validateObject(companyName);
        this.companyName = companyName;
    }

    /**
     * Retrieves the industry sector of the employer's company.
     * @return The industry sector of the employer.
     */
    public String getSector() {
        return sector;
    }

    /**
     * Sets the industry sector for the employer's company.
     * @param sector The industry sector to set for the employer.
     * @throws NullPointerException if the industry sector is null.
     */
    public void setSector(String sector) {
        validateObject(sector);
        this.sector = sector;
    }

    /**
     * Adds a job listing to the employer's list of jobs.
     * @param job The job listing to add.
     * @throws NullPointerException if the job is null.
     */
    public void addJob (Job job){
        validateObject(job);
        this.jobs.add(job);
    }

    /**
     * Retrieves the list of job listings made by the employer.
     * @return ArrayList containing job listings.
     */
    public ArrayList<Job> getJobs(){
        return jobs;
    }

    /**
     * Checks equality between two Employer objects based on email, phone, or TIN.
     * @param e Another Employer object to compare.
     * @return true if the emails, phones, or TINs are equal, false otherwise.
     */
    public boolean equals(Employer e){
        return this.email.equals(e.getEmail()) || this.phone.equals(e.getPhone()) || this.tin.equals(e.getTin());
    }

    /**
     * Checks if the employer has a specific email.
     * @param email The email to check.
     * @return true if the employer's email matches the provided email, false otherwise.
     */
    public boolean hasEmail(Email email){
        return this.email.equals(email);
    }
}
