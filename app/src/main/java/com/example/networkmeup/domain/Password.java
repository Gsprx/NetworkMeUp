package com.example.networkmeup.domain;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * The Password class represents a user password with defined validation criteria.
 * It ensures that passwords meet certain requirements regarding length and complexity.
 */
public class Password {
    private String password;

    /**
     * Constructs a Password object with the provided password string and validates it.
     * @param password The password string to be set and validated.
     * @throws InsufficientPasswordException If the password does not meet the required criteria.
     * @throws NullPointerException If the provided password is null.
     */
    public Password (String password){
        validatePassword(password);
    }

    /**
     * Retrieves the password.
     * @return The stored password string.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets a new password and validates it.
     * @param password The new password to be set and validated.
     * @throws InsufficientPasswordException If the password does not meet the required criteria.
     * @throws NullPointerException If the provided password is null.
     */
    public void setPassword(String password) {
        validatePassword(password);
    }

    /**
     * Validates the provided password based on defined criteria.
     * @param password The password string to be validated.
     * @throws InsufficientPasswordException If the password does not meet the required complexity.
     * @throws IllegalArgumentException If the password length exceeds the maximum allowed limit.
     * @throws NullPointerException If the provided password is null.
     */
    private void validatePassword(String password){
        if (password == null){
            throw new NullPointerException("Password cannot be empty.");
        }

        // Password criteria: 1 capital, 1 lowercase, 1 number, 1 special character,
        // at least 8 characters total, up to 24 characters
        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9 ])(?=\\S+$).{8,24}$";

        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        if(matcher.matches()){
            this.password = password;
        }
        else if(password.length()>24){
            throw new IllegalArgumentException("Password cannot be more than 24 characters long.");
        }
        else{
            throw new InsufficientPasswordException("Password is not strong enough.");
        }
    }
}
