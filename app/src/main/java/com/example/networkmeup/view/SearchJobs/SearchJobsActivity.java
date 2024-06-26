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
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectJobsRecyclerViewAdapter;
import com.example.networkmeup.view.HomeEmployee.HomeEmployeeActivity;
import com.example.networkmeup.view.SearchJobs.ShowJobDetails.ShowJobDetailsActivity;

import java.util.ArrayList;

public class SearchJobsActivity extends AppCompatActivity implements SearchJobsView{

    SelectJobsRecyclerViewAdapter adapter;
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

        //create recycler view adapter if null
        if(adapter == null) {
            adapter = new SelectJobsRecyclerViewAdapter(this, matchingJobs);
            adapter.setClickListener(new SelectJobsRecyclerViewAdapter.ItemClickListener() {
                //click listener for rows in recycler view list
                @Override
                public void onItemClick(View view, int position) {
                    presenter.onItemClick(matchingJobs.get(position));
                }
            });
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        //update the adapter list if it exists already
        else{
            adapter.updateList(matchingJobs);
        }
        // when back button is pressed
        findViewById(R.id.backbuttonSearchJobs).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(SearchJobsActivity.this, HomeEmployeeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );

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