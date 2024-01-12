package com.example.networkmeup.view.EditAccountEmployee.ShowApplicationsEmployee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.utils.RecyclerViewAdapters.EmployeeApplicationRecyclerViewAdapter;
import com.example.networkmeup.view.EditAccountEmployee.EditAccountEmployeeActivity;

import java.util.ArrayList;
/**
 * Activity class for showing applications associated with an employee.
 * <p>
 * This class is responsible for rendering the UI that displays a list of applications
 * linked to a specific employee. It utilizes a RecyclerView to show these applications.
 * </p>
 */
public class ShowApplicationsEmployeeActivity extends AppCompatActivity implements ShowApplicationsEmployeeView{
    private Employee currEmployee;
    /**
     * Called when the activity is starting. This is where most initialization should go.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being
     *                           shut down then this Bundle contains the data it most recently
     *                           supplied in onSaveInstanceState(Bundle).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_applications_employee);
        Bundle extras = getIntent().getExtras();

        final String userEmail;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        else{
            userEmail = null;
        }

        final ShowApplicationsEmployeePresenter presenter = new ShowApplicationsEmployeePresenter(this,userEmail);
        //get employee data to pass to recycler view
        ArrayList<Application> ApplicationList = presenter.getApplications();
        //get recycler view reference
        RecyclerView recyclerView = findViewById(R.id.recyclerViewEditAccountEmployee);

        //create Adapter
        EmployeeApplicationRecyclerViewAdapter applicationRecycler = new EmployeeApplicationRecyclerViewAdapter(this,ApplicationList);
        recyclerView.setAdapter(applicationRecycler);

        //Set the layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // when back button is pressed
        findViewById(R.id.backbuttonShowApplicationsEmployee).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(ShowApplicationsEmployeeActivity.this, EditAccountEmployeeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }
}