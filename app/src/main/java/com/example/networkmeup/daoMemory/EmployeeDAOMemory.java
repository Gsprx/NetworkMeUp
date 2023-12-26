package com.example.networkmeup.daoMemory;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
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
}
