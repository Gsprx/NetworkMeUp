package com.example.networkmeup.view.HomeEmployee;
/**
 * Presenter for the HomeEmployeeActivity.
 * <p>
 * This class handles the business logic for the HomeEmployeeActivity.
 * It interacts with the view to manage actions like modifying CV, searching jobs,
 * editing account details, and validating the user token.
 * </p>
 */
public class HomeEmployeePresenter {
    private HomeEmployeeView view;
    //user token is the email of the employee
    private String userToken;
    /**
     * Constructor for HomeEmployeePresenter.
     * <p>
     * Initializes the presenter with the given view and user token. It also validates
     * the user token upon instantiation.
     * </p>
     *
     * @param view      The view associated with this presenter.
     * @param userToken The user token (email) of the employee.
     */
    public HomeEmployeePresenter(HomeEmployeeView view, String userToken){
        this.view = view;
        validateToken(userToken);
        this.userToken = userToken;
    }
    /**
     * Validates the user token.
     * <p>
     * This method checks if the provided token is null and displays an error message
     * through the view if it is. It is intended to ensure that the user session is valid.
     * </p>
     *
     * @param obj The object to be validated, expected to be the user token.
     * @throws NullPointerException if the provided token is null.
     */
    private void validateToken(Object obj){
        if (obj == null){
            view.showTokenErrorMessage("An error has occurred during login, please try again.");
            throw new NullPointerException("Error! Null token.");
        }
    }
    /**
     * Handles the action to modify the CV.
     * <p>
     * Instructs the view to navigate to the activity for modifying the CV,
     * passing along the user token.
     * </p>
     */
    public void onModifyCV(){
        view.modifyCV(userToken);
    }
    /**
     * Handles the action to search for jobs.
     * <p>
     * Instructs the view to navigate
     to the activity for searching jobs,
     * passing along the user token.
     * </p>
     */
    public void onSearchJobs(){
        view.searchJobs(userToken);
    }
    /**
     * Handles the action to edit the employee's account.
     * <p>
     * Instructs the view to navigate to the activity for editing the employee's account,
     * passing along the user token.
     * </p>
     */
    public void onEditAccount(){
        view.editAccount(userToken);
    }
}

