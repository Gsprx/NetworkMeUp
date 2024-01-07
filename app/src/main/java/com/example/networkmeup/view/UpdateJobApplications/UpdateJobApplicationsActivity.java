package com.example.networkmeup.view.UpdateJobApplications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectJobsRecyclerViewAdapter;
import com.example.networkmeup.view.UpdateJobApplications.ShowJobApplications.ShowJobApplicationsActivity;

import java.util.ArrayList;

public class UpdateJobApplicationsActivity extends AppCompatActivity implements UpdateJobApplicationsView{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_job_applications);

        Bundle extras = getIntent().getExtras();

        String userEmail = null;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        final UpdateJobApplicationsPresenter presenter = new UpdateJobApplicationsPresenter(this ,userEmail);

        RecyclerView jobsRecyclerView= findViewById(R.id.recyclerViewUpdateJobApplications);

        ArrayList<Job> jobsList = new EmployerDAOMemory().getByEmail(new Email(userEmail)).getJobs();

        SelectJobsRecyclerViewAdapter adapter = new SelectJobsRecyclerViewAdapter(this, jobsList);
        adapter.setClickListener(
            new SelectJobsRecyclerViewAdapter.ItemClickListener() {
                //click listener for rows in recycler view list
                @Override
                public void onItemClick(View view, int position) {
                    presenter.onItemClick(jobsList.get(position));
                }
            });
        jobsRecyclerView.setAdapter(adapter);
        jobsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    //start show job applications activity
    @Override
    public void showJobApplications(String userToken, Job job) {
        Intent intent = new Intent(UpdateJobApplicationsActivity.this, ShowJobApplicationsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }
}
