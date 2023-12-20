package com.example.networkmeup.daoMemory;

import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;

import java.util.ArrayList;

public class EmployerDAOMemory implements EmployerDAO{
    protected static ArrayList<Employer> employers;

    public EmployerDAOMemory(){
        if(employers == null){
            employers = new ArrayList<>();
        }
    }
    @Override
    public void delete(Employer employer) {
        employers.remove(employer);
    }

    @Override
    public ArrayList<Employer> getAll() {

        return new ArrayList<Employer>(employers);
    }

    @Override
    public void save(Employer employer) {
        employers.add(employer);
    }

    @Override
    public boolean find(Employer employer) {
        for(Employer e : employers){
            if(e.equals(employer)){
                return true;
            }
        }
        return false;
    }
}
