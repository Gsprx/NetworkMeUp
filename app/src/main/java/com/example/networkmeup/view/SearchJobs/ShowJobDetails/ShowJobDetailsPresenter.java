package com.example.networkmeup.view.SearchJobs.ShowJobDetails;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;

/**
 * Presenter class for the Show Job Details functionality, responsible for handling interactions
 * between the Show Job Details View and the data models, especially related to job applications.
 */
public class ShowJobDetailsPresenter {
    private ShowJobsDetailsView view;
    private String userToken;
    private Job job;

    /**
     * Constructor for the ShowJobDetailsPresenter class.
     *
     * @param view      The associated ShowJobsDetailsView interface implementation.
     * @param userToken The authentication token of the user viewing the job details.
     * @param job       The Job object representing the details of the job being viewed.
     */
    public ShowJobDetailsPresenter(ShowJobsDetailsView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job =  job;
    }

    /**
     * Method called when the user attempts to send a job application.
     * Handles the application submission process, including cover letter validation and updates to data models.
     */
    public void onSendApplication() {
        String coverLetter = view.getCoverLetter();
        //reject empty cover letters
        if (coverLetter == null || coverLetter.equals("")){
            view.emptyCoverLetter("Cover Letter must not be empty!");
            return;
        }

        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userToken));

        Employer jobsEmployer = new EmployerDAOMemory().getByJob(job);

        Application application = new Application(currEmployee,coverLetter);

        job.addApplication(application);

        jobsEmployer.getJobs().remove(job);
        jobsEmployer.addJob(job);

        currEmployee.getApplications().add(application);

        view.sendApplicationSuccess(userToken);
    }
}
