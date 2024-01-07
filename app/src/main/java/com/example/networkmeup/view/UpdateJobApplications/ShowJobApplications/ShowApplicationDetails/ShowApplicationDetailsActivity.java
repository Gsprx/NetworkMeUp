package com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowApplicationDetails;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.utils.RecyclerViewAdapters.EducationRecyclerViewAdapter;
import com.example.networkmeup.utils.RecyclerViewAdapters.LanguageKnowledgeRecyclerViewAdapter;
import com.example.networkmeup.utils.RecyclerViewAdapters.WorkExperienceRecyclerViewAdapter;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowJobApplicationsActivity;
import com.example.networkmeup.view.UpdateJobApplications.UpdateJobApplicationsActivity;

public class ShowApplicationDetailsActivity extends AppCompatActivity implements ShowApplicationDetailsView{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_application_details);

        Bundle extras = getIntent().getExtras();

        String userEmail;
        Job currJob;
        int applicationPosition;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
            currJob = (Job) extras.getSerializable("job");
            applicationPosition = extras.getInt("position");
        }
        else{
            userEmail = null;
            currJob = null;
            applicationPosition = -1;
        }
        final ShowApplicationDetailsPresenter presenter = new ShowApplicationDetailsPresenter(this,userEmail,currJob,applicationPosition);

        //get application reference
        Application application = currJob.getApplications().get(applicationPosition);

        //get applicant reference
        Employee applicant = application.getEmployee();

        //show proper text to all text fields
        ((TextView)findViewById(R.id.textShowApplicationDetailsName)).setText(applicant.getName());
        ((TextView)findViewById(R.id.textShowApplicationDetailsEmail)).setText(applicant.getEmail().getAddress());
        ((TextView)findViewById(R.id.textShowApplicationDetailsPhone)).setText(applicant.getPhone().getNumber());
        ((TextView)findViewById(R.id.textShowApplicationDetailsAddress)).setText(applicant.getAddress());
        ((TextView)findViewById(R.id.textShowApplicationDetailsCoverLetter)).setText(application.getCoverLetter());
        ((TextView)findViewById(R.id.textShowApplicationDetailsID)).setText(String.valueOf(application.getID()));
        ((TextView)findViewById(R.id.textShowApplicationDetailsSkillset)).setText(applicant.getCV().getAdditionalSkillset());

        //get recycler view references
        RecyclerView educationRV = findViewById(R.id.recyclerViewShowApplicationDetailsEducation);
        RecyclerView workExpRV = findViewById(R.id.recyclerViewShowApplicationDetailsWorkExp);
        RecyclerView langKnowRV = findViewById(R.id.recyclerViewShowApplicationDetailsLangKnow);

        //set up recycler view adapters
        EducationRecyclerViewAdapter eduAdapter = new EducationRecyclerViewAdapter(this, applicant.getCV().getEducation());
        WorkExperienceRecyclerViewAdapter workExpAdapter = new WorkExperienceRecyclerViewAdapter(this, applicant.getCV().getWorkExperiences());
        LanguageKnowledgeRecyclerViewAdapter langKnowAdapter = new LanguageKnowledgeRecyclerViewAdapter(this, applicant.getCV().getLanguageKnowledge());

        //set adapters to recycler views
        educationRV.setAdapter(eduAdapter);
        educationRV.setLayoutManager(new LinearLayoutManager(this));
        workExpRV.setAdapter(workExpAdapter);
        workExpRV.setLayoutManager(new LinearLayoutManager(this));
        langKnowRV.setAdapter(langKnowAdapter);
        langKnowRV.setLayoutManager(new LinearLayoutManager(this));

        //button listeners
        //when accept applicant is pressed
        findViewById(R.id.btnShowApplicationDetailsAccept).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        new AlertDialog.Builder(ShowApplicationDetailsActivity.this)
                                .setCancelable(false)
                                .setTitle("Warning!")
                                .setMessage("You are about to accept this applicant to your job, this decision cannot be changed later. Continue?")

                                //return back to edit education view when pressed
                                .setPositiveButton("Accept",
                                        new DialogInterface.OnClickListener(){

                                            public void onClick (DialogInterface dialog,int id) {
                                                presenter.onAccept();
                                            }})
                                .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener(){

                                            public void onClick (DialogInterface dialog,int id) {
                                                //do nothing
                                            }}).create().show();
                    }
                }
        );
        //when reject applicant is pressed
        findViewById(R.id.btnShowApplicationDetailsReject).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        new AlertDialog.Builder(ShowApplicationDetailsActivity.this)
                                .setCancelable(false)
                                .setTitle("Warning!")
                                .setMessage("You are about to reject this applicant to your job, this decision cannot be changed later. Continue?")

                                //return back to edit education view when pressed
                                .setPositiveButton("Reject",
                                        new DialogInterface.OnClickListener(){

                                            public void onClick (DialogInterface dialog,int id) {
                                                presenter.onReject();
                                            }})
                                .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener(){

                                            public void onClick (DialogInterface dialog,int id) {
                                                //do nothing
                                            }}).create().show();
                    }
                }
        );
    }
    @Override
    public void acceptedApplicant(String userToken, Job job){
        Intent intent = new Intent(ShowApplicationDetailsActivity.this, ShowJobApplicationsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }
    @Override
    public void rejectedApplicant(String userToken, Job job){
        Intent intent = new Intent(ShowApplicationDetailsActivity.this, ShowJobApplicationsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }
}