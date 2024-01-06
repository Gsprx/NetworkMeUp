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

import java.util.ArrayList;

public class ChangeJobDetailsActivity extends AppCompatActivity implements ChangeJobDetailsView{

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
    }

    @Override
    public String getJobDescription() {
        return ((EditText)findViewById(R.id.editTextChangeJobDetailsDescription)).getText().toString().trim();
    }

    @Override
    public String getJobTitle() {
        return ((EditText)findViewById(R.id.editTextChangeJobDetailsTitle)).getText().toString().trim();
    }

    @Override
    public int getAvailability() {
        return ((Spinner)findViewById(R.id.spinnerChangeJobDetailsAvailability)).getSelectedItemPosition();
    }

    @Override
    public void editEducation(Job job, String userToken) {
        Intent intent = new Intent(ChangeJobDetailsActivity.this, EditReqEducationActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }

    @Override
    public void editWorkExperience(Job job, String userToken) {
        Intent intent = new Intent(ChangeJobDetailsActivity.this, EditReqWorkExperienceActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }

    @Override
    public void editLangKnowledge(Job job, String userToken) {
        Intent intent = new Intent(ChangeJobDetailsActivity.this, EditReqLangKnowledgeActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }

    @Override
    public void successfulDelete(String userToken) {
        new AlertDialog.Builder(ChangeJobDetailsActivity.this)
                .setCancelable(false)
                .setTitle("Deletion Success")
                .setMessage("Job was successfully deleted!")
                .setPositiveButton("Return to Manage Job Positions",
                        new DialogInterface.OnClickListener(){
                            public void onClick (DialogInterface dialog,int id) {
                                Intent intent = new Intent(ChangeJobDetailsActivity.this, ManageJobPositionsActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }

    @Override
    public void successfulSave(String userToken) {
        new AlertDialog.Builder(ChangeJobDetailsActivity.this)
                .setCancelable(false)
                .setTitle("Save Success")
                .setMessage("Job was successfully saved!")
                .setPositiveButton("Return to Manage Job Positions",
                        new DialogInterface.OnClickListener(){
                            public void onClick (DialogInterface dialog,int id) {
                                Intent intent = new Intent(ChangeJobDetailsActivity.this, ManageJobPositionsActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }


}