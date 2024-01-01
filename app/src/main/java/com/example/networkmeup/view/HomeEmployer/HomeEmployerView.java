package com.example.networkmeup.view.HomeEmployer;

public interface HomeEmployerView {
    /**
     * Method to display an error message related to the user token.
     * @param errorMessage The error message to be displayed.
     */
    void showTokenErrorMessage(String errorMessage);

    /**
     * Method to navigate to the job positions management screen.
     * @param userToken The token (email) of the employer.
     */
    void manageJobPositions(String userToken);

    /**
     * Method to navigate to the job applications update screen.
     * @param userToken The token (email) of the employer.
     */
    void updateJobApplications(String userToken);

    /**
     * Method to navigate to the employer's account editing screen.
     * @param userToken The token (email) of the employer.
     */
    void editAccount(String userToken);
}

