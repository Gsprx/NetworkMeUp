package com.example.networkmeup.view.SearchJobs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.utils.RecyclerViewAdapters.SearchJobsRecyclerViewAdapter;
import com.example.networkmeup.view.HomeEmployee.HomeEmployeeActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.ModifyCVEditEducationActivity;
import com.example.networkmeup.view.SearchJobs.ShowJobDetails.ShowJobDetailsActivity;

import java.util.ArrayList;

public class SearchJobsActivity extends AppCompatActivity implements SearchJobsView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_jobs);

        Bundle extras = getIntent().getExtras();

        String userEmail = null;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        final SearchJobsPresenter presenter = new SearchJobsPresenter(this, userEmail);

        //when activity is created, obtain the matching jobs for the employee using the presenter
        ArrayList<Job> matchingJobs = presenter.onCreate();

        //get recycler view reference
        RecyclerView recyclerView = findViewById(R.id.recyclerViewSearchJobs);
        //create recycler view adapter
        SearchJobsRecyclerViewAdapter adapter = new SearchJobsRecyclerViewAdapter(this, matchingJobs);
        adapter.setClickListener(new SearchJobsRecyclerViewAdapter.ItemClickListener() {
            //click listener for rows in recycler view list
            @Override
            public void onItemClick(View view, int position) {
                presenter.onItemClick(matchingJobs.get(position));
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void noJobsFound(String message, String userToken) {
        new AlertDialog.Builder(SearchJobsActivity.this)
                .setCancelable(true)
                .setTitle("No jobs found!")
                .setMessage(message)

                //return back to edit education view when pressed
                .setPositiveButton("Return to Home Page",
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(SearchJobsActivity.this, HomeEmployeeActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }

    @Override
    public void showJobDetails(String userToken, Job job) {
        Intent intent = new Intent(SearchJobsActivity.this, ShowJobDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }
}