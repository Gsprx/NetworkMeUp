package com.example.networkmeup.domain;

import java.util.ArrayList;

public class Employer {
    private String companyName;
    private String sector;
    private Email email;
    private Phone phone;
    private Password password;
    private TIN tin;
    private ArrayList<Job> jobs;


    public Employer(Email email, Phone phone, Password password, TIN tin){
        validateData(email,phone,password,tin);
        jobs = new ArrayList<>();
    }

    private void validateData(Email email, Phone phone, Password password, TIN tin){
        if(email == null){
            throw new NullPointerException("Email cannot be null.");
        }
        if(phone == null){
            throw new NullPointerException("Phone cannot be null.");
        }
        if(password == null){
            throw new NullPointerException("Password cannot be null.");
        }
        if(tin == null){
            throw new NullPointerException("TIN cannot be null");
        }
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.tin = tin;
    }

    private void validateObject(Object obj){
        if(obj == null){
            throw new NullPointerException("Object cannot be null");
        }
    }
    public void setEmail(Email email){
        validateData(email,this.phone, this.password, this.tin);
    }
    public void setPhone(Phone phone){
        validateData(this.email,phone, this.password, this.tin);
    }
    public void setPassword(Password password){
        validateData(this.email,this.phone, password, this.tin);
    }

    public void setTin(TIN tin){
        validateData(this.email,this.phone, this.password, tin);
    }

    public Email getEmail() {
        return email;
    }

    public Phone getPhone() {
        return phone;
    }

    public Password getPassword() {
        return password;
    }

    public TIN getTin() {
        return tin;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        validateObject(companyName);
        this.companyName = companyName;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        validateObject(sector);
        this.sector = sector;
    }

    public void addJob (Job job){
        validateObject(job);
        this.jobs.add(job);
    }

    public ArrayList<Job> getJobs(){
        return jobs;
    }
}
