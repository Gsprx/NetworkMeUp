package com.example.networkmeup.domain;

/**
 * The WorkExperience class represents an individual's work experience.
 * It includes details such as the number of years, description, and expertise area.
 */
public class WorkExperience {
    private int years;
    private String description;
    private ExpertiseArea expArea;

    /**
     * Constructs a WorkExperience object with the provided details and validates them.
     * @param years The number of years of work experience.
     * @param desc The description of the work experience.
     * @param expArea The expertise area associated with the work experience.
     * @throws IllegalArgumentException If the number of years is negative.
     * @throws NullPointerException If the description or expertise area is null.
     */
    public WorkExperience(int years, String desc, ExpertiseArea expArea){
        validateData(years, desc, expArea);
    }

    /**
     * Validates the provided data for work experience: years, description, and expertise area.
     * @param years The number of years of work experience.
     * @param desc The description of the work experience.
     * @param expArea The expertise area associated with the work experience.
     * @throws IllegalArgumentException If the number of years is negative.
     * @throws NullPointerException If the description or expertise area is null.
     */
    private void validateData(int years, String desc, ExpertiseArea expArea){
        if (years < 0){
            throw new IllegalArgumentException("Invalid number of years.");
        }
        if (desc == null){
            throw new NullPointerException("Description cannot be empty");
        }
        if(expArea == null){
            throw new NullPointerException("Expertise area cannot be empty");
        }
        this.years = years;
        this.description = desc;
        this.expArea = expArea;
    }

    /**
     * Validates and sets the number of years of work experience.
     * @param years The number of years to be set and validated.
     * @throws IllegalArgumentException If the number of years is negative.
     */
    public void setYears(int years) {
        validateData(years, this.description, this.expArea);
    }

    /**
     * Validates and sets the description of the work experience.
     * @param description The description to be set and validated.
     * @throws NullPointerException If the description is null.
     */
    public void setDescription(String description) {
        validateData(this.years, description, this.expArea);
    }

    /**
     * Validates and sets the expertise area associated with the work experience.
     * @param expArea The expertise area to be set and validated.
     * @throws NullPointerException If the expertise area is null.
     */
    public void setExpArea(ExpertiseArea expArea) {
        validateData(this.years, this.description, expArea);
    }

    /**
     * Retrieves the number of years of work experience.
     * @return The number of years.
     */
    public int getYears() {
        return years;
    }

    /**
     * Retrieves the description of the work experience.
     * @return The description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the expertise area associated with the work experience.
     * @return The expertise area.
     */
    public ExpertiseArea getExpArea (){
        return expArea;
    }

    /**
     * Compares this work experience with another based on the expertise area and years of experience.
     * @param workExperience The WorkExperience object to be compared.
     * @return 0 if both have the same expertise area and years, -1 if this object has less experience, 1 if more, -2 if expertise areas are incomparable.
     */
    public int compare(WorkExperience workExperience){
        if(this.expArea.equals(workExperience.expArea)){
            return Integer.compare(this.years, workExperience.years);
        }
        return -2; // -2 for incomparable expertise areas
    }

    /**
     * Checks if this work experience is equal to another based on the expertise area and years of experience.
     * @param workExperience The WorkExperience object to be compared.
     * @return true if both have the same expertise area and years, false otherwise.
     */
    public boolean equals(WorkExperience workExperience){
        return (this.compare(workExperience) == 0);
    }
}
