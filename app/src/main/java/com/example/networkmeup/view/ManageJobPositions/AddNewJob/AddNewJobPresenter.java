package com.example.networkmeup.view.ManageJobPositions.AddNewJob;

public class AddNewJobPresenter {
    private AddNewJobView view;
    private String userToken;

    public AddNewJobPresenter(AddNewJobView view, String userToken) {
        this.view = view;
        this.userToken = userToken;
    }
}
