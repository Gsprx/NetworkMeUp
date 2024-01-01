package com.example.networkmeup.view.SearchJobs.ShowJobDetails;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Job;

public class ShowJobDetailsPresenter {
    private ShowJobsDetailsView view;
    private String userToken;
    private Job job;

    public ShowJobDetailsPresenter(ShowJobsDetailsView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job =  job;
    }

    public void onSendApplication() {
        String coverLetter = view.getCoverLetter();
        //reject empty cover letters
        if (coverLetter == null || !coverLetter.equals("")){
            view.emptyCoverLetter("Cover Letter must not be empty!");
            return;
        }

        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userToken));

        Application application = new Application(currEmployee,coverLetter);

        job.addApplication(application);
        currEmployee.addApplication(application);

        view.sendApplicationSuccess(userToken);
    }
}
