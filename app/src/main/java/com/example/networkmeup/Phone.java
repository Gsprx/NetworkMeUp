package com.example.networkmeup;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Phone {
    private String number;
    public Phone(String number){
        if(number == null){
            throw new NullPointerException("Phone number cannot be empty.");
        }

        //Phone number must have exactly 10 digits, cannot begin with the number 1 or 0
        String regex = "^[2-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()){
            this.number = number;
        }
        else{
            throw new IllegalArgumentException("Invalid phone number.");
        }
    }
    public void setNumber(String number) {
        if(number == null){
            throw new NullPointerException("Phone number cannot be empty.");
        }

        //Phone number must have exactly 10 digits, cannot begin with the number 1 or 0
        String regex = "^[2-9]\\d{9}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(number);
        if (matcher.matches()){
            this.number = number;
        }
        else{
            throw new IllegalArgumentException("Invalid phone number.");
        }
    }
    public String getNumber() {
        return number;
    }
}
