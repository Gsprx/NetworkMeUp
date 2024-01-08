package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;

import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.WorkExperience;
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectWorkExperienceRecyclerViewAdapter;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.AddNewReqWorkExperience.AddNewReqWorkExperienceActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqWorkExperience.ChangeReqWorkExpDetails.ChangeReqWorkExpDetailsActivity;

import java.util.ArrayList;

public class EditReqWorkExperienceActivity extends AppCompatActivity implements EditReqWorkExperienceView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_req_work_experience);
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

        final EditReqWorkExperiencePresenter presenter = new EditReqWorkExperiencePresenter(this, userEmail,currJob);

        //get job data to pass to recycler view
        ArrayList<WorkExperience> reqWOrkExpList = currJob.getReqWorkExperience();

        //get recycler view reference
        RecyclerView recyclerView = findViewById(R.id.EditReqWorkExpRecyclerView);
        //create recycler view adapter
        SelectWorkExperienceRecyclerViewAdapter adapter = new SelectWorkExperienceRecyclerViewAdapter(this, reqWOrkExpList);
        adapter.setClickListener(new SelectWorkExperienceRecyclerViewAdapter.ItemClickListener() {
            //click listener for rows in recycler view list
            @Override
            public void onItemClick(View view, int position) {
                presenter.onItemClick(position);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //when add new button is pressed
        findViewById(R.id.EditReqWorkExpAddNewButton).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onAddNew();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonEditReqWorkExperience).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(EditReqWorkExperienceActivity.this, ChangeJobDetailsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    public void changeWorkExperienceDetails(String userToken, int position, Job job){
        Intent intent = new Intent(EditReqWorkExperienceActivity.this, ChangeReqWorkExpDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("position", position);
        intent.putExtra("job", job);
        startActivity(intent);
    }

    @Override
    public void addNewWorkExperience(String userToken, Job job) {
        Intent intent = new Intent(EditReqWorkExperienceActivity.this, AddNewReqWorkExperienceActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }
}

