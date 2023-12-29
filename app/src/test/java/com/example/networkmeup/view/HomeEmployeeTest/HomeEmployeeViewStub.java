package com.example.networkmeup.view.HomeEmployeeTest;

import com.example.networkmeup.view.HomeEmployee.HomeEmployeeView;

/**
 * This class is a stub implementing the HomeEmployeeView interface for testing purposes.
 * It simulates the behavior of a HomeEmployeeView by storing and tracking actions taken by the presenter.
 */
public class HomeEmployeeViewStub implements HomeEmployeeView {
    private String tokenErrorMessage;
    private String lastTokenPassed;
    private int modifyCVCounter;
    private int searchJobsCounter;
    private int editAccountCounter;

    /**
     * Shows a token error message.
     *
     * @param message The error message to display.
     */
    @Override
    public void showTokenErrorMessage(String message) {
        this.tokenErrorMessage = message;
    }

    /**
     * Simulates modifying CV by updating the last token passed and incrementing the modify CV counter.
     *
     * @param token The token used for modifying the CV.
     */
    @Override
    public void modifyCV(String token) {
        lastTokenPassed = token;
        modifyCVCounter++;
    }

    /**
     * Simulates searching for jobs by updating the last token passed and incrementing the search jobs counter.
     *
     * @param token The token used for searching jobs.
     */
    @Override
    public void searchJobs(String token) {
        lastTokenPassed = token;
        searchJobsCounter++;
    }

    /**
     * Simulates editing the account by updating the last token passed and incrementing the edit account counter.
     *
     * @param token The token used for editing the account.
     */
    @Override
    public void editAccount(String token) {
        lastTokenPassed = token;
        editAccountCounter++;
    }

    /**
     * Retrieves the token error message.
     *
     * @return The token error message.
     */
    public String getTokenErrorMessage() {
        return tokenErrorMessage;
    }

    /**
     * Retrieves the last token passed.
     *
     * @return The last token passed.
     */
    public String getLastTokenPassed() {
        return lastTokenPassed;
    }

    /**
     * Retrieves the counter for modify CV actions.
     *
     * @return The number of times modify CV was invoked.
     */
    public int getModifyCVCounter() {
        return modifyCVCounter;
    }

    /**
     * Retrieves the counter for search jobs actions.
     *
     * @return The number of times search jobs was invoked.
     */
    public int getSearchJobsCounter() {
        return searchJobsCounter;
    }

    /**
     * Retrieves the counter for edit account actions.
     *
     * @return The number of times edit account was invoked.
     */
    public int getEditAccountCounter() {
        return editAccountCounter;
    }
}
