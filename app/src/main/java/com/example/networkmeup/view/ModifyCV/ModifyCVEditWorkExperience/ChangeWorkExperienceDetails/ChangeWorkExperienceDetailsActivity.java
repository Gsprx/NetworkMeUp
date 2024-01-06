package com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.ChangeWorkExperienceDetails;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.networkmeup.R;
import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.ExpertiseAreaDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.LevelOfStudies;
import com.example.networkmeup.view.ModifyCV.ModifyCVActivity;
import java.util.ArrayList;


public class ChangeWorkExperienceDetailsActivity extends AppCompatActivity implements ChangeWorkExperienceDetailsView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_work_experience_details);

        Bundle extras = getIntent().getExtras();

        final String userEmail;
        final int workExpPosition;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
            //obtain position in list
            workExpPosition = extras.getInt("position");
        }
        else{
            userEmail = null;
            workExpPosition = 0;
        }

        final ChangeWorkExperienceDetailsPresenter presenter = new ChangeWorkExperienceDetailsPresenter(this, userEmail);

        //create spinner declarations
        Spinner expFieldSpinner = findViewById(R.id.spinnerChangeWorkExperienceDetailsSelectExpField);
        Spinner yearsatworkSpinner = findViewById(R.id.spinnerChangeWorkExperienceDetailsSelectYearsAtWork);

        ArrayList<Integer> yearsatwork = new ArrayList<>();
        ArrayList<String> expFields = new ArrayList<>();

        //create spinner list for years at work
        for(int i = 0; i<=15; i++){
            yearsatwork.add(i);
        }

        //create spinner list for exp fields
        ExpertiseAreaDAO expAreaDAO = new ExpertiseAreaDAOMemory();
        ArrayList<ExpertiseArea> expertiseAreas = expAreaDAO.getAll();
        for(ExpertiseArea expertiseArea : expertiseAreas){
            expFields.add(expertiseArea.getArea());
        }

        //pass adapter to spinners and define behavior
        ArrayAdapter<Integer> yearsatworkAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_dropdown_item, yearsatwork);
        yearsatworkSpinner.setAdapter(yearsatworkAdapter);

        yearsatworkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int selectedYearsAtWork = yearsatwork.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });

        ArrayAdapter<String> expFieldsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, expFields);
        expFieldSpinner.setAdapter(expFieldsAdapter);

        //when delete button is pressed
        findViewById(R.id.btnChangeWorkingExperienceDetailsDelete).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //use dialog builder to create a final warning message to the user
                        new AlertDialog.Builder(ChangeWorkExperienceDetailsActivity.this)
                                .setCancelable(false)
                                .setTitle("Delete work experience Confirmation")
                                .setMessage("Are you sure you want to delete this work experience?")
                                .setPositiveButton("Yes",
                                        new DialogInterface.OnClickListener(){
                                            public void onClick (DialogInterface dialog,int id) {
                                                presenter.onDelete(workExpPosition);
                                            }})
                                .setNegativeButton("Cancel",
                                        new DialogInterface.OnClickListener(){
                                            public void onClick (DialogInterface dialog,int id) {
                                                // do nothing
                                            }}).create().show();
                    }
                }
        );

        //when save button is pressed
        findViewById(R.id.btnChangeWorkingExperienceDetailsSave).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.onSave(workExpPosition);
                    }
                }
        );

        //show the existing values to spinners and edit text fields
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userEmail));

        ((EditText)findViewById(R.id.editTextChangeWorkingExperienceDetailsDescription)).setText(currEmployee.getCV().getWorkExperiences().get(workExpPosition).getDescription());
        expFieldSpinner.setSelection((expFields.indexOf(currEmployee.getCV().getWorkExperiences().get(workExpPosition).getExpArea().getArea())));
        yearsatworkSpinner.setSelection(yearsatwork.indexOf(currEmployee.getCV().getWorkExperiences().get(workExpPosition).getYears()+""));

    }

    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.editTextChangeWorkingExperienceDetailsDescription)).getText().toString().trim();
    }

    @Override
    public int getExpertiseArea() {
        //get position in respective list
        return ((Spinner)findViewById(R.id.spinnerChangeWorkExperienceDetailsSelectExpField)).getSelectedItemPosition();
    }

    @Override
    public int getYearsAtWork() {
        //get position in respective enum ordinal
        return ((Spinner)findViewById(R.id.spinnerChangeWorkExperienceDetailsSelectYearsAtWork)).getSelectedItemPosition();
    }

    @Override
    public void successfulDelete(String message, String userToken) {
        new AlertDialog.Builder(ChangeWorkExperienceDetailsActivity.this)
                .setCancelable(false)
                .setTitle("Deletion Completed!")
                .setMessage(message)

                //return back to edit work experience view when pressed
                .setPositiveButton("Return to Modify CV",
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(ChangeWorkExperienceDetailsActivity.this, ModifyCVActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }

    @Override
    public void successfulSave(String message, String userToken) {
        new AlertDialog.Builder(ChangeWorkExperienceDetailsActivity.this)
                .setCancelable(false)
                .setTitle("Save Completed!")
                .setMessage(message)

                //return back to work experience view when pressed
                .setPositiveButton("Return to Modify CV",
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(ChangeWorkExperienceDetailsActivity.this, ModifyCVActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }
}
