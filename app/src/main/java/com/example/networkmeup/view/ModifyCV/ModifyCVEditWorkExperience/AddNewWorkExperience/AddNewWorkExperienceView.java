package com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.AddNewWorkExperience;

public interface AddNewWorkExperienceView {
    public void successfulAdd(String message, String userToken);
    public String getDescription();

    /*
     * Integers for the positions in the list/enum
     */
    public int getExpertiseArea();
    public int getYearsAtWork();
}
