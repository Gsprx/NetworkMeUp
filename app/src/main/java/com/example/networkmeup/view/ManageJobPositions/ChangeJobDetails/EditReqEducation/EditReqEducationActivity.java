package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectEducationRecyclerViewAdapter;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation.AddNewReqEducationActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.ChangeReqEducationDetails.ChangeReqEducationDetailsActivity;

import java.util.ArrayList;

public class EditReqEducationActivity extends AppCompatActivity implements EditReqEducationView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_req_education);

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

        final EditReqEducationPresenter presenter = new EditReqEducationPresenter(this, userEmail,currJob);

        //get job data to pass to recycler view
        ArrayList<Education> reqEducationList = currJob.getReqEducation();

        //get recycler view reference
        RecyclerView recyclerView = findViewById(R.id.recyclerViewEditReqEducation);
        //create recycler view adapter
        SelectEducationRecyclerViewAdapter adapter = new SelectEducationRecyclerViewAdapter(this, reqEducationList);
        adapter.setClickListener(new SelectEducationRecyclerViewAdapter.ItemClickListener() {
            //click listener for rows in recycler view list
            @Override
            public void onItemClick(View view, int position) {
                presenter.onItemClick(position);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //when add new button is pressed
        findViewById(R.id.btnEditReqEducationAddNew).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onAddNew();
                    }
                }
        );
    }

    @Override
    public void changeEductionDetails(String userToken, int position, Job job){
        Intent intent = new Intent(EditReqEducationActivity.this, ChangeReqEducationDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("position", position);
        intent.putExtra("job", job);
        startActivity(intent);
    }

    @Override
    public void addNewEducation(String userToken, Job job) {
        Intent intent = new Intent(EditReqEducationActivity.this, AddNewReqEducationActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }
}