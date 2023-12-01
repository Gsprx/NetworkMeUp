package com.example.networkmeup;

public class WorkExperience {
    private int years;
    private String description;
    private ExpertiseArea expArea;

    public WorkExperience(int years, String desc, ExpertiseArea expArea){
        validateData(years, desc, expArea);
    }

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

    public void setYears(int years) {
        validateData(years, this.description, this.expArea);
    }

    public void setDescription(String description) {
        validateData(this.years, description, this.expArea);
    }

    public void setExpArea(ExpertiseArea expArea) {
        validateData(this.years, this.description, expArea);
    }

    public int getYears() {
        return years;
    }

    public String getDescription() {
        return description;
    }

    public ExpertiseArea getExpArea (){
        return expArea;
    }

    public int compare(WorkExperience workExperience){
        if(this.expArea.equals(workExperience.expArea)){
            return Integer.compare(this.years, workExperience.years);
        }
        //return -2 if incomperable expertise areas.
        return -2;
    }
    public boolean equals(WorkExperience workExperience){
        return (this.compare(workExperience) == 0);
    }
}
