package com.example.networkmeup.domain;

public class Education {
    private String description;
    private ExpertiseArea expArea;
    private LevelOfStudies lvlOfStudies;


    public Education (String description, ExpertiseArea expArea, LevelOfStudies lvlOfStudies){
        validateData(description, expArea, lvlOfStudies);
    }

    public void validateData (String description, ExpertiseArea expArea, LevelOfStudies lvlOfStudies){
        if(description == null){
            throw new NullPointerException("Description cannot be empty.");
        }
        if(expArea == null){
            throw new NullPointerException("Expertise Area cannot be empty.");
        }
        if(lvlOfStudies == null){
            throw new NullPointerException("Level of studies cannot be empty.");
        }
        this.description = description;
        this.expArea = expArea;
        this.lvlOfStudies = lvlOfStudies;
    }

    public void setDescription(String description) {
        validateData(description, this.expArea, this.lvlOfStudies);
    }

    public void setExpArea(ExpertiseArea expArea) {
        validateData(this.description, expArea, this.lvlOfStudies);
    }

    public void setLvlOfStudies(LevelOfStudies lvlOfStudies) {
        validateData(this.description, this.expArea, lvlOfStudies);
    }

    public String getDescription() {
        return description;
    }

    public ExpertiseArea getExpArea() {
        return expArea;
    }

    public LevelOfStudies getLvlOfStudies() {
        return lvlOfStudies;
    }

    //compares two education objects, return 0 if equal, -1 if this is less than the arguement, 1 if this is more than the arguement
    public int compare(Education edu){
        if(this.expArea.equals(edu.expArea)){
            return Integer.compare(this.lvlOfStudies.ordinal(), edu.lvlOfStudies.ordinal());
        }
        //return -2 if incomperable expertise areas.
        return -2;
    }
    public boolean equals(Education edu){
        return (this.compare(edu) == 0);
    }
}
