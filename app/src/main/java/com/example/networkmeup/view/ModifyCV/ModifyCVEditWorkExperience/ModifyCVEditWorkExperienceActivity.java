package com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.domain.Education;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.WorkExperience;
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectWorkExperienceRecyclerViewAdapter;
import com.example.networkmeup.view.ModifyCV.ModifyCVActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.AddNewWorkExperience.AddNewWorkExperienceActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.ChangeWorkExperienceDetails.ChangeWorkExperienceDetailsActivity;

import java.util.ArrayList;
/**
 * Activity for editing work experience in a user's CV.
 * This activity provides the interface for users to modify, add, or delete their work experiences.
 */
public class ModifyCVEditWorkExperienceActivity extends AppCompatActivity implements ModifyCVEditWorkExperienceView {
    /**
     * Called when the activity is starting. This is where most initialization should go.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down,
     *                           this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     *                           Otherwise, it is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_cv_edit_work_experience);
        Bundle extras = getIntent().getExtras();

        final String userEmail;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        else{
            userEmail = null;
        }

        final ModifyCVEditWorkExperiencePresenter presenter = new ModifyCVEditWorkExperiencePresenter(this, userEmail);

        //get employee data to pass to recycler view
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userEmail));
        ArrayList<WorkExperience> workexpList = currEmployee.getCV().getWorkExperiences();

        //get recycler view reference
        RecyclerView recyclerView = findViewById(R.id.recyclerViewModifyCVEditWorkExperience);
        //create recycler view adapter
        SelectWorkExperienceRecyclerViewAdapter adapter = new SelectWorkExperienceRecyclerViewAdapter(this, workexpList);
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
        findViewById(R.id.btnModifyCVEditWorkExperienceAddNew).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //When Login button is pressed
                        presenter.onAddNew();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonModifyCVEditWorkExperience).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(ModifyCVEditWorkExperienceActivity.this, ModifyCVActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }

    /**
     * Handles the action to change the details of a work experience.
     * This method is invoked when a work experience item is selected for editing.
     * @param userToken The unique token identifying the user.
     * @param position
    The position of the work experience item in the list.
     */
    @Override
    public void changeWorkExperienceDetails(String userToken, int position){
        Intent intent = new Intent(ModifyCVEditWorkExperienceActivity.this, ChangeWorkExperienceDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("position", position);
        startActivity(intent);
    }
    /**
     * Initiates the process to add a new work experience.
     * This method is called when the user chooses to add a new work experience to their CV.
     * @param userToken The unique token identifying the user.
     */
    @Override
    public void addNewWorkExperience(String userToken) {
        Intent intent = new Intent(ModifyCVEditWorkExperienceActivity.this, AddNewWorkExperienceActivity.class);
        intent.putExtra("token", userToken);
        startActivity(intent);
    }

}