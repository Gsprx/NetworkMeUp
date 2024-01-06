package com.example.networkmeup.view.EditAccountEmployee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.networkmeup.R;
import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Password;
import com.example.networkmeup.domain.Phone;
import com.example.networkmeup.utils.RecyclerViewAdapters.ApplicationRecyclerViewAdapter;
import com.example.networkmeup.view.EditAccountEmployer.EditAccountEmployerActivity;
import com.example.networkmeup.view.HomeEmployee.HomeEmployeeActivity;
import com.example.networkmeup.view.HomeEmployer.HomeEmployerActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;

import java.util.ArrayList;

public class EditAccountEmployeeActivity extends AppCompatActivity implements EditAccountEmployeeView {

    private Employee currEmployee;
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


        ArrayList<Application> ApplicationList = currEmployee.getApplications();

        //get recycler view reference
        RecyclerView recyclerView = findViewById(R.id.recyclerViewEditAccountEmployee);
        //create Adapter
        ApplicationRecyclerViewAdapter applicationRecycler = new ApplicationRecyclerViewAdapter(this,ApplicationList);
        recyclerView.setAdapter(applicationRecycler);
        //Set the layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final EditAccountEmployeePresenter presenter = new EditAccountEmployeePresenter(this);

        // Save button onClick listener
        findViewById(R.id.btnEditEmployeeAccountSave).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When button is pressed
                        presenter.onCreate();

                        Intent intentSave = new Intent(EditAccountEmployeeActivity.this, HomeEmployeeActivity.class);
                        intentSave.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intentSave);
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
                                presenter.Delete(currEmployee);
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

    @Override
    public void showErrorMessage(String title, String message) {
        new AlertDialog.Builder(EditAccountEmployeeActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    @Override
    //after a successful change, return to start page
    public void successfullyFinishActivity(String message) {
        new AlertDialog.Builder(EditAccountEmployeeActivity.this)
                .setCancelable(false)
                .setTitle("Account Successfully Changed!")
                .setMessage(message)

                //when the continue to Save Changes button is pressed, the employee start page opens for the user.
                .setPositiveButton(R.string.continue_to_home_page,
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(EditAccountEmployeeActivity.this, HomeEmployeeActivity.class);
                                startActivity(intent);
                            }}).create().show();
    }

    @Override
    public Employee getCurrEmployee(){
        return this.currEmployee;
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
}