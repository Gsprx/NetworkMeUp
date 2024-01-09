package com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowApplicationDetails;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowJobApplicationsView;

public class ShowApplicationDetailsPresenter {
    private ShowApplicationDetailsView view;
    private String userToken;
    private Job job;
    private Application application;

    public ShowApplicationDetailsPresenter(ShowApplicationDetailsView view, String userToken, Job job, Application application) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
        this.application = application;
    }

    private void updateEmployer(){
        //update employers static list's original reference
        Employer currEmployer = new EmployerDAOMemory().getByEmail(new Email(userToken));
        job.addApplication(application);
        currEmployer.getJobs().remove(job);
        currEmployer.addJob(job);
    }
    public void onAccept() {
        //change the application status
        application.setStatus(true);

        updateEmployer();

        view.acceptedApplicant(userToken,job);
    }

    public void onReject() {
        //change the application status
        application.setStatus(false);

        updateEmployer();

        view.rejectedApplicant(userToken,job);
    }
}
