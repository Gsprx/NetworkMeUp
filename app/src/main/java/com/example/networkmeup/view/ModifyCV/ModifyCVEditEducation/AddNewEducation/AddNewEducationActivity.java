package com.example.networkmeup.view.ModifyCV.ModifyCVEditEducation.AddNewEducation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.networkmeup.R;
import com.example.networkmeup.dao.ExpertiseAreaDAO;
import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.LevelOfStudies;
import com.example.networkmeup.view.ModifyCV.ModifyCVActivity;

import java.util.ArrayList;

public class AddNewEducationActivity extends AppCompatActivity implements AddNewEducationView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_education);

        Bundle extras = getIntent().getExtras();

        final String userEmail;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        else{
            userEmail = null;
        }

        final AddNewEducationPresenter presenter = new AddNewEducationPresenter(this, userEmail);

        //create spinner declarations
        Spinner expFieldSpinner = findViewById(R.id.spinnerAddNewEducationSelectExpField);
        Spinner lvlOfStudiesSpinner = findViewById(R.id.spinnerAddNewEducationSelectLevelOfStudies);

        ArrayList<String> levelsOfStudies = new ArrayList<>();
        ArrayList<String> expFields = new ArrayList<>();

        //create spinner list for levels of studies
        for(int i = 0; i< LevelOfStudies.values().length; i++){
            levelsOfStudies.add(LevelOfStudies.values()[i].toString());
        }

        //create spinner list for exp fields
        ExpertiseAreaDAO expAreaDAO = new ExpertiseAreaDAOMemory();
        ArrayList<ExpertiseArea> expertiseAreas = expAreaDAO.getAll();
        for(ExpertiseArea expertiseArea : expertiseAreas){
            expFields.add(expertiseArea.getArea());
        }

        //pass adapter to spinners and define behavior
        ArrayAdapter<String> levelsOfStudiesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, levelsOfStudies);
        lvlOfStudiesSpinner.setAdapter(levelsOfStudiesAdapter);
        lvlOfStudiesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLvlOfStudies = levelsOfStudies.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });

        ArrayAdapter<String> expFieldsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, expFields);
        expFieldSpinner.setAdapter(expFieldsAdapter);
        expFieldSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedExpField = expFields.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });



        //when add button is pressed
        findViewById(R.id.btnAddNewEducation).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        presenter.onAdd();
                    }
                }
        );
    }

    public void successfulAdd(String message, String userToken){
        new AlertDialog.Builder(AddNewEducationActivity.this)
                .setCancelable(false)
                .setTitle("Creation Completed!")
                .setMessage(message)

                //return back to modify cv view when pressed
                .setPositiveButton("Return to Modify CV",
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(AddNewEducationActivity.this, ModifyCVActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }
    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.editTextAddNewEducationDescription)).getText().toString().trim();
    }

    @Override
    public int getExpertiseArea() {
        //get position in respective list
        return ((Spinner)findViewById(R.id.spinnerAddNewEducationSelectExpField)).getSelectedItemPosition();
    }

    @Override
    public int getLevelOfStudies() {
        //get position in respective enum ordinal
        return ((Spinner)findViewById(R.id.spinnerAddNewEducationSelectLevelOfStudies)).getSelectedItemPosition();
    }
}