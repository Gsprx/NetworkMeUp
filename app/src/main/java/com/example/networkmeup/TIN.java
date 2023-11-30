package com.example.networkmeup;

public class TIN {
    private String tin;


    public TIN (String tin){
        validateTIN(tin);
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        validateTIN(tin);
    }


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
}
