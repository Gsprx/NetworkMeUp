package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.Availability;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.domain.WorkExperience;
import com.example.networkmeup.utils.RecyclerViewAdapters.EducationRecyclerViewAdapter;
import com.example.networkmeup.utils.RecyclerViewAdapters.LanguageKnowledgeRecyclerViewAdapter;
import com.example.networkmeup.utils.RecyclerViewAdapters.WorkExperienceRecyclerViewAdapter;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.EditReqEducationActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.EditReqLangKnowledgeActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.EditReqWorkExperienceActivity;
import com.example.networkmeup.view.ManageJobPositions.ManageJobPositionsActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.ChangeEducationDetails.ChangeEducationDetailsActivity;
import com.example.networkmeup.view.SignUp.SignUpActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;

import java.util.ArrayList;

/**
 * The ChangeJobDetailsActivity class extends AppCompatActivity and implements the ChangeJobDetailsView interface.
 * This class is responsible for managing the change of job details.
 */
public class ChangeJobDetailsActivity extends AppCompatActivity implements ChangeJobDetailsView{

    /**
     * This method is called when the activity is starting. It is where most initialization happens.
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_job_details);

        Bundle extras = getIntent().getExtras();

        //use a pass-back job obj that stores all the progress made in the new job
        //the job obj will be updated and returned from the last in line activities

        final String userEmail;
        final Job currJob;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
            currJob = (Job) extras.getSerializable("job");
        }
        else{
            userEmail = null;
            currJob = null;
        }

        /**
         * Create a new instance of ChangeJobDetailsPresenter with the current activity, user email, current job.
         */
        final ChangeJobDetailsPresenter presenter = new ChangeJobDetailsPresenter(this, userEmail, currJob);

        //get job details so far (keep the lists updated as we add new requirements etc)
        ArrayList<Education> reqEducation = currJob.getReqEducation();
        ArrayList<WorkExperience> reqWorkExp = currJob.getReqWorkExperience();
        ArrayList<LanguageKnowledge> reqLangKnow = currJob.getReqLanguageKnowledge();

        //set edit text views to have existing basic details if job already has them

        //if the job is new, the strings for title and desc are "" (empty string) which displays the hint
        //if it exists, the edit text will auto-fill the previous data
        ((EditText)findViewById(R.id.editTextChangeJobDetailsDescription)).setText(currJob.getDescription());
        ((EditText)findViewById(R.id.editTextChangeJobDetailsTitle)).setText(currJob.getTitle());

        //get spinner
        Spinner availabilitySpinner = findViewById(R.id.spinnerChangeJobDetailsAvailability);

        //create spinner list
        ArrayList<String> availabilitiesList = new ArrayList<>();
        for (Availability avail : Availability.values()){
            availabilitiesList.add(avail.toString());
        }

        //set spinner adapter
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, availabilitiesList);
        availabilitySpinner.setAdapter(spinnerAdapter);

        //set previous value to spinner
        availabilitySpinner.setSelection(currJob.getAvailability().ordinal());

        //get recycler views
        RecyclerView reqEducationRecView = findViewById(R.id.recyclerViewChangeJobDetailsReqEducation);
        RecyclerView reqWorkExpRecView = findViewById(R.id.recyclerViewChangeJobDetailsReqWorkExperience);
        RecyclerView reqLangKnowRecView = findViewById(R.id.recyclerViewChangeJobDetailsReqLanguageKnowledge);

        //setup recycler view adapters
        EducationRecyclerViewAdapter eduAdapter = new EducationRecyclerViewAdapter(this, reqEducation);
        WorkExperienceRecyclerViewAdapter workAdapter = new WorkExperienceRecyclerViewAdapter(this ,reqWorkExp);
        LanguageKnowledgeRecyclerViewAdapter langAdapter = new LanguageKnowledgeRecyclerViewAdapter(this, reqLangKnow);

        //set adapters
        reqEducationRecView.setAdapter(eduAdapter);
        reqEducationRecView.setLayoutManager(new LinearLayoutManager(this));

        reqWorkExpRecView.setAdapter(workAdapter);
        reqWorkExpRecView.setLayoutManager(new LinearLayoutManager(this));

        reqLangKnowRecView.setAdapter(langAdapter);
        reqLangKnowRecView.setLayoutManager(new LinearLayoutManager(this));

        //button listeners
        //when edit education list is pressed
        findViewById(R.id.btnChangeJobDetailsEditEducation).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onEditEducation();
                    }
                }
        );

        //when edit work exp list is pressed
        findViewById(R.id.btnChangeJobDetailsEditWorkExp).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onEditWorkExperience();
                    }
                }
        );

        //when edit lang knowledge list is pressed
        findViewById(R.id.btnChangeJobDetailsEditLangKnow).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onEditLanguageKnowledge();
                    }
                }
        );

        //when save button is pressed
        findViewById(R.id.btnChangeJobDetailsSave).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onSave();
                    }
                }
        );
        //when delete button is pressed
        findViewById(R.id.btnChangeJobDetailsDelete).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //use dialog builder to create a final warning message to the user
                        new AlertDialog.Builder(ChangeJobDetailsActivity.this)
                                .setCancelable(false)
                                .setTitle("Delete Job Confirmation")
                                .setMessage("Are you sure you want to delete this Job?")
                                .setPositiveButton("Yes",
                                        new DialogInterface.OnClickListener(){
                                            public void onClick (DialogInterface dialog,int id) {
                                                presenter.onDelete();
                                            }})
                                .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener(){
                                            public void onClick (DialogInterface dialog,int id) {
                                                // do nothing
                                            }}).create().show();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonChangeJobDetails).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(ChangeJobDetailsActivity.this, ManageJobPositionsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }
    /**
     * Method to obtain job description from a text field.
     * @return String value of the job description typed by the user.
     */
    @Override
    public String getJobDescription() {
        return ((EditText)findViewById(R.id.editTextChangeJobDetailsDescription)).getText().toString().trim();
    }

    /**
     * Method to obtain job title from a text field.
     * @return String value of the job title typed by the user.
     */
    @Override
    public String getJobTitle() {
        return ((EditText)findViewById(R.id.editTextChangeJobDetailsTitle)).getText().toString().trim();
    }

    /**
     * Method to obtain availability from a spinner.
     * @return Integer value of the selected availability.
     */
    @Override
    public int getAvailability() {
        return ((Spinner)findViewById(R.id.spinnerChangeJobDetailsAvailability)).getSelectedItemPosition();
    }

    /**
     * Method to edit education details.
     * @param job Job object to be passed to next activity.
     * @param userToken User token to be passed to next activity.
     */
    @Override
    public void editEducation(Job job, String userToken) {
        Intent intent = new Intent(ChangeJobDetailsActivity.this, EditReqEducationActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }

    /**
     * Method to edit work experience details.
     * @param job Job object to be passed to next activity.
     * @param userToken User token to be passed to next activity.
     */
    @Override
    public void editWorkExperience(Job job, String userToken) {
        Intent intent = new Intent(ChangeJobDetailsActivity.this, EditReqWorkExperienceActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }

    /**
     * Method to edit language knowledge details.
     * @param job Job object to be passed to next activity.
     * @param userToken User token to be passed to next activity.
     */
    @Override
    public void editLangKnowledge(Job job, String userToken) {
        Intent intent = new Intent(ChangeJobDetailsActivity.this, EditReqLangKnowledgeActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }

    /**
     * Method for activity continuity after a successful delete.
     * @param userToken User token to be passed to next activity.
     */
    @Override
    public void successfulDelete(String userToken) {
        new AlertDialog.Builder(ChangeJobDetailsActivity.this)
                .setCancelable(false)
                .setTitle("Deletion Success")
                .setMessage("Job was successfully deleted!")
                .setPositiveButton("Return to Manage Job Positions",
                        new DialogInterface.OnClickListener(){
                            /**
                             * This method will be invoked when the positive button in the dialog is clicked.
                             * @param dialog The dialog that received the click.
                             * @param id The button that was clicked.
                             */
                            public void onClick (DialogInterface dialog,int id) {
                                Intent intent = new Intent(ChangeJobDetailsActivity.this, ManageJobPositionsActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }

    /**
     * Method for activity continuity after a successful save.
     * @param userToken User token to be passed to next activity.
     */
    @Override
    public void successfulSave(String userToken) {
        new AlertDialog.Builder(ChangeJobDetailsActivity.this)
                .setCancelable(false)
                .setTitle("Save Success")
                .setMessage("Job was successfully saved!")
                .setPositiveButton("Return to Manage Job Positions",
                        new DialogInterface.OnClickListener(){
                            /**
                             * This method will be invoked when the positive button in the dialog is clicked.
                             * @param dialog The dialog that received the click.
                             * @param id The button that was clicked.
                             */
                            public void onClick (DialogInterface dialog,int id) {
                                Intent intent = new Intent(ChangeJobDetailsActivity.this, ManageJobPositionsActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }
}