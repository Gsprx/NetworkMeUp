package com.example.networkmeup.domain;
import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * The Email class represents an email address and provides methods for validation and comparison.
 */
public class Email implements Serializable {
    private String address; // The email address string

    /**
     * Constructor to create an Email object with a given address.
     * @param address The email address to be validated and set.
     * @throws NullPointerException if the address is null.
     * @throws IllegalArgumentException if the address is invalid.
     */
    public Email (String address){
            validateEmail(address);
    }

    /**
     * Retrieves the email address.
     * @return The email address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the email address after validating it.
     * @param address The email address to be validated and set.
     * @throws NullPointerException if the address is null.
     * @throws IllegalArgumentException if the address is invalid.
     */
    public void setAddress(String address) {
        validateEmail(address);
    }

    /**
     * Validates the email address using a regular expression pattern.
     * @param address The email address to be validated.
     * @throws NullPointerException if the address is null.
     * @throws IllegalArgumentException if the address is invalid.
     */
    private void validateEmail(String address){

        // Regular expression pattern to validate email format
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);

        if (address == null){
            throw new NullPointerException("Email address cannot be empty.");
        }
        if (pattern.matcher(address).matches()) {
            this.address = address;
            return;
        }
        else{
            throw new IllegalArgumentException("Invalid email address.");
        }
    }

    /**
     * Checks if two Email objects have the same address.
     * @param email Another Email object to compare.
     * @return true if the addresses are equal, false otherwise.
     */
    public boolean equals(Email email){
        return this.address.equals(email.getAddress());
    }

}
