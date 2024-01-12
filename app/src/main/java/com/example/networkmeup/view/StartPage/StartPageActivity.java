package com.example.networkmeup.view.StartPage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.networkmeup.R;
import com.example.networkmeup.daoMemory.MemoryInitializer;
import com.example.networkmeup.view.Login.LoginActivity;
import com.example.networkmeup.view.SignUp.SignUpActivity;

/**
 * StartPageActivity is the initial screen of the application that offers options to either log in or sign up.
 * It is responsible for the user interface related to the start page.
 */
public class StartPageActivity extends AppCompatActivity implements StartPageView {

    private static boolean initialized = false;

    /**
     * Called when the activity is starting. This method is where the initial setup for the activity is done,
     * such as creating the view and binding data to lists.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           then this Bundle contains the data it most recently supplied. Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);

        final StartPagePresenter presenter = new StartPagePresenter(this);

        // Initialize the memory with default data if not already done
        if (!initialized) {
            new MemoryInitializer().prepareData();
            initialized = true;
        }

        setupButtonListeners(presenter);
    }

    /**
     * Sets up listeners for the Login and Sign Up buttons.
     *
     * @param presenter The presenter associated with this view.
     */
    private void setupButtonListeners(final StartPagePresenter presenter) {
        findViewById(R.id.btnStartPageLogin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onLogin();
            }
        });

        findViewById(R.id.btnStartPageSignUp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onSignUp();
            }
        });
    }

    /**
     * Initiates the login process by starting the LoginActivity.
     * This method is called when the user chooses to log in.
     */
    @Override
    public void login() {
        Intent intent = new Intent(StartPageActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * Initiates the sign-up process by starting the SignUpActivity.
     * This method is called when the user chooses to sign up.
     */
    @Override
    public void signup() {
        Intent intent = new Intent(StartPageActivity.this, SignUpActivity.class);
        startActivity(intent);
    }
}