package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails;

import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Availability;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;

public class ChangeJobDetailsPresenter {
    private ChangeJobDetailsView view;
    private String userToken;
    private Job currJob;

    public ChangeJobDetailsPresenter(ChangeJobDetailsView view, String userToken, Job currJob) {
        this.view = view;
        this.userToken = userToken;
        this.currJob = currJob;
    }

    public void onEditEducation() {
        saveChanges();
        view.editEducation(currJob,userToken);
    }

    public void onEditWorkExperience() {
        saveChanges();
        view.editWorkExperience(currJob, userToken);
    }

    public void onEditLanguageKnowledge() {
        saveChanges();
        view.editLangKnowledge(currJob, userToken);
    }

    //use this method to keep the changes in the text fields made by the user
    //after pressing an edit list button
    private void saveChanges(){
        currJob.setDescription(view.getJobDescription());
        currJob.setTitle(view.getJobTitle());
        currJob.setAvailability(Availability.values()[view.getAvailability()]);
    }

    public void onSave() {
        EmployerDAO employerDAO = new EmployerDAOMemory();
        Employer employer = employerDAO.getByEmail(new Email(userToken));

        saveChanges();

        employer.getJobs().add(currJob);
        view.successfulSave(userToken);
    }

    public void onDelete() {
        EmployerDAO employerDAO = new EmployerDAOMemory();
        Employer employer = employerDAO.getByEmail(new Email(userToken));
        employer.getJobs().remove(currJob);
        view.successfulDelete(userToken);
    }
}
