package com.example.networkmeup.view.SearchJobs;

import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Availability;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Presenter class for the Search Jobs functionality, responsible for handling the interaction
 * between the Search Jobs View and the data models.
 */
public class SearchJobsPresenter {
    private SearchJobsView view;
    private String userToken;

    /**
     * Constructor for the SearchJobsPresenter class.
     *
     * @param view      The associated SearchJobsView interface implementation.
     * @param userToken The authentication token of the user interacting with the search functionality.
     */
    public SearchJobsPresenter(SearchJobsView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }

    /**
     * Method called when the Search Jobs screen is created, responsible for finding matching jobs
     * based on the current employee's CV and job availability.
     *
     * @return An ArrayList of Job objects representing the matching jobs found.
     */
    public ArrayList<Job> onCreate(){
        //create arraylist to return
        ArrayList<Job> matchingJobs = new ArrayList<>();

        //obtain current employee's data
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userToken));

        //obtain all employers to access all available and temporarily not available jobs
        EmployerDAO employerDAO = new EmployerDAOMemory();

        //check through all available and temporarily unavailable jobs and find matches
        for(Employer employer : employerDAO.getAll()){
            for(Job job : employer.getJobs()){
                if(job.acceptCV(currEmployee.getCV()) && (job.getAvailability().equals(Availability.Available) || job.getAvailability().equals(Availability.Temporarily_Unavailable))){
                    //ignore jobs that the user has already applied to
                    boolean applied = false;
                    for (Application application : job.getApplications()) {
                        if (application.getEmployee().equals(currEmployee) == true){
                            applied = true;
                        }
                    }
                    //if we found an application with the employee in it, we ignore the job, else add it
                    if(applied == false){
                        matchingJobs.add(job);
                    }
                }
            }
        }


        //no matching jobs found, send message to view
        if(matchingJobs.size() == 0){
            view.noJobsFound("Unfortunately there are no jobs that match with your CV. Please try again later.", userToken);
        }

        return matchingJobs;
    }

    /**
     * Method called when a specific job is selected, responsible for notifying the view to display
     * the details of the selected job.
     *
     * @param selectedJob The Job object representing the selected job.
     */
    public void onItemClick(Job selectedJob) {
        view.showJobDetails(userToken, selectedJob);
    }
}
