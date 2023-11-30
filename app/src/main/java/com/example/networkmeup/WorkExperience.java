package com.example.networkmeup;

public class WorkExperience {
    private int years;
    private String description;

    public WorkExperience(int years, String desc){
        validateData(years, desc);
    }

    private void validateData(int years, String desc){
        if (years < 0){
            throw new IllegalArgumentException("Invalid number of years.");
        }
        if (desc == null){
            throw new NullPointerException("Description cannot be empty");
        }
    }

    public int getYears() {
        return years;
    }

    public String getDescription() {
        return description;
    }
}
