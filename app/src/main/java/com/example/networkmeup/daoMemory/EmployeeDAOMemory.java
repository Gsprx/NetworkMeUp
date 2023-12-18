package com.example.networkmeup.daoMemory;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.domain.Employee;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EmployeeDAOMemory implements EmployeeDAO {
    protected static ArrayList<Employee> employees;
    @Override
    public void delete(Employee employee){
        employees.remove(employee);
    }

    @Override
    public ArrayList<Employee> getAll() {
        ArrayList<Employee> result = new ArrayList<>();
        result.addAll(employees);
        return result;
    }

    @Override
    public void save(Employee employee) {
        employees.add(employee);
    }

    @Override
    public boolean find(Employee employee) {
        for(Employee e : employees){
            if(e.equals(employee)){
                return true;
            }
        }
        return false;
    }
}
