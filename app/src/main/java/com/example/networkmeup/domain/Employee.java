package com.example.networkmeup.domain;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
public class Employee {
    private String name;
    private Date dateOfBirth;
    private String address;
    private String profileImage; //path to image
    private Email email;
    private Phone phone;
    private Password password;
    private CV cv;
    private ArrayList<Application> applications;

    public Employee(Email email, Phone phone, Password password) {
        validateData(email,phone,password);
        applications = new ArrayList<>();
        cv = new CV();
    }

    private void validateData(Email email, Phone phone, Password password){
        if(email == null){
            throw new NullPointerException("Email cannot be null.");
        }
        if(phone == null){
            throw new NullPointerException("Phone cannot be null.");
        }
        if(password == null){
            throw new NullPointerException("Password cannot be null.");
        }
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    private void validateObject(Object obj){
        if(obj == null){
            throw new NullPointerException("Object cannot be null");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateObject(name);
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        validateObject(dateOfBirth);
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        validateObject(address);
        this.address = address;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        validateData(email,this.phone, this.password);
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        validateData(this.email,phone, this.password);
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        validateData(this.email,this.phone, password);
    }

    public void setProfileImage(String imagepath){
        validateObject(imagepath);
        this.profileImage = imagepath;
    }

    public String getProfileImage(){
        return profileImage;
    }

    public ArrayList<Application> getApplications(){
        return applications;
    }

    public void addApplication(Application appl){
        validateObject(appl);
        applications.add(appl);
    }

    public void setCV(CV cv){
        validateObject(cv);
        this.cv = cv;
    }

    public CV getCV(){
        return cv;
    }


    public boolean equals(Employee e) {
        validateObject(e);
        //we consider two employees equal if they have the same phone and or email
        return (this.email.equals(e.getEmail()) || this.phone.equals(e.getPhone()));
    }
}


