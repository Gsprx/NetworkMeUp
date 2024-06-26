package com.example.networkmeup.daoMemory;

import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.Password;

import java.util.ArrayList;

/**
 * EmployerDAOMemory class implements the EmployerDAO interface
 * and manages employer-related data in memory.
 */
public class EmployerDAOMemory implements EmployerDAO{
    protected static ArrayList<Employer> employers;

    /**
     * Constructor for initializing the ArrayList of employers if it's null.
     */
    public EmployerDAOMemory(){
        if(employers == null){
            employers = new ArrayList<>();
        }
    }

    /**
     * Deletes the specified employer from the ArrayList.
     *
     * @param employer The Employer object to be deleted.
     */
    @Override
    public void delete(Employer employer) {
        employers.remove(employer);
    }

    /**
     * Retrieves a new ArrayList containing all employers.
     *
     * @return A new ArrayList containing all Employer objects.
     */
    @Override
    public ArrayList<Employer> getAll() {

        return new ArrayList<Employer>(employers);
    }

    /**
     * Saves an employer to the ArrayList.
     *
     * @param employer The Employer object to be saved.
     */
    @Override
    public void save(Employer employer) {
        employers.add(employer);
    }

    /**
     * Checks if the specified employer exists in the ArrayList.
     *
     * @param employer The Employer object to check for existence.
     * @return True if the Employer exists, otherwise False.
     */
    @Override
    public boolean find(Employer employer) {
        for(Employer e : employers){
            if(e.equals(employer)){
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves an Employer object based on the provided email address.
     *
     * @param email The Email object representing the email address of the employer.
     * @return The Employer object associated with the provided email, if found; otherwise null.
     */
    @Override
    public Employer getByEmail(Email email) {
        for(Employer e : employers)
            if(e.hasEmail(email)){
                return e;
            }
        return null;
    }

    /**
     * Method to authenticate an employer based on provided email and password.
     *
     * @param email    The email of the employer for authentication.
     * @param password The password of the employer for authentication.
     * @return True if the provided email and password match any stored employer's credentials, false otherwise.
     */
    public boolean authenticate(Email email, Password password) {
        for (Employer employer : employers) {
            // Check if the provided email and password match any stored employer's credentials
            if (employer.getEmail().equals(email) && employer.getPassword().equals(password)) {
                return true; // Authentication successful
            }
        }
        return false; // No match found, authentication failed
    }

    /**
     * Retrieves an Employer object based on the provided job.
     * @param job The job of an employer.
     * @return The Employer object associated with the provided job, if found; otherwise null
     */
    @Override
    public Employer getByJob(Job job) {
        for(Employer employer : employers){
            for(Job mjob : employer.getJobs()){
                if(mjob.equals(job)){
                    return employer;
                }
            }
        }
        return null;
    }
}
