package com.example.networkmeup.view.ModifyCVEditEducation.ChangeEducationDetails;

public interface ChangeEducationDetailsView {

    public String getDescription();

    /*
     * Integers for the positions in the list/enum
     */
    public int getExpertiseArea();
    public int getLevelOfStudies();
    public void successfulDelete(String message, String userToken);
    public void successfulSave(String message, String userToken);
}
