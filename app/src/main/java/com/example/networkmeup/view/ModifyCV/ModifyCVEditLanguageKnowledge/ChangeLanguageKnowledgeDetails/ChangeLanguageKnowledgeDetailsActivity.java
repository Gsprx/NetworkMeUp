package com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ChangeLanguageKnowledgeDetails;

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
import com.example.networkmeup.dao.EmployeeDAO;
import com.example.networkmeup.dao.ExpertiseAreaDAO;
import com.example.networkmeup.daoMemory.EmployeeDAOMemory;
import com.example.networkmeup.daoMemory.ExpertiseAreaDAOMemory;
import com.example.networkmeup.daoMemory.LanguageDAOMemory;
import com.example.networkmeup.domain.Email;
import com.example.networkmeup.domain.Employee;
import com.example.networkmeup.domain.ExpertiseArea;
import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ModifyCV.ModifyCVActivity;
import com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.ModifyCVEditLanguageKnowledgeActivity;

import java.util.ArrayList;

public class ChangeLanguageKnowledgeDetailsActivity extends AppCompatActivity implements ChangeLanguageKnowledgeDetailsView {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language_knowledge_details);

        Bundle extras = getIntent().getExtras();

        final String userEmail;
        final int langPosition;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
            //obtain position in list
            langPosition = extras.getInt("position");
        }
        else{
            userEmail = null;
            langPosition = 0;
        }

        final ChangeLanguageKnowledgeDetailsPresenter presenter = new ChangeLanguageKnowledgeDetailsPresenter(this, userEmail);

        //create spinner declarations
        Spinner languageSpinner = findViewById(R.id.spinnerChangeLanguageKnowledgeDetailsSelectLanguage);
        Spinner lvlOfKnowledgeSpinner = findViewById(R.id.spinnerChangeLanguageKnowledgeDetailsSelectLevelOfKnowledge);

        ArrayList<String> levelsOfKnowledge = new ArrayList<>();
        ArrayList<String> languages = new ArrayList<>();

        //create spinner list for levels of studies
        for(int i = 0; i< LevelOfKnowledge.values().length; i++){
            levelsOfKnowledge.add(LevelOfKnowledge.values()[i].toString());
        }

        //create spinner list for languages
        ArrayList<Language> languagesList = new LanguageDAOMemory().getAll();
        for(Language lang : languagesList){
            languages.add(lang.getLanguage());
        }

        //pass adapter to spinners and define behavior
        ArrayAdapter<String> levelsOfKnowledgeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, levelsOfKnowledge);
        lvlOfKnowledgeSpinner.setAdapter(levelsOfKnowledgeAdapter);
        lvlOfKnowledgeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLvlOfKnowledge = levelsOfKnowledge.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });

        ArrayAdapter<String> languagesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, languages);
        languageSpinner.setAdapter(languagesAdapter);

        //when delete button is pressed
        findViewById(R.id.btnChangeLanguageKnowledgeDetailsDelete).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //use dialog builder to create a final warning message to the user
                        new AlertDialog.Builder(ChangeLanguageKnowledgeDetailsActivity.this)
                                .setCancelable(false)
                                .setTitle("Delete Language Knowledge Confirmation")
                                .setMessage("Are you sure you want to delete this language knowledge?")
                                .setPositiveButton("Yes",
                                        new DialogInterface.OnClickListener(){
                                            public void onClick (DialogInterface dialog,int id) {
                                                presenter.onDelete(langPosition);
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
        findViewById(R.id.btnChangeLanguageKnowledgeDetailsSave).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.onSave(langPosition);
                    }
                }
        );

        // when back button is pressed
        findViewById(R.id.backbuttonChangeLanguageKnowledgeDetails).setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View v){
                        Intent intent = new Intent(ChangeLanguageKnowledgeDetailsActivity.this, ModifyCVEditLanguageKnowledgeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );


        //show the existing values to spinners and edit text fields
        EmployeeDAO employeeDAO = new EmployeeDAOMemory();
        Employee currEmployee = employeeDAO.getByEmail(new Email(userEmail));

        ((EditText)findViewById(R.id.editTextChangeLanguageKnowledgeDetailsDescription)).setText(currEmployee.getCV().getLanguageKnowledge().get(langPosition).getDescription());
        languageSpinner.setSelection((languages.indexOf(currEmployee.getCV().getLanguageKnowledge().get(langPosition).getLanguage().getLanguage())));
        lvlOfKnowledgeSpinner.setSelection(levelsOfKnowledge.indexOf(currEmployee.getCV().getLanguageKnowledge().get(langPosition).getLanguage().getLanguage()));
    }

    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.editTextChangeLanguageKnowledgeDetailsDescription)).getText().toString().trim();
    }

    @Override
    public int getLanguage() {
        //get position in respective list
        return ((Spinner) findViewById(R.id.spinnerChangeLanguageKnowledgeDetailsSelectLanguage)).getSelectedItemPosition();
    }

    @Override
    public void successfulDelete(String message, String userToken) {
        new AlertDialog.Builder(ChangeLanguageKnowledgeDetailsActivity.this)
                .setCancelable(false)
                .setTitle("Deletion Completed!")
                .setMessage(message)

                //return back to edit language knowledge view when pressed
                .setPositiveButton("Return to Modify CV",
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(ChangeLanguageKnowledgeDetailsActivity.this, ModifyCVActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }

    @Override
    public void successfulSave(String message, String userToken) {
        new AlertDialog.Builder(ChangeLanguageKnowledgeDetailsActivity.this)
                .setCancelable(false)
                .setTitle("Save Completed!")
                .setMessage(message)

                //return back to edit language knowledge view when pressed
                .setPositiveButton("Return to Modify CV",
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(ChangeLanguageKnowledgeDetailsActivity.this, ModifyCVActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }

    @Override
    public LevelOfKnowledge getLevelOfKnowledge() {

        Spinner spinner = ((Spinner) findViewById(R.id.spinnerChangeLanguageKnowledgeDetailsSelectLevelOfKnowledge));
        int selectedPosition = spinner.getSelectedItemPosition();
        // Determine the LevelOfKnowledge based on the selected position
        switch (selectedPosition) {
            case 0:
                return LevelOfKnowledge.Amateur;
            case 1:
                return LevelOfKnowledge.Lower;
            case 2:
                return LevelOfKnowledge.Advanced;
            case 3:
                return LevelOfKnowledge.Proficiency;
            case 4:
                return LevelOfKnowledge.Native;
            default:
                // Handle the case where the selected position is out of range
                // You can throw an exception, return a default value, or handle it based on your requirements
                // For example, return Amateur as a default value
                return LevelOfKnowledge.Amateur;
        }
    }
}
