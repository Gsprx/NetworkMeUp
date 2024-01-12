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
import com.example.networkmeup.view.ModifyCV.ModifyCVEditWorkExperience.ModifyCVEditWorkExperienceActivity;

import java.util.ArrayList;
/**
 * This activity allows the user to change the details of their work experience in their CV.
 * It provides functionality to edit, save, and delete specific work experience entries.
 */

public class ChangeWorkExperienceDetailsActivity extends AppCompatActivity implements ChangeWorkExperienceDetailsView {
    /**
     * Called when the activity is starting. This is where most initialization should go:
     * calling setContentView(int) to inflate the activity's UI, using findViewById(int)
     * to programmatically interact with widgets in the UI, setting up listeners, etc.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously
     *                           being shut down then this Bundle contains the data it most
     *                           recently supplied in onSaveInstanceState(Bundle). Otherwise, it is null.
     */
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
        for(int i = 1; i<=15; i++){
            yearsatwork.add(i);
        }

        //create spinner list for exp fields
        ExpertiseAreaDAO expAreaDAO = new ExpertiseAreaDAOMemory();
        ArrayList<ExpertiseArea> expertiseAreas = expAreaDAO.getAll();
        for(ExpertiseArea expertiseArea : expertiseAreas){
            expFields.add(expertiseArea.getArea());
        }

        //pass adapter to spinners and define behavior
        ArrayAdapter<Integer> yearsatworkAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, yearsatwork);
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
        yearsatworkSpinner.setSelection(yearsatwork.indexOf(currEmployee.getCV().getWorkExperiences().get(workExpPosition).getYears()));
        // when back button is pressed
        findViewById(R.id.backbuttonChangeWorkExperienceDetails).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(ChangeWorkExperienceDetailsActivity.this, ModifyCVEditWorkExperienceActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );

    }
    /**
     * Retrieves the description entered by the user in the EditText field.
     *
     * @return A String representing the description of the work experience.
     */
    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.editTextChangeWorkingExperienceDetailsDescription)).getText().toString().trim();
    }
    /**
     * Retrieves the selected position of the expertise area from the spinner.
     *
     * @return An int representing the position of the selected expertise area in the spinner.
     */
    @Override
    public int getExpertiseArea() {
        //get position in respective list
        return ((Spinner)findViewById(R.id.spinnerChangeWorkExperienceDetailsSelectExpField)).getSelectedItemPosition();
    }
    /**
     * Retrieves the selected number of years at work from the spinner.
     *
     * @return An int representing the position of the selected years at work in the spinner.
     */
    @Override
    public int getYearsAtWork() {
        //get position in respective enum ordinal
        return ((Spinner)findViewById(R.id.spinnerChangeWorkExperienceDetailsSelectYearsAtWork)).getSelectedItemPosition();
    }
    /**
     * Displays a dialog indicating successful deletion of work experience and navigates
     * the user back to the Modify CV screen.
     *
     * @param

     * @param message   The message to be displayed in the dialog.
     * @param userToken The user token used to identify the current user.
     */
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
    /**
     * Displays a dialog indicating successful saving of work experience changes and
     * navigates the user back to the Modify CV screen.
     *
     * @param message   The message to be displayed in the dialog.
     * @param userToken The user token used to identify the current user.
     */
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
