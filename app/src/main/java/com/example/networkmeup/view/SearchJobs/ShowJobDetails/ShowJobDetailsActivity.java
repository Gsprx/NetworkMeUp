package com.example.networkmeup.view.SearchJobs.ShowJobDetails;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.utils.RecyclerViewAdapters.EducationRecyclerViewAdapter;
import com.example.networkmeup.utils.RecyclerViewAdapters.LanguageKnowledgeRecyclerViewAdapter;
import com.example.networkmeup.utils.RecyclerViewAdapters.WorkExperienceRecyclerViewAdapter;
import com.example.networkmeup.view.SearchJobs.SearchJobsActivity;

public class ShowJobDetailsActivity extends AppCompatActivity implements  ShowJobsDetailsView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_job_details);

        Bundle extras = getIntent().getExtras();

        String userEmail = null;
        Job currJob = null;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
            currJob = (Job)extras.getSerializable("job");
        }

        final ShowJobDetailsPresenter presenter = new ShowJobDetailsPresenter(this, userEmail, currJob);

        //get Job basic information Text fields as references
        TextView jobTitle = findViewById(R.id.textShowJobDetailsTitle);
        TextView jobDescription = findViewById(R.id.textShowJobDetailsDescription);
        TextView jobAvailability = findViewById(R.id.textShowJobDetailsAvailability);


        //set proper text for job's basic information
        jobTitle.setText(currJob.getTitle());
        jobDescription.setText(currJob.getDescription());
        jobAvailability.setText(currJob.getAvailability().toString());

        //get recycler views as references
        RecyclerView reqEducation = findViewById(R.id.recyclerViewShowJobDetailsRequiredEducation);
        RecyclerView reqWorkExp = findViewById(R.id.recyclerViewShowJobDetailsRequiredWorkExp);
        RecyclerView reqLangKnow = findViewById(R.id.recyclerViewShowJobDetailsReqLangKnowledge);

        //create recycler view adapters for each
        EducationRecyclerViewAdapter eduAdapter = new EducationRecyclerViewAdapter(this, currJob.getReqEducation());
        WorkExperienceRecyclerViewAdapter workExpAdapter = new WorkExperienceRecyclerViewAdapter(this, currJob.getReqWorkExperience());
        LanguageKnowledgeRecyclerViewAdapter langKnowAdapter = new LanguageKnowledgeRecyclerViewAdapter(this, currJob.getReqLanguageKnowledge());

        //set each adapter to respective recycler views
        reqEducation.setAdapter(eduAdapter);
        reqEducation.setLayoutManager(new LinearLayoutManager(this));

        reqWorkExp.setAdapter(workExpAdapter);
        reqWorkExp.setLayoutManager(new LinearLayoutManager(this));

        reqLangKnow.setAdapter(langKnowAdapter);
        reqLangKnow.setLayoutManager(new LinearLayoutManager(this));


        //when send application button is clicked
        findViewById(R.id.btnShowJobDetailsSendApplication).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //when send application is clicked, create a confirmation dialog
                        new AlertDialog.Builder(ShowJobDetailsActivity.this)
                                .setCancelable(false)
                                .setTitle("Send Application Confirmation")
                                .setMessage("Are you sure you wish to apply to this job?")
                                .setPositiveButton("Yes",
                                        new DialogInterface.OnClickListener(){
                                            public void onClick (DialogInterface dialog,int id) {
                                                //pass the work to the presenter
                                                presenter.onSendApplication();
                                            }})
                                .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener(){
                                            public void onClick (DialogInterface dialog,int id) {
                                                //do nothing
                                            }}).create().show();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonShowJobDetails).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(ShowJobDetailsActivity.this, SearchJobsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public void sendApplicationSuccess(String userToken) {
        new AlertDialog.Builder(ShowJobDetailsActivity.this)
                .setCancelable(false)
                .setTitle("Success!")
                .setMessage("Your application was successfully created!")
                .setPositiveButton("Return to Search Jobs",
                        new DialogInterface.OnClickListener(){
                            public void onClick (DialogInterface dialog,int id) {
                                Intent intent = new Intent(ShowJobDetailsActivity.this, SearchJobsActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }

    @Override
    public String getCoverLetter() {
        return ((EditText)findViewById(R.id.editTextShowJobDetailsCoverLetter)).getText().toString().trim();
    }

    @Override
    public void emptyCoverLetter(String message) {
        new AlertDialog.Builder(ShowJobDetailsActivity.this)
                .setCancelable(true)
                .setTitle("Error!")
                .setMessage(message)
                .setNeutralButton("Cancel",
                        new DialogInterface.OnClickListener(){
                            public void onClick (DialogInterface dialog,int id) {
                                //do nothing
                            }}).create().show();
    }
}