package com.example.networkmeup.dao;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Phone;

import java.util.ArrayList;

/**
 * EmployerDAO interface outlines the methods that should be implemented by classes
 * responsible for handling Employer data access operations.
 */
public interface EmployerDAO {

    /**
     * Deletes the specified employer from the data source.
     *
     * @param employer The Employer object to be deleted.
     */
    public void delete(Employer employer);

    /**
     * Retrieves a list of all employers from the data source.
     *
     * @return An ArrayList containing all the Employer objects.
     */
    public ArrayList<Employer> getAll();

    /**
     * Saves or updates the information of an employer in the data source.
     *
     * @param employer The Employer object to be saved or updated.
     */
    public void save(Employer employer);

    /**
     * Checks if the specified employer exists in the data source.
     *
     * @param employer The Employer object to check for existence.
     * @return True if the Employer exists, otherwise False.
     */
    public boolean find(Employer employer);

    /**
     * Retrieves an Employer object based on the provided email address.
     *
     * @param email The Email object representing the email address of the employer.
     * @return The Employer object associated with the provided email, if found; otherwise null.
     */
    public Employer getByEmail(Email email);
}
