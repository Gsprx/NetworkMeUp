package com.example.networkmeup.dao;

import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;

import java.util.ArrayList;

/**
 * EmployeeDAO interface outlines the methods that should be implemented by classes
 * responsible for handling Employee data access operations.
 */
public interface EmployeeDAO {

    /**
     * Deletes the specified employee from the data source.
     *
     * @param employee The Employee object to be deleted.
     */
    public void delete(Employee employee);

    /**
     * Retrieves a list of all employees from the data source.
     *
     * @return An ArrayList containing all the Employee objects.
     */
    public ArrayList<Employee> getAll();

    /**
     * Saves or updates the information of an employee in the data source.
     *
     * @param employee The Employee object to be saved or updated.
     */
    public void save(Employee employee);

    /**
     * Checks if the specified employee exists in the data source.
     *
     * @param employee The Employee object to check for existence.
     * @return True if the Employee exists, otherwise False.
     */
    public boolean find(Employee employee);

    /**
     * Retrieves an Employee object based on the provided email address.
     *
     * @param email The Email object representing the email address of the employee.
     * @return The Employee object associated with the provided email, if found; otherwise null.
     */
    public Employee getByEmail(Email email);

}
