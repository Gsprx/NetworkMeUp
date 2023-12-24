package com.example.networkmeup.daoMemory;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Phone;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class EmployeeDAOMemory implements EmployeeDAO {
    protected static ArrayList<Employee> employees;

    public EmployeeDAOMemory(){
        if(employees==null){
            employees = new ArrayList<>();
        }
    }
    @Override
    public void delete(Employee employee){
        employees.remove(employee);
    }

    @Override
    public ArrayList<Employee> getAll() {
        return new ArrayList<Employee>(employees);
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
