package com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications;

import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Job;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Presenter class for handling interactions between the Show Job Applications View and the data models.
 * This class manages the actions related to displaying job applications.
 */
public class ShowJobApplicationsPresenter {
    private ShowJobApplicationsView view;
    private String userToken;
    private Job job;

    /**
     * Constructor for the ShowJobApplicationsPresenter class.
     *
     * @param view      The associated ShowJobApplicationsView interface implementation.
     * @param userToken The authentication token of the user viewing the job applications.
     * @param job       The Job object representing the details of the job associated with the applications.
     */
    public ShowJobApplicationsPresenter(ShowJobApplicationsView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    /**
     * Method called when an individual job application is clicked.
     * Opens the details of the selected job application.
     *
     * @param application The Application object representing the details of the selected job application.
     * @return void
     */
    public void onItemClick(Application application){
        view.showApplicationDetails(userToken,job,application);
    }

    /**
     * Method to retrieve all pending (not answered) job applications for the current job.
     *
     * @return ArrayList of Application objects representing pending job applications.
     */
    public ArrayList<Application> getPendingApplications(){
        ArrayList<Application> allApplications = job.getApplications();
        ArrayList<Application> pendingApplications = new ArrayList<>();
        for(Application application : allApplications){
            if(application.getAnswered() == false){
                pendingApplications.add(application);
            }
        }
        //return all pending - not answered applications to the employer
        return pendingApplications;
    }
}
