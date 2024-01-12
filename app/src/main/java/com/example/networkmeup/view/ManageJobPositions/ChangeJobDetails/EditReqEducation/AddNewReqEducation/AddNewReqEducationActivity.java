package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation;

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
import com.example.networkmeup.domain.LevelOfStudies;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.EditReqEducationActivity;

import java.util.ArrayList;

public class AddNewReqEducationActivity extends AppCompatActivity implements AddNewReqEducationView {

    /**
     * This method is called when the activity is starting. It is where most initialization happens.
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_req_education);
        Bundle extras = getIntent().getExtras();

        final String userEmail;
        final Job currJob;
        if (extras != null) {
            //obtain user token
            userEmail = extras.getString("token");
            currJob = (Job) extras.getSerializable("job");
        } else {
            userEmail = null;
            currJob = null;
        }

        /**
         * Create a new instance of AddNewReqEducationPresenter with the current activity, user email and current job.
         */
        final AddNewReqEducationPresenter presenter = new AddNewReqEducationPresenter(this, userEmail, currJob);

        //create spinner declarations
        Spinner expFieldSpinner = findViewById(R.id.spinnerAddNewReqEducationSelectExpField);
        Spinner lvlOfStudiesSpinner = findViewById(R.id.spinnerAddNewReqEducationSelectLevelOfStudies);

        ArrayList<String> levelsOfStudies = new ArrayList<>();
        ArrayList<String> expFields = new ArrayList<>();

        //create spinner list for levels of studies
        for (int i = 0; i < LevelOfStudies.values().length; i++) {
            levelsOfStudies.add(LevelOfStudies.values()[i].toString());
        }

        //create spinner list for exp fields
        ExpertiseAreaDAO expAreaDAO = new ExpertiseAreaDAOMemory();
        ArrayList<ExpertiseArea> expertiseAreas = expAreaDAO.getAll();
        for (ExpertiseArea expertiseArea : expertiseAreas) {
            expFields.add(expertiseArea.getArea());
        }

        //pass adapter to spinners and define behavior
        ArrayAdapter<String> levelsOfStudiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, levelsOfStudies);
        lvlOfStudiesSpinner.setAdapter(levelsOfStudiesAdapter);
        lvlOfStudiesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * Callback method to be invoked when an item in this view has been selected.
             *
             * @param parent   The AdapterView where the selection happened.
             * @param view     The view within the AdapterView that was clicked.
             * @param position The position of the view in the adapter.
             * @param id       The row id of the item that is selected.
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLvlOfStudies = levelsOfStudies.get(position);
            }

            /**
             * Callback method to be invoked when the selection disappears from this view.
             *
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
             *
             * @param parent   The AdapterView where the selection happened.
             * @param view     The view within the AdapterView that was clicked.
             * @param position The position of the view in the adapter.
             * @param id       The row id of the item that is selected.
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedExpField = expFields.get(position);
            }

            /**
             * Callback method to be invoked when the selection disappears from this view.
             *
             * @param parent The AdapterView that now contains no selected item.
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });

    //when add button is pressed
        findViewById(R.id.btnAddNewReqEducation).setOnClickListener(
                new View.OnClickListener() {
                    /**
                     * Called when the Add button has been clicked.
                     *
                     * @param v The view that was clicked.
                     */
                    @Override
                    public void onClick(View v) {
                        presenter.onAdd();
                    }
                }
        );

    // when back button is pressed
        findViewById(R.id.backbuttonAddNewReqEducation).setOnClickListener(
                new View.OnClickListener() {
                    /**
                     * Called when the Back button has been clicked.
                     *
                     * @param v The view that was clicked.
                     */
                    public void onClick(View v) {
                        Intent intent = new Intent(AddNewReqEducationActivity.this, EditReqEducationActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                });
    }

        /**
         * Method for activity continuity after a successful add
         * @param message Message sent by the presenter
         * @param userToken User token to be passed to next activity
         * @param job Job object to be passed after being updated
         */
        @Override
        public void successfulAdd (String message, String userToken, Job job){
            new AlertDialog.Builder(AddNewReqEducationActivity.this)
                    .setCancelable(false)
                    .setTitle("Creation Completed!")
                    .setMessage(message)

                    //return back to modify cv view when pressed
                    .setPositiveButton("Return to Change Job Details",
                            new DialogInterface.OnClickListener() {

                                /**
                                 * This method will be invoked when the positive button in the dialog is clicked.
                                 *
                                 * @param dialog The dialog that received the click.
                                 * @param id     The button that was clicked.
                                 */
                                public void onClick(DialogInterface dialog, int id) {

                                    Intent intent = new Intent(AddNewReqEducationActivity.this, ChangeJobDetailsActivity.class);
                                    intent.putExtra("token", userToken);
                                    intent.putExtra("job", job);
                                    startActivity(intent);
                                }
                            }).create().show();
        }

/**
 * Method to obtain description from a text field
 * @return String value of the description typed by the user
 */
        @Override
        public String getDescription () {
            return ((EditText) findViewById(R.id.editTextAddNewReqEducationDescription)).getText().toString().trim();
        }

/**
 * Method to obtain expertise area from a spinner
 * @return Integer value of the selected expertise area
 */
        @Override
        public int getExpertiseArea () {
            //get position in respective list
            return ((Spinner) findViewById(R.id.spinnerAddNewReqEducationSelectExpField)).getSelectedItemPosition();
        }

/**
 * Method to obtain level of studies from a spinner
 * @return Integer value of the selected level of studies
 */
        @Override
        public int getLevelOfStudies () {
            //get position in respective enum ordinal
            return ((Spinner) findViewById(R.id.spinnerAddNewReqEducationSelectLevelOfStudies)).getSelectedItemPosition();
        }
    }