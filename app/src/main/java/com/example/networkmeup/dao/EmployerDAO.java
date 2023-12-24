package com.example.networkmeup.dao;

import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Phone;

import java.util.ArrayList;

public interface EmployerDAO {
    public void delete(Employer employer);
    public ArrayList<Employer> getAll();
    public void save(Employer employer);
    public boolean find(Employer employer);
    public Employer getByEmail(Email email);
}
