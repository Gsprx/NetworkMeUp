package com.example.networkmeup.view.LoginEmployee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.networkmeup.R;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.view.HomeEmployee.HomeEmployeeActivity;

public class LoginEmployeeActivity extends AppCompatActivity implements LoginEmployeeView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_employee);

        //Initialize the presenter with this view and an EmployeeDAO (in-memory database)
        final LoginEmployeePresenter presenter = new LoginEmployeePresenter(this, new EmployeeDAOMemory());

        // Find the login button by its ID and set a click listener
        findViewById(R.id.btnLoginEmployee1).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // When the login button is pressed, trigger the presenter's login method
                        presenter.onLogin();
                    }
                }
        );
    }

    // Method to get the email entered by the user from the UI
    @Override
    public Email getEmail() throws RuntimeException {
        return new Email(((EditText) findViewById(R.id.editTextLoginEmployeeEmail)).getText().toString().trim());
    }

    // Method to get the password entered by the user from the UI
    @Override
    public Password getPassword() throws RuntimeException {
        return new Password(((EditText) findViewById(R.id.editTextLoginEmployeePassword)).getText().toString().trim());
    }

    // Method to display an error message in an AlertDialog
    @Override
    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(LoginEmployeeActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    // Method to proceed to the HomeEmployeeActivity after a successful login
    @Override
    public void successfullyFinishLogin(String message) {
        // Create an intent to navigate to the HomeEmployeeActivity
        Intent intent = new Intent(LoginEmployeeActivity.this, HomeEmployeeActivity.class);
        startActivity(intent);
    }


}

