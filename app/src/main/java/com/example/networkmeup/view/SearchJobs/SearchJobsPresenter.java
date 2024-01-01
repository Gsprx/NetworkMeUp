package com.example.networkmeup.view.SearchJobs;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;

import java.util.ArrayList;

public class SearchJobsPresenter {
    private SearchJobsView view;
    private String userToken;

    public SearchJobsPresenter(SearchJobsView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    public ArrayList<Job> onCreate(){
        //create arraylist to return
        ArrayList<Job> result = new ArrayList<>();

        //obtain current employee's data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userToken));

        //obtain all employers to access all available and temporarily not available jobs
        EmployerDAO employerDAO = new EmployerDAOMemory();

        //check through all available jobs and find matches
        for(Employer employer : employerDAO.getAll()){
            for(Job job : employer.getJobs()){
                if(job.acceptCV(currEmployee.getCV())){
                    result.add(job);
                }
            }
        }
        //no matching jobs found, send message to view
        if(result.size() == 0){
            view.noJobsFound("Unfortunately there are no jobs that match with your CV. Please try again later.", userToken);
        }
        return result;
    }

    public void onItemClick(Job selectedJob) {
        view.showJobDetails(userToken, selectedJob);
    }
}
