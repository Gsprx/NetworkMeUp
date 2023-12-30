package com.example.networkmeup.daoMemory;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * EmployeeDAOMemory class implements the EmployeeDAO interface
 * and manages employee-related data in memory.
 */
public class EmployeeDAOMemory implements EmployeeDAO {
    protected static ArrayList<Employee> employees;

    /**
     * Constructor for initializing the ArrayList of employees if it's null.
     */
    public EmployeeDAOMemory(){
        if(employees==null){
            employees = new ArrayList<>();
        }
    }

    /**
     * Deletes the specified employee from the ArrayList.
     *
     * @param employee The Employee object to be deleted.
     */
    @Override
    public void delete(Employee employee){
        employees.remove(employee);
    }

    /**
     * Retrieves a new ArrayList containing all employees.
     *
     * @return A new ArrayList containing all Employee objects.
     */
    @Override
    public ArrayList<Employee> getAll() {
        return new ArrayList<Employee>(employees);
    }

    /**
     * Saves an employee to the ArrayList.
     *
     * @param employee The Employee object to be saved.
     */
    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }

    /**
     * Checks if the specified employee exists in the ArrayList.
     *
     * @param employee The Employee object to check for existence.
     * @return True if the Employee exists, otherwise False.
     */
    @Override
    public boolean find(Employee employee) {
        for(Employee e : employees){
            if(e.equals(employee)){
                return true;
            }
        }
        return false;
    }

    /**
     * Retrieves an Employee object based on the provided email address.
     *
     * @param email The Email object representing the email address of the employee.
     * @return The Employee object associated with the provided email, if found; otherwise null.
     */
    @Override
    public Employee getByEmail(Email email) {
        for(Employee e : employees){
            if(e.hasEmail(email)){
                return e;
            }
        }
        return null;
    }

    /**
     * Authenticates an employee based on provided email and password.
     *
     * @param email    The email input for authentication.
     *                 It represents the email of the employee attempting to log in.
     * @param password The password input for authentication.
     *                 It represents the password of the employee attempting to log in.
     * @return {@code true} if the provided email and password match an employee's credentials,
     *         indicating successful authentication. Otherwise, returns {@code false}
     *         if no match is found, signifying failed authentication.
     */
    @Override
    public boolean authenticate(Email email, Password password) {
        // Loop through the stored employees to find a match for the provided email and password
        for (Employee employee : employees) {
            // Check if the provided email and password match any stored employee's credentials
            if (employee.getEmail().equals(email) && employee.getPassword().equals(password)) {
                return true; // Authentication successful
            }
        }
        return false; // No match found, authentication failed
    }
}
