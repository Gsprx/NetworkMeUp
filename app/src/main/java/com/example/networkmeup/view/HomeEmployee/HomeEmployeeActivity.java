package com.example.networkmeup.view.HomeEmployee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.view.EditAccountEmployee.EditAccountEmployeeActivity;
import com.example.networkmeup.view.HomeEmployer.HomeEmployerActivity;
import com.example.networkmeup.view.Login.LoginEmployee.LoginEmployeeActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVActivity;
import com.example.networkmeup.view.SearchJobs.SearchJobsActivity;
import com.example.networkmeup.view.SignUp.SignUpActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;
/**
 * Activity representing the home screen for employees.
 * <p>
 * This class is an activity that serves as the main interface for employees after they log in.
 * It provides functionalities such as modifying CV, searching for jobs, editing account information,
 * and logging out. It interacts with a presenter to handle these actions.
 * </p>
 */
public class HomeEmployeeActivity extends AppCompatActivity implements HomeEmployeeView{
    /**
     * Called when the activity is starting.
     * <p>
     * This method initializes the activity, sets the content view, and retrieves the user token.
     * It sets up click listeners for different actions and interacts with the HomeEmployeePresenter
     * for handling these actions.
     * </p>
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down
     *                           then this Bundle contains the data it most recently supplied. Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_employee);

        //homepage employee activity requires a login token from the user that logged in (token = email)
        Bundle extras = getIntent().getExtras();

        String userEmail = null;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        //pass user token to presenter
        final HomeEmployeePresenter presenter = new HomeEmployeePresenter(this, userEmail);


        //when modify CV button is pressed
        findViewById(R.id.btnHomeEmployeeModifyCV).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onModifyCV();
                    }
                }
        );

        //when search jobs button is pressed
        findViewById(R.id.btnHomeEmployeeSearchJobs).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onSearchJobs();
                    }
                }
        );

        //when edit account button is pressed
        findViewById(R.id.btnHomeEmployeeEditAccount).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onEditAccount();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.logoutbuttonHomeEmployee).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        new AlertDialog.Builder(HomeEmployeeActivity.this)
                                .setTitle("Confirm Log Out")
                                .setMessage("Are you sure you want to log out from your account?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        // Perform the logout process here
                                        Intent intentDelete = new Intent(HomeEmployeeActivity.this, StartPageActivity.class);
                                        intentDelete.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                        startActivity(intentDelete);
                                    }
                                })
                                .setNegativeButton(android.R.string.no, null)
                                .show();
                    }
                }
        );
    }
    /**
     * Displays an error message if there is an issue with the user token.
     * <p>
     * This method shows an error dialog when there is a problem with the user's login token.
     * It navigates the user back to the login screen for re-authentication if necessary.
     * </p>
     *
     * @param message The error message to be displayed.
     */
    //error message specifically for login token errors
    public void showTokenErrorMessage(String message) {
        new AlertDialog.Builder(HomeEmployeeActivity.this)
                .setCancelable(false)
                .setTitle("Login Token Error")
                .setMessage(message)
                .setPositiveButton(R.string.ok,
                        new DialogInterface.OnClickListener(){
                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(HomeEmployeeActivity.this, LoginEmployeeActivity.class);
                                startActivity(intent);
                            }}).create().show();
    }

    //
    //    methods to start new activities must pass the userToken
    //    using intent.putExtra("token", userToken);
    //
    /**
     * Navigates to the ModifyCVActivity.
     * <p>
     * This method is called to navigate the employee to the ModifyCVActivity,
     * passing along the user token
     for identification and session management.
     * </p>
     *
     * @param userToken The token (email) of the employee, used for identification in subsequent activities.
     */
    @Override
    public void modifyCV(String userToken) {
        Intent intent = new Intent(HomeEmployeeActivity.this, ModifyCVActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }
    /**
     * Navigates to the SearchJobsActivity.
     * <p>
     * This method is called to navigate the employee to the SearchJobsActivity,
     * passing along the user token. It allows employees to search for available job positions.
     * </p>
     *
     * @param userToken The token (email) of the employee, used for identification in subsequent activities.
     */
    @Override
    public void searchJobs(String userToken) {
        Intent intent = new Intent(HomeEmployeeActivity.this, SearchJobsActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }
    /**
     * Navigates to the EditAccountEmployeeActivity.
     * <p>
     * This method is called to navigate the employee to the EditAccountEmployeeActivity,
     * passing along the user token. It allows employees to edit their account information.
     * </p>
     *
     * @param userToken The token (email) of the employee, used for identification in subsequent activities.
     */
    @Override
    public void editAccount(String userToken) {
        Intent intent = new Intent(HomeEmployeeActivity.this, EditAccountEmployeeActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }

}