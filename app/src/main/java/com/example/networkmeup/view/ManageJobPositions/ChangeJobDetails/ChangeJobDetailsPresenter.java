package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails;

import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Availability;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;

/**
 * The ChangeJobDetailsPresenter class is responsible for handling actions from the ChangeJobDetailsActivity view.
 */
public class ChangeJobDetailsPresenter {
    private ChangeJobDetailsView view;
    private String userToken;
    private Job currJob;

    /**
     * Constructor for the ChangeJobDetailsPresenter class.
     * @param view The view that this presenter is attached to.
     * @param userToken The token of the user.
     * @param currJob The job that is being updated.
     */
    public ChangeJobDetailsPresenter(ChangeJobDetailsView view, String userToken, Job currJob) {
        this.view = view;
        this.userToken = userToken;
        this.currJob = currJob;
    }

    /**
     * This method is called when the Edit button in the education section is pressed.
     * It saves the changes and edits the education details.
     */
    public void onEditEducation() {
        saveChanges();
        view.editEducation(currJob,userToken);
    }

    /**
     * This method is called when the Edit button in the work experience section is pressed.
     * It saves the changes and edits the work experience details.
     */
    public void onEditWorkExperience() {
        saveChanges();
        view.editWorkExperience(currJob, userToken);
    }

    /**
     * This method is called when the Edit button in the language knowledge section is pressed.
     * It saves the changes and edits the language knowledge details.
     */
    public void onEditLanguageKnowledge() {
        saveChanges();
        view.editLangKnowledge(currJob, userToken);
    }

    /**
     * This method is used to keep the changes in the text fields made by the user
     * after pressing an edit list button or the save button.
     */
    private void saveChanges(){
        Employer currEmployer = new EmployerDAOMemory().getByEmail(new Email(userToken));
        currEmployer.getJobs().remove(currJob);

        currJob.setDescription(view.getJobDescription());
        currJob.setTitle(view.getJobTitle());
        currJob.setAvailability(Availability.values()[view.getAvailability()]);

        currEmployer.addJob(currJob);
    }

    /**
     * This method is called when the Save button is pressed.
     * It saves the changes and notifies the view of a successful save.
     */
    public void onSave() {
        saveChanges();
        view.successfulSave(userToken);
    }

    /**
     * This method is called when the Delete button is pressed.
     * It deletes the job and notifies the view of a successful delete.
     */
    public void onDelete() {
        EmployerDAO employerDAO = new EmployerDAOMemory();
        Employer employer = employerDAO.getByEmail(new Email(userToken));
        employer.getJobs().remove(currJob);
        view.successfulDelete(userToken);
    }
}
