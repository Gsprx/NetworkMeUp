package com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowApplicationDetails;

import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;

/**
 * Presenter class for handling interactions between the Show Application Details View and the data models.
 * This class manages the actions related to accepting or rejecting job applications.
 */
public class ShowApplicationDetailsPresenter {
    private ShowApplicationDetailsView view;
    private String userToken;
    private Job job;
    private Application application;

    /**
     * Constructor for the ShowApplicationDetailsPresenter class.
     *
     * @param view        The associated ShowApplicationDetailsView interface implementation.
     * @param userToken   The authentication token of the user viewing the application details.
     * @param job         The Job object representing the details of the job associated with the application.
     * @param application The Application object representing the details of the job application.
     */
    public ShowApplicationDetailsPresenter(ShowApplicationDetailsView view, String userToken, Job job, Application application) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
        this.application = application;
    }

    /**
     * Private method to update the employer's job list after accepting or rejecting an application.
     *
     * @return void
     */
    private void updateEmployerAndEmployee(){
        //update employers static list's original reference
        Employer currEmployer = new EmployerDAOMemory().getByEmail(new Email(userToken));
        job.addApplication(application);
        currEmployer.getJobs().remove(job);
        currEmployer.addJob(job);

        //update employees static list's original reference
        Employee applicant = new EmployeeDAOMemory().getByEmail(application.getEmployee().getEmail());


    }

    /**
     * Method called when the user accepts a job application.
     * Updates the application status and employer's job list.
     *
     * 
     */
    public void onAccept() {
        //change the application status
        application.setStatus(true);

        updateEmployerAndEmployee();

        view.acceptedApplicant(userToken,job);
    }

    /**
     * Method called when the user rejects a job application.
     * Updates the application status and employer's job list.
     *
     *
     */
    public void onReject() {
        //change the application status
        application.setStatus(false);

        updateEmployerAndEmployee();

        view.rejectedApplicant(userToken,job);
    }
}
