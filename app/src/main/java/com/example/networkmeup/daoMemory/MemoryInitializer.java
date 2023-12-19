package com.example.networkmeup.daoMemory;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.dao.Initializer;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;

public class MemoryInitializer extends Initializer {
    @Override
    protected void eraseData(){
        //remove all employees
        for(Employee employee : getEmployeeDAO().getAll()){
            getEmployeeDAO().delete(employee);
        }
        //remove all employers
        for(Employer employer : getEmployerDAO().getAll()){
            getEmployerDAO().delete(employer);
        }
    }

    public EmployeeDAO getEmployeeDAO(){
        return new EmployeeDAOMemory();
    }

    @Override
    public EmployerDAO getEmployerDAO() {
        return new EmployerDAOMemory();
    }

}
