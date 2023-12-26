package com.example.networkmeup.daoMemory;

import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;

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
        for(Employer e : employers){
            if(e.hasEmail(email)){
                return e;
            }
        }
        return null;
    }
}
