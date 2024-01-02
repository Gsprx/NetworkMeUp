package com.example.networkmeup.view.HomeEmployerTest;

import com.example.networkmeup.view.HomeEmployer.HomeEmployerView;

/**
 * Stub class implementing the HomeEmployerView interface for testing purposes.
 * It stores data passed to its methods, facilitating verification of method calls.
 */
public class HomeEmployerViewStub implements HomeEmployerView {

    private String tokenErrorMessage; // Stores the error message related to the user token
    private String lastTokenPassed; // Stores the last token passed
    private int manageJobPositionsCounter; // Counts the number of times manageJobPositions method is called
    private int updatedJobApplicationsCounter; // Counts the number of times updateJobApplications method is called
    private int editedAccountCounter; // Counts the number of times editAccount method is called

    /**
     * Records the error message related to the user token.
     *
     * @param errorMessage The error message to be stored.
     */
    @Override
    public void showTokenErrorMessage(String errorMessage) {
        this.tokenErrorMessage = errorMessage;
    }

    /**
     * Records the user token passed to manage job positions method and increments the method call counter.
     *
     * @param Token The token (email) of the employer navigating to manage job positions.
     */
    @Override
    public void manageJobPositions(String Token) {
        lastTokenPassed = Token;
        manageJobPositionsCounter++;
    }

    /**
     * Records the user token passed to update job applications method and increments the method call counter.
     *
     * @param Token The token (email) of the employer navigating to update job applications.
     */
    @Override
    public void updateJobApplications(String Token) {
        lastTokenPassed = Token;
        updatedJobApplicationsCounter++;
    }

    /**
     * Records the user token passed to edit the employer's account method and increments the method call counter.
     *
     * @param Token The token (email) of the employer navigating to edit the account.
     */
    @Override
    public void editAccount(String Token) {
        lastTokenPassed = Token;
        editedAccountCounter++;
    }

    /**
     * Retrieves the recorded token error message.
     *
     * @return The token error message stored in the stub.
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
     * Retrieves the count of method calls for managing job positions.
     *
     * @return The count of manageJobPositions method calls stored in the stub.
     */
    public int getManageJobPositionsCounter() { return manageJobPositionsCounter;}

    /**
     * Retrieves the count of method calls for updating job applications.
     *
     * @return The count of updateJobApplications method calls stored in the stub.
     */
    public int getUpdatedJobApplicationsCounter() {return updatedJobApplicationsCounter;}

    /**
     * Retrieves the count of method calls for editing the employer's account.
     *
     * @return The count of editAccount method calls stored in the stub.
     */
    public int getEditedAccountCounter() {return editedAccountCounter;}

}

