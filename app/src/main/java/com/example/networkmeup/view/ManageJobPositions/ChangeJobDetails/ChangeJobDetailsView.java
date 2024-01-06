package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails;

import com.example.networkmeup.domain.Job;

public interface ChangeJobDetailsView {
    public String getJobDescription();
    public String getJobTitle();
    public int getAvailability();
    public void editEducation(Job job, String userToken);
    public void editWorkExperience(Job job, String userToken);
    public void editLangKnowledge(Job job, String userToken);
}
