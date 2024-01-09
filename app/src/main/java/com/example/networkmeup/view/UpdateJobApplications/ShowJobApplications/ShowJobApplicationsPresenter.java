package com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications;

import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Job;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShowJobApplicationsPresenter {
    private ShowJobApplicationsView view;
    private String userToken;
    private Job job;

    public ShowJobApplicationsPresenter(ShowJobApplicationsView view, String userToken, Job job) {
        this.view = view;
        this.userToken = userToken;
        this.job = job;
    }

    public void onItemClick(Application application){
        view.showApplicationDetails(userToken,job,application);
    }

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
