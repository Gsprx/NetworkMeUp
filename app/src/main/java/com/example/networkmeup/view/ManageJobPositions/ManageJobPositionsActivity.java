package com.example.networkmeup.view.ManageJobPositions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.dao.EmployerDAO;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectEducationRecyclerViewAdapter;
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectJobsRecyclerViewAdapter;
import com.example.networkmeup.view.ManageJobPositions.AddNewJob.AddNewJobActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.AddNewEducation.AddNewEducationActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.ChangeEducationDetails.ChangeEducationDetailsActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.ModifyCVEditEducationActivity;

import java.util.ArrayList;

public class ManageJobPositionsActivity extends AppCompatActivity implements  ManageJobPositionsView{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_job_positions);

        Bundle extras = getIntent().getExtras();

        String userEmail = null;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }

        final ManageJobPositionsPresenter presenter = new ManageJobPositionsPresenter(this, userEmail);

        //get view references
        RecyclerView jobRecyclerView = findViewById(R.id.recyclerViewManageJobPositions);

        //get employer job data
        EmployerDAO employerDAO = new EmployerDAOMemory();
        Employer currEmployer = employerDAO.getByEmail(new Email(userEmail));
        ArrayList<Job> jobsList = currEmployer.getJobs();

        //create recycler view adapter
        SelectJobsRecyclerViewAdapter jobsAdapter = new SelectJobsRecyclerViewAdapter(this, jobsList);
        jobsAdapter.setClickListener(new SelectJobsRecyclerViewAdapter.ItemClickListener() {
            //click listener for rows in recycler view list
            @Override
            public void onItemClick(View view, int position) {
                presenter.onItemClick(jobsList.get(position));
            }
        });
        jobRecyclerView.setAdapter(jobsAdapter);
        jobRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        findViewById(R.id.btnManageJobPositionsAddJob).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.onAddNew();
                    }
                }
        );

    }

    @Override
    public void addNewJobPosition(String userToken) {
        Intent intent = new Intent(ManageJobPositionsActivity.this, AddNewJobActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }

    @Override
    public void changeJobPosition(String userToken, Job job) {
        Intent intent = new Intent(ManageJobPositionsActivity.this, ChangeJobDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }
}
