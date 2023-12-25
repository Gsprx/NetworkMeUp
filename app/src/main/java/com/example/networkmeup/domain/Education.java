package com.example.networkmeup.domain;

/**
 * The Education class represents an individual's educational background
 * including description, expertise area, and level of studies.
 */
public class Education {
    private String description; // Description of the education
    private ExpertiseArea expArea; // Expertise area of the education
    private LevelOfStudies lvlOfStudies; // Level of studies attained

    /**
     * Constructor to create an Education object with description, expertise area, and level of studies.
     * @param description Description of the education.
     * @param expArea Expertise area of the education.
     * @param lvlOfStudies Level of studies attained.
     * @throws NullPointerException if any of the parameters is null.
     */
    public Education (String description, ExpertiseArea expArea, LevelOfStudies lvlOfStudies){
        validateData(description, expArea, lvlOfStudies);
    }

    /**
     * Validates and sets the data for description, expertise area, and level of studies.
     * @param description Description of the education.
     * @param expArea Expertise area of the education.
     * @param lvlOfStudies Level of studies attained.
     * @throws NullPointerException if any of the parameters is null.
     */
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

    /**
     * Sets the description of the education.
     * @param description Description of the education.
     */
    public void setDescription(String description) {
        validateData(description, this.expArea, this.lvlOfStudies);
    }

    /**
     * Sets the expertise area of the education.
     * @param expArea Expertise area of the education.
     */
    public void setExpArea(ExpertiseArea expArea) {
        validateData(this.description, expArea, this.lvlOfStudies);
    }

    /**
     * Sets the level of studies attained.
     * @param lvlOfStudies Level of studies attained.
     */
    public void setLvlOfStudies(LevelOfStudies lvlOfStudies) {
        validateData(this.description, this.expArea, lvlOfStudies);
    }

    /**
     * Retrieves the description of the education.
     * @return Description of the education.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the expertise area of the education.
     * @return Expertise area of the education.
     */
    public ExpertiseArea getExpArea() {
        return expArea;
    }

    /**
     * Retrieves the level of studies attained.
     * @return Level of studies attained.
     */
    public LevelOfStudies getLvlOfStudies() {
        return lvlOfStudies;
    }

    /**
     * Compares two Education objects based on expertise area and level of studies.
     * @param edu Another Education object to compare.
     * @return 0 if equal, -1 if this is less than the argument, 1 if this is more than the argument.
     *         Returns -2 if expertise areas are incomparable.
     */
    public int compare(Education edu){
        if(this.expArea.equals(edu.expArea)){
            return Integer.compare(this.lvlOfStudies.ordinal(), edu.lvlOfStudies.ordinal());
        }
        // Return -2 if expertise areas are incomparable
        return -2;
    }

    /**
     * Checks if two Education objects are equal based on expertise area and level of studies.
     * @param edu Another Education object to compare.
     * @return true if equal, false otherwise.
     */
    public boolean equals(Education edu){
        return (this.compare(edu) == 0);
    }
}
