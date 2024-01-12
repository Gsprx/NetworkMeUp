package com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.AddNewWorkExperience;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.networkmeup.R;
import com.example.networkmeup.dao.ExpertiseAreaDAO;
import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.LevelOfStudies;
import com.example.networkmeup.view.ModifyCV.ModifyCVActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.ModifyCVEditWorkExperienceActivity;


import java.util.ArrayList;
/**
 * Activity for adding new work experience in the application.
 * This class sets up the user interface for adding work experience, handles user input,
 * and communicates with the presenter to add new work experience data to the employee's profile.
 */
public class AddNewWorkExperienceActivity extends AppCompatActivity implements AddNewWorkExperienceView {
    /**
     * Initializes the activity, setting up the user interface and handling user interactions.
     *
     * @param savedInstanceState If the activity is being re-initialized after being shut down,
     *                           this Bundle contains the data most recently supplied in onSaveInstanceState.
     *                           Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_work_experience);

        Bundle extras = getIntent().getExtras();

        final String userEmail;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        else{
            userEmail = null;
        }

        final AddNewWorkExperiencePresenter presenter = new AddNewWorkExperiencePresenter(this, userEmail);

        //create spinner declarations
        Spinner expFieldSpinner = findViewById(R.id.spinnerAddNewWorkExperienceSelectExpField);
        Spinner yearsofworkSpinner = findViewById(R.id.spinnerAddNewWorkExperienceYearsofwork);

        ArrayList<Integer> yearsofwork = new ArrayList<>();
        ArrayList<String> expFields = new ArrayList<>();

        //create spinner list for years of work
        for(int i = 1; i<= 15; i++){
            yearsofwork.add(i);
        }

        //create spinner list for exp fields
        ExpertiseAreaDAO expAreaDAO = new ExpertiseAreaDAOMemory();
        ArrayList<ExpertiseArea> expertiseAreas = expAreaDAO.getAll();
        for(ExpertiseArea expertiseArea : expertiseAreas){
            expFields.add(expertiseArea.getArea());
        }

        //pass adapter to spinners and define behavior
        ArrayAdapter<Integer> YearsatworkAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, yearsofwork);
        yearsofworkSpinner.setAdapter(YearsatworkAdapter);
        yearsofworkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int selectedYearsAtWork = yearsofwork.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });

        ArrayAdapter<String> expFieldsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, expFields);
        expFieldSpinner.setAdapter(expFieldsAdapter);
        expFieldSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedExpField = expFields.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });


        //when add button is pressed
        findViewById(R.id.btnAddNewWorkExperience).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        presenter.onAdd();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonAddNewWorkExperience).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(AddNewWorkExperienceActivity.this, ModifyCVEditWorkExperienceActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }
    /**
     * Displays a success message in a dialog when a new work experience is successfully added.
     * Also provides an option to return to the Modify CV view.
     *
     * @param message   The success message to be displayed.
     * @param userToken The token identifying the current user.
     */
    public void successfulAdd(String message, String userToken){
        new AlertDialog.Builder(AddNewWorkExperienceActivity.this)
                .setCancelable(false)
                .setTitle("Creation Completed!")
                .setMessage(message)

                //return back to modify cv view when pressed
                .setPositiveButton("Return to Modify CV",
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(AddNewWorkExperienceActivity.this, ModifyCVActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }
    /**
     * Gets the description of the new work experience from the EditText view.
     *
     * @return The description entered by the user.
     */
    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.editTextAddNewWorkExperienceDescription)).getText().toString().trim();
    }
    /**
     * Gets the selected position of the expertise area from the spinner.
     *
     * @return The position of the selected expertise area.
     */
    @Override
    public int getExpertiseArea() {
        //get position in respective list
        return ((Spinner)findViewById(R.id.spinnerAddNewWorkExperienceSelectExpField)).getSelectedItemPosition();
    }
    /**
     * Gets the selected number of years at work from the spinner.
     *
     * @return The position representing the number of years at work.
     */
    @Override
    public int getYearsAtWork() {
        //get position in respective enum ordinal
        return ((Spinner)findViewById(R.id.spinnerAddNewWorkExperienceYearsofwork)).getSelectedItemPosition();
    }

}
