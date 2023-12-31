package com.example.networkmeup.view.ModifyCVEditEducation.AddNewEducation;

public interface AddNewEducationView {
    public void successfulAdd(String message, String userToken);
    public String getDescription();

    /*
     * Integers for the positions in the list/enum
     */
    public int getExpertiseArea();
    public int getLevelOfStudies();
}
