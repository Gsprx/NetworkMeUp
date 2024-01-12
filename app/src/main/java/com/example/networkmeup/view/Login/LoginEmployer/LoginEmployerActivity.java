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
/**
 * Activity for logging in as an employer.
 * <p>
 * This activity provides the UI for employer login, handling user input and interactions.
 * It communicates with the LoginEmployerPresenter for processing the login logic.
 * </p>
 */
public class LoginEmployerActivity extends AppCompatActivity implements LoginEmployerView {
    /**
     * Called when the activity is starting.
     * <p>
     * This is where most initialization should go: calling setContentView(int) to inflate
     * the activity's UI, and using findViewById(int) to programmatically interact with widgets in the UI.
     * </p>
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
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
    /**
     * Retrieves the entered email from the UI.
     *
     * @return An Email object containing the email entered by the user.
     * @throws RuntimeException if there is an error in retrieving the email.
     */
    // Method to get the email entered by the user from the UI
    @Override
    public Email getEmail() throws RuntimeException {
        return new Email(((EditText) findViewById(R.id.editTextLoginEmployerEmail)).getText().toString().trim());
    }
    /**
     * Retrieves the entered password from the UI.
     *
     * @return A Password object containing the password entered by the user.
     * @throws RuntimeException if there is an error in retrieving the password.
     */
    // Method to get the password entered by the user from the UI
    @Override
    public Password getPassword() throws RuntimeException {
        return new Password(((EditText) findViewById(R.id.editTextLoginEmployerPassword)).getText().toString().trim());
    }
    /**
     * Displays an error message to the user.

     less
     Copy code
     * <p>
     * This method utilizes an AlertDialog to present error messages to the user.
     * It is typically called when there is an issue with user input or a login failure.
     * </p>
     *
     * @param title   The title of the error message.
     * @param message The content of the error message.
     */
    // Method to display an error message in an AlertDialog
    @Override
    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(LoginEmployerActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }
    /**
     * Navigates to the HomeEmployerActivity upon successful login.
     * <p>
     * This method is called when the login process completes successfully.
     * It passes the user token to the HomeEmployerActivity and starts it.
     * </p>
     *
     * @param userToken A string representing the user's token obtained after successful login.
     */
    // Method to proceed to the HomeEmployerActivity after a successful login
    @Override
    public void successfullyFinishLogin(String userToken) {
        // Create an intent to navigate to the HomeEmployerActivity
        Intent intent = new Intent(LoginEmployerActivity.this, HomeEmployerActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }
}