package com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectEmployerApplicationRecyclerViewAdapter;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowApplicationDetails.ShowApplicationDetailsActivity;
import com.example.networkmeup.view.UpdateJobApplications.UpdateJobApplicationsActivity;

import java.util.ArrayList;

public class ShowJobApplicationsActivity extends AppCompatActivity implements ShowJobApplicationsView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_job_applications);

        Bundle extras = getIntent().getExtras();

        String userEmail;
        Job currJob;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
            currJob = (Job) extras.getSerializable("job");
        }
        else{
            userEmail = null;
            currJob = null;
        }

        final ShowJobApplicationsPresenter presenter = new ShowJobApplicationsPresenter(this, userEmail, currJob);

        ArrayList<Application> currApplications = currJob.getApplications();

        RecyclerView applicationRecyclerView = findViewById(R.id.recyclerViewShowJobApplications);

        SelectEmployerApplicationRecyclerViewAdapter adapter = new SelectEmployerApplicationRecyclerViewAdapter(this, currApplications);

        adapter.setClickListener(new SelectEmployerApplicationRecyclerViewAdapter.ItemClickListener() {
            //click listener for rows in recycler view list
            @Override
            public void onItemClick(View view, int position) {
                presenter.onItemClick(position);
            }
        });
        applicationRecyclerView.setAdapter(adapter);
        applicationRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // when back button is pressed
        findViewById(R.id.backbuttonShowJobApplications).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(ShowJobApplicationsActivity.this, UpdateJobApplicationsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }
    @Override
    public void showApplicationDetails(String userToken, Job job, int position){
        Intent intent = new Intent(ShowJobApplicationsActivity.this, ShowApplicationDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}