package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.AddNewReqWorkExperience;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.networkmeup.R;
import com.example.networkmeup.dao.ExpertiseAreaDAO;
import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LevelOfStudies;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation.AddNewReqEducationActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation.AddNewReqEducationPresenter;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.EditReqEducationActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.EditReqWorkExperienceActivity;

import java.util.ArrayList;

/**
 * This class represents an activity where a new required work experience can be added.
 * It extends AppCompatActivity and implements AddNewReqWorkExperienceView.
 */
public class AddNewReqWorkExperienceActivity extends AppCompatActivity implements AddNewReqWorkExperienceView {

    /**
     * Called when the activity is starting.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle). Note: Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_req_work_experience);

        Bundle extras = getIntent().getExtras();

        final String userEmail;
        final Job currJob;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
            currJob = (Job)extras.getSerializable("job");
        }
        else{
            userEmail = null;
            currJob = null;
        }

        // Initialize presenter
        final AddNewReqWorkExperiencePresenter presenter = new AddNewReqWorkExperiencePresenter(this, userEmail, currJob);

        //create spinner declarations
        Spinner expFieldSpinner = findViewById(R.id.spinnerAddNewReqWorkExperienceExpertiseField);
        Spinner YearsATWork = findViewById(R.id.spinnerAddNewReqWorkExperienceYears);

        ArrayList<Integer> YearsFields = new ArrayList<Integer>();
        ArrayList<String> expFields = new ArrayList<String>();

        //create spinner list for years at work
        for(int i = 1; i<= 15 ; i++){
            YearsFields.add(i);
        }

        //create spinner list for exp fields
        ExpertiseAreaDAO expAreaDAO = new ExpertiseAreaDAOMemory();
        ArrayList<ExpertiseArea> expertiseAreas = expAreaDAO.getAll();
        for(ExpertiseArea expertiseArea : expertiseAreas){
            expFields.add(expertiseArea.getArea());
        }

        //pass adapter to spinners and define behavior
        ArrayAdapter<Integer> YearsAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, YearsFields);
        YearsATWork.setAdapter(YearsAdapter);
        YearsATWork.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * Callback method to be invoked when an item in this view has been selected.
             * @param parent The AdapterView where the selection happened
             * @param view The view within the AdapterView that was clicked
             * @param position The position of the view in the adapter
             * @param id The row id of the item that is selected
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Integer selectedYears = YearsFields.get(position);
            }

            /**
             * Callback method to be invoked when the selection disappears from this view.
             * @param parent The AdapterView that now contains no selected item.
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });

        ArrayAdapter<String> expFieldsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, expFields);
        expFieldSpinner.setAdapter(expFieldsAdapter);
        expFieldSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * Callback method to be invoked when an item in this view has been selected.
             * @param parent The AdapterView where the selection happened
             * @param view The view within the AdapterView that was clicked
             * @param position The position of the view in the adapter
             * @param id The row id of the item that is selected
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedExpField = expFields.get(position);
            }

            /**
             * Callback method to be invoked when the selection disappears from this view.
             * @param parent The AdapterView that now contains no selected item.
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });

        //when add button is pressed
        findViewById(R.id.buttonAddNewReqWorkExp).setOnClickListener(
                new View.OnClickListener() {
                    /**
                     * Called when a view has been clicked.
                     * @param v The view that was clicked.
                     */
                    @Override
                    public void onClick(View v) {
                        presenter.onAdd();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonAddNewReqWorkExp).setOnClickListener(
                new View.OnClickListener(){
                    /**
                     * Called when a view has been clicked.
                     * @param v The view that was clicked.
                     */
                    public void onClick(View v){
                        Intent intent = new Intent(AddNewReqWorkExperienceActivity.this, EditReqWorkExperienceActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }


    /**
     * This method is called when a new required work experience is successfully added.
     * It shows an alert dialog with a success message and an option to return to the Change Job Details activity.
     * @param message The success message to be displayed.
     * @param userToken The token of the user.
     * @param job The job object.
     */
    @Override
    public void successfulAdd(String message, String userToken, Job job){
        new AlertDialog.Builder(AddNewReqWorkExperienceActivity.this)
                .setCancelable(false)
                .setTitle("Creation Completed!")
                .setMessage(message)

                //return back to modify cv view when pressed
                .setPositiveButton("Return to Change Job Details",
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(AddNewReqWorkExperienceActivity.this, ChangeJobDetailsActivity.class);
                                intent.putExtra("token", userToken);
                                intent.putExtra("job", job);
                                startActivity(intent);
                            }}).create().show();
    }

    /**
     * This method gets the description entered by the user in the EditText field.
     * @return The description entered by the user.
     */
    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.editTextAddNewReqWorkExpDescription)).getText().toString().trim();
    }

    /**
     * This method gets the selected expertise area from the spinner.
     * @return The position of the selected expertise area in the spinner.
     */
    @Override
    public int getExpertiseArea() {
        //get position in respective list
        return ((Spinner)findViewById(R.id.spinnerAddNewReqWorkExperienceExpertiseField)).getSelectedItemPosition();
    }

    /**
     * This method gets the selected number of years from the spinner.
     * @return The position of the selected number of years in the spinner.
     */
    @Override
    public int getYears(){
        //get position in respective enum ordinal
        return ((Spinner)findViewById(R.id.spinnerAddNewReqWorkExperienceYears)).getSelectedItemPosition();
    }
}

