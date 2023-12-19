package com.example.networkmeup.dao;

import com.example.networkmeup.domain.Employer;

import java.util.ArrayList;

public interface EmployerDAO {
    public void delete(Employer employer);
    public ArrayList<Employer> getAll();
    public void save(Employer employer);
    public boolean find(Employer employer);
}
