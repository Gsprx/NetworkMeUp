package com.example.networkmeup.view.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.view.Login.LoginEmployee.LoginEmployeeActivity;
import com.example.networkmeup.view.Login.LoginEmployer.LoginEmployerActivity;
import com.example.networkmeup.view.SignUp.SignUpActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;
/**
 * LoginActivity handles the user interface for login selection in the NetworkMeUp application.
 * <p>
 * This activity provides options for users to navigate to either the employee or employer
 * login screens or return to the start page.
 * </p>
 */
public class LoginActivity extends AppCompatActivity implements LoginView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final LoginPresenter presenter = new LoginPresenter(this);

        //Employee login selected in Login page
        findViewById(R.id.btnLoginSelectEmployee).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.onLoginEmployee();
                    }
                });

        //Employer login selected in Login page
        findViewById(R.id.btnLoginSelectEmployer).setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        presenter.onLoginEmployer();
                    }
                });
        // when back button is pressed
        findViewById(R.id.backbuttonLogin).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(LoginActivity.this, StartPageActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }


    /**
     * Navigates to the Employee login activity.
     * <p>
     * This method is called when the user chooses to log in as an employee.
     * </p>
     */
    @Override
    public void EmployeeLogin() {
        Intent intent = new Intent(LoginActivity.this, LoginEmployeeActivity.class);
        startActivity(intent);
    }
    /**
     * Navigates to the Employer login activity.
     * <p>
     * This method is called when the user chooses to log in as an employer.
     * </p>
     */
    @Override
    public void EmployerLogin() {
        Intent intent = new Intent(LoginActivity.this, LoginEmployerActivity.class);
        startActivity(intent);
    }
}