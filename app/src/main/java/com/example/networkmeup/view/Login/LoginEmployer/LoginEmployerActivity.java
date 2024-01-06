package com.example.networkmeup.view.Login.LoginEmployer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.networkmeup.R;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.view.HomeEmployer.HomeEmployerActivity;
import com.example.networkmeup.view.Login.LoginActivity;
import com.example.networkmeup.view.SignUp.SignUpActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;

public class LoginEmployerActivity extends AppCompatActivity implements LoginEmployerView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_employer);

        // Initialize the presenter with this view and an EmployerDAO
        final LoginEmployerPresenter presenter = new LoginEmployerPresenter(this, new EmployerDAOMemory());

        // Find the login button by its ID and set a click listener
        findViewById(R.id.btnLoginEmployer).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // When the login button is pressed, trigger the presenter's login method
                        presenter.onLogin();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonLoginEmployer).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(LoginEmployerActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }

    // Method to get the email entered by the user from the UI
    @Override
    public Email getEmail() throws RuntimeException {
        return new Email(((EditText) findViewById(R.id.editTextLoginEmployerEmail)).getText().toString().trim());
    }

    // Method to get the password entered by the user from the UI
    @Override
    public Password getPassword() throws RuntimeException {
        return new Password(((EditText) findViewById(R.id.editTextLoginEmployerPassword)).getText().toString().trim());
    }

    // Method to display an error message in an AlertDialog
    @Override
    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(LoginEmployerActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    // Method to proceed to the HomeEmployerActivity after a successful login
    @Override
    public void successfullyFinishLogin(String userToken) {
        // Create an intent to navigate to the HomeEmployerActivity
        Intent intent = new Intent(LoginEmployerActivity.this, HomeEmployerActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }
}