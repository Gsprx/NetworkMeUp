package com.example.networkmeup.view.HomeEmployeeTest;

import com.example.networkmeup.view.HomeEmployee.HomeEmployeeView;

public class HomeEmployeeViewStub implements HomeEmployeeView {
    private String tokenErrorMessage;
    private String lastTokenPassed;
    private int modifyCVCounter;
    private int searchJobsCounter;
    private int editAccountCounter;
    @Override
    public void showTokenErrorMessage(String message) {
        this.tokenErrorMessage = message;
    }

    @Override
    public void modifyCV(String token) {
        lastTokenPassed = token;
        modifyCVCounter++;
    }

    @Override
    public void searchJobs(String token) {
        lastTokenPassed = token;
        searchJobsCounter++;
    }

    @Override
    public void editAccount(String token) {
        lastTokenPassed = token;
        editAccountCounter++;
    }

    public String getTokenErrorMessage() {
        return tokenErrorMessage;
    }

    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    public void setLastTokenPassed(String token) {
        lastTokenPassed = token;
    }

    public int getModifyCVCounter() {
        return modifyCVCounter;
    }

    public int getSearchJobsCounter() {
        return searchJobsCounter;
    }

    public int getEditAccountCounter() {
        return editAccountCounter;
    }
}
