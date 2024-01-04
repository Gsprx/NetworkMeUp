package com.example.networkmeup.view.ManageJobPositions;

import com.example.networkmeup.domain.Job;

public class ManageJobPositionsPresenter {
    private ManageJobPositionsView view;
    private String userToken;

    public ManageJobPositionsPresenter(ManageJobPositionsView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }
    public void onAddNew(){
        view.addNewJobPosition(userToken);
    }

    public void onItemClick(Job job){
        view.changeJobDetails(userToken, job);
    }
}
