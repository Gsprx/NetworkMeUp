package com.example.networkmeup;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class Password {
    private String password;

    public Password (String password){
        validatePassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        validatePassword(password);
    }

    private void validatePassword(String password){
        if (password == null){
            throw new NullPointerException("Password cannot be empty.");
        }

        //Password must have 1 capital, 1 lowercase, 1 number and 1 special character (any non digit or alphabetic), at least 8 characters total.
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9 ])(?=\\S+$).{8,}$";

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()){
            this.password = password;
        }
        else{
            throw new InsufficientPasswordException("Password is not strong enough.");
        }
    }
}