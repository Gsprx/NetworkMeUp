package com.example.networkmeup.view.EditAccountEmployee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.networkmeup.R;
import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.view.EditAccountEmployee.ShowApplicationsEmployee.ShowApplicationsEmployeeActivity;
import com.example.networkmeup.view.HomeEmployee.HomeEmployeeActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;
/**
 * Activity class for editing an employee's account.
 * <p>
 * This class provides a user interface for editing details of an employee account,
 * such as email, password, phone number, name, and address.
 * It handles user interactions and communicates with the Presenter for processing.
 * </p>
 */
public class EditAccountEmployeeActivity extends AppCompatActivity implements EditAccountEmployeeView {

    private Employee currEmployee;
    /**
     * Initializes the activity.
     * <p>
     * This method sets up the user interface and initializes the presenter and view components.
     * It also sets onClick listeners for various buttons like Save, Delete, and Show Applications.
     * </p>
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_account_employee);

        Bundle extras = getIntent().getExtras();

        final String userEmail;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        else{
            userEmail = null;
        }
        //get employee data to pass to recycler view
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        currEmployee = employeeDAO.getByEmail(new Email(userEmail));

        //Preset the data
        EditText passwd = findViewById(R.id.EditAccountEmployeePassword);
        passwd.setText(currEmployee.getPassword().getPassword());

        EditText phone = findViewById(R.id.EditAccountEmployeePhoneNumber);
        phone.setText(currEmployee.getPhone().getNumber());

        EditText email = findViewById(R.id.EditAccountEmpoyeeEmail);
        email.setText(currEmployee.getEmail().getAddress());

        EditText name = findViewById(R.id.EditAccountEmployeeName);
        name.setText(currEmployee.getName());

        EditText address = findViewById(R.id.EditAccountEmployeeAddress);
        address.setText(currEmployee.getAddress());


        final EditAccountEmployeePresenter presenter = new EditAccountEmployeePresenter(this, userEmail);
        // when back button is pressed
        findViewById(R.id.backbuttonEditAccountEmployee).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(EditAccountEmployeeActivity.this, HomeEmployeeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
        // when Show Applications button is pressed
        findViewById(R.id.btnAEditEmployeeAccountApplications).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        presenter.ApplicationArchive();
                    }
                }
        );

        // Save button onClick listener
        findViewById(R.id.btnEditEmployeeAccountSave).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When button is pressed
                        presenter.Save();

                    }
                }
        );

        // Delete button onClick listener
        findViewById(R.id.btnEditEmployeeAccountDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add your logic here for handling deletion
                // For instance, you can prompt a confirmation dialog before deleting the account

                new AlertDialog.Builder(EditAccountEmployeeActivity.this)
                        .setTitle("Confirm Deletion")
                        .setMessage("Are you sure you want to delete your account?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Perform the deletion process here
                                presenter.Delete();
                                Intent intentDelete = new Intent(EditAccountEmployeeActivity.this, StartPageActivity.class);
                                intentDelete.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                startActivity(intentDelete);
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .show();
            }
        });
    }
    /**
     * Displays an error message in a dialog.
     *
     * @param title   The title of the dialog.
     * @param message The message to be displayed in the dialog.
     */
    @Override
    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(EditAccountEmployeeActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }
    /**
     * Handles successful save operations.
     * <p>
     * This method is called after successful account modifications, showing a confirmation dialog
     * and redirecting to the home page.
     * </p>
     * @param message The message to be displayed upon successful save.
     */
    @Override
    //after a successful change, return to start page
    public void successfullySaved(String message) {
        new AlertDialog.Builder(EditAccountEmployeeActivity.this)
                .setCancelable(false)
                .setTitle("Account Successfully Changed!")
                .setMessage(message)

                //when the continue to Save Changes button is pressed, the employee start page opens for the user.
                .setPositiveButton(R.string.continue_to_home_page,
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {
                                Intent intentSave = new Intent(EditAccountEmployeeActivity.this, HomeEmployeeActivity.class);
                                intentSave.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                                startActivity(intentSave);
                            }}).create().show();
    }

    @Override
    public Email getEmail() throws  RuntimeException {
        return new Email(((EditText)findViewById(R.id.EditAccountEmpoyeeEmail)).getText().toString().trim());
    }

    @Override
    public Password getPassword() throws RuntimeException {
        return new Password(((EditText)findViewById(R.id.EditAccountEmployeePassword)).getText().toString().trim());
    }

    @Override
    public Phone getPhoneNumber() throws RuntimeException {
        return new Phone(((EditText)findViewById(R.id.EditAccountEmployeePhoneNumber)).getText().toString().trim());
    }
    @Override
    public String getAddress() throws RuntimeException{
        return ((EditText)findViewById(R.id.EditAccountEmployeeAddress)).getText().toString().trim();
    }

    @Override
    public String getName() throws RuntimeException{
        return ((EditText)findViewById(R.id.EditAccountEmployeeName)).getText().toString().trim();
    }

    @Override
    public void ApplicationArchive(String userEmail) {
        Intent intentArchive = new Intent(EditAccountEmployeeActivity.this, ShowApplicationsEmployeeActivity.class);
        intentArchive.putExtra("token", userEmail);
        startActivity(intentArchive);
    }
}