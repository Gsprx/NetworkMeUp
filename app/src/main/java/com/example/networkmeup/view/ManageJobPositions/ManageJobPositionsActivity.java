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
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectJobsRecyclerViewAdapter;
import com.example.networkmeup.view.HomeEmployer.HomeEmployerActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsActivity;
import com.example.networkmeup.view.SignUp.SignUpActivity;
import com.example.networkmeup.view.StartPage.StartPageActivity;

import java.util.ArrayList;

/**
 * This class represents an activity where job positions can be managed.
 * It extends AppCompatActivity and implements ManageJobPositionsView.
 */
public class ManageJobPositionsActivity extends AppCompatActivity implements  ManageJobPositionsView{
    /**
     * Called when the activity is starting.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle). Note: Otherwise it is null.
     */
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

        // Initialize presenter
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

        //when add new button is pressed
        findViewById(R.id.btnManageJobPositionsAddJob).setOnClickListener(
                new View.OnClickListener() {
                    /**
                     * Called when the add new button has been clicked.
                     * @param v The view that was clicked.
                     */
                    @Override
                    public void onClick(View v) {
                        presenter.onAddNew();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonMangeJobPositions).setOnClickListener(
                new View.OnClickListener(){
                    /**
                     * Called when the back button has been clicked.
                     * @param v The view that was clicked.
                     */
                    public void onClick(View v){
                        Intent intent = new Intent(ManageJobPositionsActivity.this, HomeEmployerActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );

    }

    /**
     * This method is called to add a new job position.
     * It starts a new ChangeJobDetailsActivity with a new job object.
     * @param userToken The token of the user.
     */
    @Override
    public void addNewJobPosition(String userToken) {
        Intent intent = new Intent(ManageJobPositionsActivity.this, ChangeJobDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", new Job("", ""));
        startActivity(intent);
    }

    /**
     * This method is called to change the details of a job.
     * It starts a new ChangeJobDetailsActivity with an existing job object.
     * @param userToken The token of the user.
     * @param job The job object.
     */
    @Override
    public void changeJobDetails(String userToken, Job job) {
        Intent intent = new Intent(ManageJobPositionsActivity.this, ChangeJobDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }
}

