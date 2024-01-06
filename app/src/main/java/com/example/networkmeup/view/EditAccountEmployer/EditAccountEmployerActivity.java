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
import com.example.networkmeup.view.HomeEmployee.HomeEmployeeActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;

public class EditAccountEmployerActivity extends AppCompatActivity implements EditAccountEmployerView {

    private Employer currEmployer;

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
        EditText passwd = findViewById(R.id.editTextEditAccountEmployerPassword);
        passwd.setText(currEmployer.getPassword().toString());

        EditText phone = findViewById(R.id.editTextEditAccountEmployerPhone);
        phone.setText(currEmployer.getPhone().toString());

        EditText email = findViewById(R.id.editTextEditAccountEmployerEmail);
        email.setText(currEmployer.getEmail().toString());

        EditText tin = findViewById(R.id.editTextEditAccountEmployerTIN);
        tin.setText(currEmployer.getTin().toString());

        final EditAccountEmployerPresenter presenter = new EditAccountEmployerPresenter(this);

        // Save button onClick listener
        findViewById(R.id.btnEditEmployerAccountSave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onCreate();
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
                                presenter.Delete(currEmployer);
                                Intent intent = new Intent(EditAccountEmployerActivity.this, StartPageActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .show();
            }
        });
    }

    // Method to show error message in an AlertDialog
    @Override
    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(EditAccountEmployerActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    // Method to handle successful account change
    @Override
    public void successfullyFinishActivity(String message) {
        new AlertDialog.Builder(EditAccountEmployerActivity.this)
                .setCancelable(false)
                .setTitle("Account Successfully Changed!")
                .setMessage(message)
                .setPositiveButton(R.string.continue_to_home_page, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(EditAccountEmployerActivity.this, HomeEmployeeActivity.class);
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
