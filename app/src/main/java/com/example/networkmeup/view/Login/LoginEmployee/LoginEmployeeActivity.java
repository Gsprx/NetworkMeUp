package com.example.networkmeup.view.Login.LoginEmployee;

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
import com.example.networkmeup.view.Login.LoginActivity;
import com.example.networkmeup.view.SignUp.SignUpActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;
/**
 * Activity for logging in as an employee.
 * <p>
 * This activity provides the user interface for employee login, facilitating user interactions
 * and input handling. It utilizes LoginEmployeePresenter for processing the login logic.
 * </p>
 */
public class LoginEmployeeActivity extends AppCompatActivity implements LoginEmployeeView{
    /**
     * Called when the activity is starting.
     * <p>
     * Initializes the activity's layout and components, sets up listeners for user interactions,
     * and prepares the LoginEmployeePresenter with necessary dependencies.
     * </p>
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_employee);

        //Initialize the presenter with this view and an EmployeeDAO (in-memory database)
        final LoginEmployeePresenter presenter = new LoginEmployeePresenter(this, new EmployeeDAOMemory());

        // Find the login button by its ID and set a click listener
        findViewById(R.id.btnLoginEmployee).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // When the login button is pressed, trigger the presenter's login method
                        presenter.onLogin();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonLoginEmployee).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(LoginEmployeeActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }
    /**
     * Retrieves the entered email from the UI.
     * <p>
     * This method captures the email input from the EditText field and returns it as an Email object.
     * </p>
     *
     * @return An Email object containing the email entered by the user.
     * @throws RuntimeException if there is an error in retrieving the email.
     */
    // Method to get the email entered by the user from the UI
    @Override
    public Email getEmail() throws RuntimeException {
        return new Email(((EditText) findViewById(R.id.editTextLoginEmployeeEmail)).getText().toString().trim());
    }
    /**
     * Retrieves the entered password from the UI.
     * <p>
     * This method captures the password input from the EditText field and returns it as a Password object.
     * </p>
     *
     * @return A Password object containing the password entered by the user.
     * @throws RuntimeException if there is an error in retrieving the password.
     */
    // Method to get the password entered by the user from the UI
    @Override
    public Password getPassword() throws RuntimeException {
        return new Password(((EditText) findViewById(R.id.editTextLoginEmployeePassword)).getText().toString().trim());
    }
    /**
     * Displays an error message to the user in an AlertDialog.
     * <p>
     * This method is used to show error messages related to login issues such as invalid input or authentication failure.
     * </p>
     *
     * @param title   The title of the error message.
     * @param message The content of the error message.
     */
    // Method to display an error message in an AlertDialog
    @Override
    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(LoginEmployeeActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }
    /**
     * Proceeds to the HomeEmployeeActivity after a successful login.
     * <p>
     * This method navigates the user to the HomeEmployeeActivity, carrying the user token obtained after a successful login.
     * </p>
     *
     * @param userToken A string representing the user's token obtained after successful login.
     */
    // Method to proceed to the HomeEmployeeActivity after a successful login
    @Override
    public void successfullyFinishLogin(String userToken) {
        // Create an intent to navigate to the HomeEmployeeActivity
        Intent intent = new Intent(LoginEmployeeActivity.this, HomeEmployeeActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }


}

