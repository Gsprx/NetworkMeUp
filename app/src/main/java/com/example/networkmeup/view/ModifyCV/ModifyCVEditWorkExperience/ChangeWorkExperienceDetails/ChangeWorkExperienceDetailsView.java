package com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.ChangeWorkExperienceDetails;

public interface ChangeWorkExperienceDetailsView {
    public String getDescription();

    /*
     * Integers for the positions in the list/enum
     */
    public int getExpertiseArea();
    public int getYearsAtWork();
    public void successfulDelete(String message, String userToken);
    public void successfulSave(String message, String userToken);
}
