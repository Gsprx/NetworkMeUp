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
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.AddNewReqEducation.AddNewReqEducationActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqEducation.ChangeReqEducation.ChangeReqEducationActivity;

import java.util.ArrayList;

/**
 * The EditReqEducationActivity class extends AppCompatActivity and implements the EditReqEducationView interface.
 * This class is responsible for managing the editing of required education details.
 */
public class EditReqEducationActivity extends AppCompatActivity implements EditReqEducationView{

    /**
     * This method is called when the activity is starting. It is where most initialization happens.
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
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

        /**
         * Create a new instance of EditReqEducationPresenter with the current activity, user email, current job.
         */
        final EditReqEducationPresenter presenter = new EditReqEducationPresenter(this, userEmail,currJob);

        //get job data to pass to recycler view
        ArrayList<Education> reqEducationList = currJob.getReqEducation();

        //get recycler view reference
        RecyclerView recyclerView = findViewById(R.id.recyclerViewEditReqEducation);
        //create recycler view adapter
        SelectEducationRecyclerViewAdapter adapter = new SelectEducationRecyclerViewAdapter(this, reqEducationList);
        adapter.setClickListener(new SelectEducationRecyclerViewAdapter.ItemClickListener() {
            /**
             * Called when a row in the recycler view list has been clicked.
             * @param view The view that was clicked.
             * @param position The position of the view in the list.
             */
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
                    /**
                     * Called when the Add New button has been clicked.
                     * @param v The view that was clicked.
                     */
                    @Override
                    public void onClick(View v) {
                        presenter.onAddNew();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonEditReqEducation).setOnClickListener(
                new View.OnClickListener(){
                    /**
                     * Called when the Back button has been clicked.
                     * @param v The view that was clicked.
                     */
                    public void onClick(View v){
                        Intent intent = new Intent(EditReqEducationActivity.this, ChangeJobDetailsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }

    /**
     * Method to change education details.
     * @param userToken User token to be passed to next activity.
     * @param position The position of the education in the list.
     * @param job Job object to be passed after being updated.
     */
    @Override
    public void changeEductionDetails(String userToken, int position, Job job){
        Intent intent = new Intent(EditReqEducationActivity.this, ChangeReqEducationActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("position", position);
        intent.putExtra("job", job);
        startActivity(intent);
    }

    /**
     * Method to add new education.
     * @param userToken User token to be passed to next activity.
     * @param job Job object to be passed after being updated.
     */
    @Override
    public void addNewEducation(String userToken, Job job) {
        Intent intent = new Intent(EditReqEducationActivity.this, AddNewReqEducationActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }
}
