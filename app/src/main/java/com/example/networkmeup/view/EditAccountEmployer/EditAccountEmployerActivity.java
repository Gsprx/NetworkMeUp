package com.example.networkmeup.view.EditAccountEmployer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.networkmeup.R;
import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.domain.TIN;
import com.example.networkmeup.view.HomeEmployer.HomeEmployerActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;

/**
 * Activity for editing an employer's account details.
 * <p>
 * This class extends AppCompatActivity and implements the EditAccountEmployerView interface.
 * It handles user interactions for editing and deleting an employer's account details.
 * </p>
 */
public class EditAccountEmployerActivity extends AppCompatActivity implements EditAccountEmployerView {

    private Employer currEmployer;
    /**
     * Initializes the activity.
     * <p>
     * This method is called when the activity is starting. It sets the content view
     * and initializes UI components and event listeners for the edit and delete actions.
     * </p>
     * @param savedInstanceState If the activity is being re-initialized after previously being
     *                           shut down, this Bundle contains the data it most recently supplied.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account_employer);

        // Retrieving user token from Intent extras
        Bundle extras = getIntent().getExtras();
        final String userEmail;
        if (extras != null) {
            userEmail = extras.getString("token");
        } else {
            userEmail = null;
        }

        // Fetching employer data from DAO based on the received email
        EmployerDAO employerDAO = new EmployerDAOMemory();
        currEmployer = employerDAO.getByEmail(new Email(userEmail));

        // Pre-setting data into EditText fields from the current employer details
        EditText cmpname = findViewById(R.id.editTextEditAccountEmployerCompanyName);
        cmpname.setText(currEmployer.getCompanyName());

        EditText sct = findViewById(R.id.editTextEditAccountEmployerSector);
        sct.setText(currEmployer.getSector());

        EditText passwd = findViewById(R.id.editTextEditAccountEmployerPassword);
        passwd.setText(currEmployer.getPassword().getPassword());

        EditText phone = findViewById(R.id.editTextEditAccountEmployerPhone);
        phone.setText(currEmployer.getPhone().getNumber());

        EditText email = findViewById(R.id.editTextEditAccountEmployerEmail);
        email.setText(currEmployer.getEmail().getAddress());

        EditText tin = findViewById(R.id.editTextEditAccountEmployerTIN);
        tin.setText(currEmployer.getTin().getTin());

        final EditAccountEmployerPresenter presenter = new EditAccountEmployerPresenter(userEmail, this);
    // when back button is pressed
            findViewById(R.id.backbuttonEditAccountEmployer).setOnClickListener(
                    new View.OnClickListener(){
                        public void onClick(View v){
                            Intent intent = new Intent(EditAccountEmployerActivity.this, HomeEmployerActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            startActivity(intent);
                        }
                    }
            );
        // Save button onClick listener
        findViewById(R.id.btnEditEmployerAccountSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(EditAccountEmployerActivity.this)
                        .setCancelable(false)
                        .setTitle("Save Account Details Confirmation")
                        .setMessage("Are you sure you want to change your account details?")
                        .setPositiveButton("Yes",
                                new DialogInterface.OnClickListener(){
                                    public void onClick (DialogInterface dialog,int id) {
                                        //pass the work to the presenter
                                        presenter.Save();
                                    }})
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener(){
                                    public void onClick (DialogInterface dialog,int id) {
                                        //do nothing
                                    }}).create().show();
            }
        });

        // Delete button onClick listener
        findViewById(R.id.btnEditEmployerAccountDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your logic here for handling deletion
                // For instance, you can prompt a confirmation dialog before deleting the account

                new AlertDialog.Builder(EditAccountEmployerActivity.this)
                        .setTitle("Confirm Deletion")
                        .setMessage("Are you sure you want to delete your account?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Perform the deletion process here
                                presenter.Delete();
                                Intent intentDelete = new Intent(EditAccountEmployerActivity.this, StartPageActivity.class);
                                intentDelete.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                startActivity(intentDelete);
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .show();
            }
        });
    }

    // Method to show error message in an AlertDialog
    /**
     * Shows an error message in a dialog.
     * @param title   Title of the error message.
     * @param message Content of the error message.
     */
    @Override
    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(EditAccountEmployerActivity.this)
                .setCancelable(false)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }
    /**
     * Handles the successful completion of account changes.
     * @param message   The success message to be shown to the user.
     * @param userToken The user token that identifies the employer.
     */
    // Method to handle successful account change
    @Override
    public void successfullyFinishActivity(String message, String userToken) {
        new AlertDialog.Builder(EditAccountEmployerActivity.this)
                .setCancelable(false)
                .setTitle("Account Successfully Changed!")
                .setMessage(message)
                .setPositiveButton("Back to home page", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(EditAccountEmployerActivity.this, HomeEmployerActivity.class);
                        intent.putExtra("token", userToken);
                        startActivity(intent);
                    }
                }).create().show();
    }

    // Getter methods to obtain updated user information
    @Override
    public Employer getCurrEmployer() {
        return this.currEmployer;
    }

    @Override
    public String getCompanyName() throws RuntimeException {
        return new String(((EditText) findViewById(R.id.editTextEditAccountEmployerCompanyName)).getText().toString().trim());
    }

    @Override
    public String getSector() throws RuntimeException {
        return new String(((EditText) findViewById(R.id.editTextEditAccountEmployerSector)).getText().toString().trim());
    }

    @Override
    public Email getEmail() throws RuntimeException {
        return new Email(((EditText) findViewById(R.id.editTextEditAccountEmployerEmail)).getText().toString().trim());
    }

    @Override
    public Password getPassword() throws RuntimeException {
        return new Password(((EditText) findViewById(R.id.editTextEditAccountEmployerPassword)).getText().toString().trim());
    }

    @Override
    public Phone getPhoneNumber() throws RuntimeException {
        return new Phone(((EditText) findViewById(R.id.editTextEditAccountEmployerPhone)).getText().toString().trim());
    }

    @Override
    public TIN getTIN() throws RuntimeException {
        return new TIN(((EditText) findViewById(R.id.editTextEditAccountEmployerTIN)).getText().toString().trim());
    }
}
