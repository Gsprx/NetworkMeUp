package com.example.networkmeup.domain;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * The Phone class represents a phone number and ensures its validity based on defined criteria.
 * It validates phone numbers to meet specific formatting requirements.
 */
public class Phone {
    private String number;

    /**
     * Constructs a Phone object with the provided phone number string and validates it.
     * @param number The phone number string to be set and validated.
     * @throws NullPointerException If the provided phone number is null.
     * @throws IllegalArgumentException If the phone number does not meet the required format.
     */
    public Phone(String number){
        validatePhone(number);
    }

    /**
     * Sets a new phone number and validates it.
     * @param number The new phone number to be set and validated.
     * @throws NullPointerException If the provided phone number is null.
     * @throws IllegalArgumentException If the phone number does not meet the required format.
     */
    public void setNumber(String number) {
        validatePhone(number);
    }

    /**
     * Validates the provided phone number based on defined criteria.
     * @param number The phone number string to be validated.
     * @throws NullPointerException If the provided phone number is null.
     * @throws IllegalArgumentException If the phone number does not meet the required format.
     */
    private void validatePhone(String number){
        if(number == null){
            throw new NullPointerException("Phone number cannot be empty.");
        }

        // Phone number criteria: Exactly 10 digits, cannot start with 1 or 0
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

    /**
     * Retrieves the phone number.
     * @return The stored phone number string.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Compares this Phone object with another Phone object based on their phone numbers.
     * @param phone The Phone object to be compared.
     * @return true if both Phone objects have the same phone number, false otherwise.
     */
    public boolean equals(Phone phone){
        return this.number.equals(phone.getNumber());
    }
}
