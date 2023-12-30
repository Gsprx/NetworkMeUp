package com.example.networkmeup.domain;

/**
 * The ExpertiseArea class represents an area of expertise.
 */
public class ExpertiseArea implements Comparable<ExpertiseArea>{
    private String area; // String representing the expertise area

    /**
     * Constructor to create an ExpertiseArea object with a specified area.
     * @param area The area of expertise.
     * @throws NullPointerException if the area is null.
     */
    public ExpertiseArea(String area){
        validateArea(area);
    }

    /**
     * Retrieves the area of expertise.
     * @return The area of expertise.
     */
    public String getArea(){
        return this.area;
    }

    /**
     * Sets the area of expertise.
     * @param area The area of expertise to set.
     * @throws NullPointerException if the area is null.
     */
    public void setArea(String area){
        validateArea(area);
    }

    /**
     * Validates and sets the area of expertise.
     * @param area The area of expertise to validate and set.
     * @throws NullPointerException if the area is null.
     */
    private void validateArea(String area){
        if (area != null){
            this.area = area;
        }
        else{
            throw new NullPointerException("Area cannot be empty.");
        }
    }
    /**
     * Checks equality between two ExpertiseArea objects based on their area of expertise.
     * @param expertiseArea Another ExpertiseArea object to compare.
     * @return true if the areas of expertise are equal, false otherwise.
     */
    public boolean equals (ExpertiseArea expertiseArea){
        return (this.area.equals(expertiseArea.area));
    }

    @Override
    public int compareTo(ExpertiseArea o) {
        return this.area.compareTo(o.getArea());
    }

}
