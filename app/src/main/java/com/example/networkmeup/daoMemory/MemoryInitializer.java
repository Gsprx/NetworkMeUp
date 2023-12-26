package com.example.networkmeup.daoMemory;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;

/**
 * MemoryInitializer class extends Initializer and is responsible for
 * initializing and erasing data related to employees and employers in memory.
 */
public class MemoryInitializer extends Initializer {

    /**
     * Method to erase all existing data of employees and employers.
     */
    @Override
    protected void eraseData(){

        // Remove all employees
        for(Employee employee : getEmployeeDAO().getAll()){
            getEmployeeDAO().delete(employee);
        }

        // Remove all employers
        for(Employer employer : getEmployerDAO().getAll()){
            getEmployerDAO().delete(employer);
        }
    }

    /**
     * Provides an instance of EmployeeDAO for managing employee-related data.
     *
     * @return EmployeeDAO instance (EmployeeDAOMemory)
     */
    public EmployeeDAO getEmployeeDAO(){
        return new EmployeeDAOMemory();
    }

    /**
     * Provides an instance of EmployerDAO for managing employer-related data.
     *
     * @return EmployerDAO instance (EmployerDAOMemory)
     */
    @Override
    public EmployerDAO getEmployerDAO() {
        return new EmployerDAOMemory();
    }

}
