package com.example.networkmeup.view.SignUp.SignUpEmployee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.networkmeup.R;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.view.Login.LoginEmployee.LoginEmployeeActivity;
import com.example.networkmeup.view.SignUp.SignUpActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;
/**
 * Activity for employee sign-up in the NetworkMeUp application.
 * <p>
 * This activity provides the user interface for new employees to sign up. It interacts with
 * {@link SignUpEmployeePresenter} to handle the business logic of sign-up.
 * </p>
 */
public class SignUpEmployeeActivity extends AppCompatActivity implements SignUpEmployeeView {
    /**
     * Initializes the activity. This is where the layout is set and event listeners are established.
     *
     * @param savedInstanceState If the activity is being re-initialized after being shut down,
     *                           this Bundle contains the most recent data, or null if it is the first time.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_employee);

        final SignUpEmployeePresenter presenter = new SignUpEmployeePresenter(this, new EmployeeDAOMemory());

        findViewById(R.id.btnSignupEmployeeCreate).setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //When Login button is pressed
                    presenter.onCreate();
                }
            }
        );

        // when back button is pressed
        findViewById(R.id.backbuttonSignUpEmployee).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(SignUpEmployeeActivity.this, SignUpActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }

    /**
     * Shows an error message in a dialog.
     *
     * @param title   The title of the error dialog.
     * @param message The error message to be displayed.
     */
    @Override
    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(SignUpEmployeeActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }
    /**
     * Shows a success message and navigates to the login screen upon successful account creation.
     *
     * @param message The success message to be displayed.
     */

    @Override
    //after a successful signup, return to start page
    public void successfullyFinishActivity(String message) {
        new AlertDialog.Builder(SignUpEmployeeActivity.this)
                .setCancelable(false)
                .setTitle("Account Successfully Created!")
                .setMessage(message)

                //when the continue to login button is pressed, the employee login page opens for the user to login.
                .setPositiveButton(R.string.continue_to_login,
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(SignUpEmployeeActivity.this, LoginEmployeeActivity.class);
                                startActivity(intent);
                            }}).create().show();
    }


    /*
    *
    *   acquire text field from UI values
    *
    */
    /**
     * Retrieves the email from the input field.
     *
     * @return An {@link Email} object containing the entered email.
     * @throws RuntimeException if there is an issue in fetching the email.
     */
    @Override
    public Email getEmail() throws RuntimeException{
        return new Email(((EditText)findViewById(R.id.editTextSignUpEmployeeEmail)).getText().toString().trim());
    }
    /**
     * Retrieves the phone number from
     the input field.

     less
     Copy code
     * @return A {@link Phone} object containing the entered phone number.
     * @throws RuntimeException if there is an issue in fetching the phone number.
     */
    @Override
    public Phone getPhone() throws RuntimeException{
        return new Phone(((EditText)findViewById(R.id.editTextSignUpEmployeePhone)).getText().toString().trim());
    }
    /**
     * Retrieves the password from the input field.
     *
     * @return A {@link Password} object containing the entered password.
     * @throws RuntimeException if there is an issue in fetching the password.
     */
    @Override
    public Password getPassword() throws RuntimeException{
        return new Password(((EditText)findViewById(R.id.editTextSignUpEmployeePassword)).getText().toString().trim());
    }
}