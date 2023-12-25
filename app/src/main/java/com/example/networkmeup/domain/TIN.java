package com.example.networkmeup.domain;

/**
 * The TIN class represents a Tax Identification Number (TIN) and validates its format and check digit.
 * It ensures the TIN meets specific criteria for a valid format and check digit validation.
 */
public class TIN {
    private String tin;

    /**
     * Constructs a TIN object with the provided TIN string and validates it.
     * @param tin The TIN string to be set and validated.
     * @throws NullPointerException If the provided TIN is null.
     * @throws IllegalArgumentException If the TIN does not meet the required format or has an invalid check digit.
     */
    public TIN (String tin){
        validateTIN(tin);
    }

    /**
     * Retrieves the TIN.
     * @return The stored TIN string.
     */
    public String getTin() {
        return tin;
    }

    /**
     * Sets a new TIN and validates it.
     * @param tin The new TIN to be set and validated.
     * @throws NullPointerException If the provided TIN is null.
     * @throws IllegalArgumentException If the TIN does not meet the required format or has an invalid check digit.
     */
    public void setTin(String tin) {
        validateTIN(tin);
    }

    /**
     * Validates the provided TIN based on specific criteria for format and check digit.
     * @param tin The TIN string to be validated.
     * @throws NullPointerException If the provided TIN is null.
     * @throws IllegalArgumentException If the TIN does not meet the required format or has an invalid check digit.
     */
    private void validateTIN (String tin){
        if (tin == null) {
            throw new NullPointerException("TIN cannot be empty.");
        }
        if(tin.length() != 9){
            throw new IllegalArgumentException("Invalid TIN.");
        }

        int sum = 0;
        for (int i = 0; i < 8; i++) {
            sum += Character.getNumericValue(tin.charAt(i)) * Math.pow(2, 8 - i);
        }
        int checkDigit = sum % 11 % 10;
        if(checkDigit == Character.getNumericValue(tin.charAt(8))){
            this.tin = tin;
        }
        else {
            throw new IllegalArgumentException("Invalid TIN.");
        }
    }

    /**
     * Compares this TIN object with another TIN object based on their TIN strings.
     * @param tin The TIN object to be compared.
     * @return true if both TIN objects have the same TIN string, false otherwise.
     */
    public boolean equals(TIN tin){
        return this.tin.equals(tin.getTin());
    }
}
