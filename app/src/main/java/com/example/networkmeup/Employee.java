package com.example.networkmeup;

import java.util.Date;
public class Employee {
    private String name;
    private Date dateOfBirth;
    private String address;
    //private BufferedImage profileImage;
    private Email email;
    private Phone phone;
    private Password password;

    public Employee(Email email, Phone phone, Password password) {
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

   /* public void setProfileImage( ... ){
        return;
    }

    public ... getProfileImage(){
        return;
    }
    */

}
