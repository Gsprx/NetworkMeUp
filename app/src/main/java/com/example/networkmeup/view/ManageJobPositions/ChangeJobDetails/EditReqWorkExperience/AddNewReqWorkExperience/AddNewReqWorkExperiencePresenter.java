package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.AddNewReqWorkExperience;

import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfStudies;
import com.example.networkmeup.domain.WorkExperience;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation.AddNewReqEducationView;

public class AddNewReqWorkExperiencePresenter {
    private AddNewReqWorkExperienceView view;
    private String userToken;
    private Job job;

    public AddNewReqWorkExperiencePresenter(AddNewReqWorkExperienceView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    public void onAdd() {
        ExpertiseArea newExpArea = new ExpertiseAreaDAOMemory().getAll().get(view.getExpertiseArea());
        job.addReqWorkExperience(new WorkExperience(view.getYears()+1,view.getDescription(), newExpArea));

        view.successfulAdd("Required Work Experience was successfully created!", userToken, job);
    }
}
