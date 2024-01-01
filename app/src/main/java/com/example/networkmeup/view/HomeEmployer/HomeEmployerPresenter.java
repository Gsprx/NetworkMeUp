package com.example.networkmeup.view.HomeEmployer;

public class HomeEmployerPresenter {
    private HomeEmployerView view;
    // user token is the email of the employer
    private String userToken;

    /**
     * Constructor for HomeEmployerPresenter.
     * @param view The view associated with the presenter.
     * @param userToken The token (email) of the employer.
     */
    public HomeEmployerPresenter(HomeEmployerView view, String userToken) {
        this.view = view;
        validateToken(userToken);
        this.userToken = userToken;
    }

    /**
     * Method to validate the user token.
     * @param obj The token to be validated.
     */
    private void validateToken(Object obj) {
        if (obj == null) {
            view.showTokenErrorMessage("An error has occurred during login, please try again.");
            throw new NullPointerException("Error! Null token.");
        }
    }

    /**
     * Method to handle action for managing job positions.
     */
    public void onManageJobPositions() {
        view.manageJobPositions(userToken);
    }

    /**
     * Method to handle action for updating job applications.
     */
    public void onUpdateJobApplications() {
        view.updateJobApplications(userToken);
    }

    /**
     * Method to handle action for editing the employer's account.
     */
    public void onEditAccount() {
        view.editAccount(userToken);
    }
}
