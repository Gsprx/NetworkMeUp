package com.example.networkmeup;
enum LevelOfStudies{
    Amateur,
    Junior_High_School,
    High_School,
    Bachelor,
    Master,
    PhD
}

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
}
