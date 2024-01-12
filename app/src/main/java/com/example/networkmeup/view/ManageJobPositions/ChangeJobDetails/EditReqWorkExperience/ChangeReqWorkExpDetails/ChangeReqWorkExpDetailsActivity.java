package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.ChangeReqWorkExpDetails;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

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
import com.example.networkmeup.domain.WorkExperience;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.EditReqWorkExperienceActivity;

import java.util.ArrayList;

/**
 * This class represents an activity where the details of a required work experience can be changed.
 * It extends AppCompatActivity and implements ChangeReqWorkExpDetailsView.
 */
public class ChangeReqWorkExpDetailsActivity extends AppCompatActivity implements ChangeReqWorkExpDetailsView {

    /**
     * Called when the activity is starting.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle). Note: Otherwise it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_req_work_experience);

        Bundle extras = getIntent().getExtras();

        final String userEmail;
        final int eduPosition;
        final Job currJob;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
            //obtain position in list
            eduPosition = extras.getInt("position");
            currJob = (Job)extras.getSerializable("job");
        }
        else{
            userEmail = null;
            eduPosition = -1;
            currJob = null;
        }

        // Initialize presenter
        final ChangeReqWorkExpDetailsPresenter presenter = new ChangeReqWorkExpDetailsPresenter(this, userEmail, currJob);

        //create spinner declarations
        Spinner expFieldSpinner = findViewById(R.id.spinnerChangeReqWorkExpDetailsExpArea);
        Spinner YearsATWork = findViewById(R.id.spinnerChangeReqWorkExpYears);

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

        //when delete button is pressed
        findViewById(R.id.buttonChangeReqWorkExperienceDelete).setOnClickListener(
                new View.OnClickListener() {
                    /**
                     * Called when the delete button has been clicked.
                     * @param v The view that was clicked.
                     */
                    @Override
                    public void onClick(View v) {
                        //use dialog builder to create a final warning message to the user
                        new AlertDialog.Builder(ChangeReqWorkExpDetailsActivity.this)
                                .setCancelable(false)
                                .setTitle("Delete Work Experience Confirmation")
                                .setMessage("Are you sure you want to delete this Work Experience?")
                                .setPositiveButton("Yes",
                                        new DialogInterface.OnClickListener(){
                                            public void onClick (DialogInterface dialog,int id) {
                                                presenter.onDelete(eduPosition);
                                            }})
                                .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener(){
                                            public void onClick (DialogInterface dialog,int id) {
                                                // do nothing
                                            }}).create().show();
                    }
                }
        );

        //when save button is pressed
        findViewById(R.id.buttonChangeReqWorkExpSave).setOnClickListener(
                new View.OnClickListener() {
                    /**
                     * Called when the save button has been clicked.
                     * @param v The view that was clicked.
                     */
                    @Override
                    public void onClick(View v) {
                        presenter.onSave(eduPosition);
                    }
                }
        );


        //show the existing values to spinners and edit text fields
        WorkExperience currWorkExp = currJob.getReqWorkExperience().get(eduPosition);

        ((EditText)findViewById(R.id.editTextChangeReqWorkExperienceDescription)).setText(currWorkExp.getDescription());
        expFieldSpinner.setSelection((expFields.indexOf(currWorkExp.getExpArea().getArea())));
        YearsATWork.setSelection(YearsFields.indexOf(currWorkExp.getYears()));

        // when back button is pressed
        findViewById(R.id.backbuttonChangeReqWorkExp).setOnClickListener(
                new View.OnClickListener(){
                    /**
                     * Called when the back button has been clicked.
                     * @param v The view that was clicked.
                     */
                    public void onClick(View v){
                        Intent intent = new Intent(ChangeReqWorkExpDetailsActivity.this, EditReqWorkExperienceActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );

    }

    /**
     * This method gets the description entered by the user in the EditText field.
     * @return The description entered by the user.
     */
    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.editTextChangeReqWorkExperienceDescription)).getText().toString().trim();
    }

    /**
     * This method gets the selected expertise area from the spinner.
     * @return The position of the selected expertise area in the spinner.
     */
    @Override
    public int getExpertiseArea() {
        //get position in respective list
        return ((Spinner)findViewById(R.id.spinnerChangeReqWorkExpDetailsExpArea)).getSelectedItemPosition();
    }

    /**
     * This method gets the selected number of years from the spinner.
     * @return The position of the selected number of years in the spinner.
     */
    @Override
    public int getYears() {
        //get position in respective enum ordinal
        return ((Spinner)findViewById(R.id.spinnerChangeReqWorkExpYears)).getSelectedItemPosition();
    }

    /**
     * This method is called when a required work experience is successfully deleted.
     * It shows an alert dialog with a success message and an option to return to the Change Job Details activity.
     * @param message The success message to be displayed.
     * @param userToken The token of the user.
     * @param job The job object.
     */
    @Override
    public void successfulDelete(String message, String userToken, Job job) {
        new AlertDialog.Builder(ChangeReqWorkExpDetailsActivity.this)
                .setCancelable(false)
                .setTitle("Deletion Completed!")
                .setMessage(message)

                .setPositiveButton("Return to Change Job Details",
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(ChangeReqWorkExpDetailsActivity.this, ChangeJobDetailsActivity.class);
                                intent.putExtra("token", userToken);
                                intent.putExtra("job", job);
                                startActivity(intent);
                            }}).create().show();
    }

    /**
     * This method is called when a required work experience is successfully saved.
     * It shows an alert dialog with a success message and an option to return to the Change Job Details activity.
     * @param message The success message to be displayed.
     * @param userToken The token of the user.
     * @param job The job object.
     */
    @Override
    public void successfulSave(String message, String userToken, Job job) {
        new AlertDialog.Builder(ChangeReqWorkExpDetailsActivity.this)
                .setCancelable(false)
                .setTitle("Save Completed!")
                .setMessage(message)

                .setPositiveButton("Return to Change Job Details",
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(ChangeReqWorkExpDetailsActivity.this, ChangeJobDetailsActivity.class);
                                intent.putExtra("token", userToken);
                                intent.putExtra("job", job);
                                startActivity(intent);
                            }}).create().show();
    }
}
