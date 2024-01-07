package com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowApplicationDetails;

import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowJobApplicationsView;

public class ShowApplicationDetailsPresenter {
    private ShowApplicationDetailsView view;
    private String userToken;
    private Job job;
    private int position;

    public ShowApplicationDetailsPresenter(ShowApplicationDetailsView view, String userToken, Job job, int position) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
        this.position = position;
    }

    public void onAccept() {
        //update the application status
        Application application = job.getApplications().get(position);
        application.setStatus(true);
        job.getApplications().remove(position);

        //update employers static list's original reference
        Employer currEmployer = new EmployerDAOMemory().getByJob(job);
        currEmployer.getJobs().remove(job);
        currEmployer.addJob(job);

        //update employee

        view.acceptedApplicant(userToken,job);
    }

    public void onReject() {
        //update the application status
        Application application = job.getApplications().get(position);
        application.setStatus(false);
        job.getApplications().remove(position);

        //update employers static list's original reference
        Employer currEmployer = new EmployerDAOMemory().getByJob(job);
        currEmployer.getJobs().remove(job);
        currEmployer.addJob(job);

        //update employee
        view.rejectedApplicant(userToken,job);
    }
}
