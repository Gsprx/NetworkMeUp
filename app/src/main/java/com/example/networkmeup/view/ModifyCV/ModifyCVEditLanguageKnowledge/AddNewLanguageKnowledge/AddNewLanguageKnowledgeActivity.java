package com.example.networkmeup.view.ModifyCV.ModifyCVEditLanguageKnowledge.AddNewLanguageKnowledge;

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
import com.example.networkmeup.dao.LanguageDAO;
import com.example.networkmeup.daoMemory.LanguageDAOMemory;
import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ModifyCV.ModifyCVActivity;

import java.util.ArrayList;

public class AddNewLanguageKnowledgeActivity extends AppCompatActivity implements AddNewLanguageKnowledgeView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_language_knowledge);

        Bundle extras = getIntent().getExtras();

        final String userEmail;
        if(extras!=null){
            //obtain user token
            userEmail = extras.getString("token");
        }
        else{
            userEmail = null;
        }

        final AddNewLanguageKnowledgePresenter presenter = new AddNewLanguageKnowledgePresenter(this, userEmail);

        //create spinner declarations
        Spinner LanguageSpinner = findViewById(R.id.spinnerAddNewLanguageKnowledgeSelectLang);
        Spinner lvlOfKnowledgeSpinner = findViewById(R.id.spinnerAddNewLanguageKnowledgeSelectLevelOfKnowledge);

        ArrayList<String> levelsOfKnowledge = new ArrayList<>();
        ArrayList<String> Languages = new ArrayList<>();

        //create spinner list for levels of studies
        for(int i = 0; i< LevelOfKnowledge.values().length; i++){
            levelsOfKnowledge.add(LevelOfKnowledge.values()[i].toString());
        }

        //create spinner list for exp fields
        LanguageDAO languageDAO = new LanguageDAOMemory();
        ArrayList<Language> languages = languageDAO.getAll();
        for(Language language : languages){
            Languages.add(language.getLanguage());
        }

        //pass adapter to spinners and define behavior
        ArrayAdapter<String> levelsOfKnowledgeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, levelsOfKnowledge);
        lvlOfKnowledgeSpinner.setAdapter(levelsOfKnowledgeAdapter);


        ArrayAdapter<String> LanguagesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, Languages);
        LanguageSpinner.setAdapter(LanguagesAdapter);


        //when add button is pressed
        findViewById(R.id.btnAddNewLanguageknowledge).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        presenter.onAdd();
                    }
                }
        );
    }

    public void successfulAdd(String message, String userToken){
        new AlertDialog.Builder(AddNewLanguageKnowledgeActivity.this)
                .setCancelable(false)
                .setTitle("Creation Completed!")
                .setMessage(message)

                //return back to modify cv view when pressed
                .setPositiveButton("Return to Modify CV",
                        new DialogInterface.OnClickListener(){

                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(AddNewLanguageKnowledgeActivity.this, ModifyCVActivity.class);
                                intent.putExtra("token", userToken);
                                startActivity(intent);
                            }}).create().show();
    }
    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.editTextAddNewLanguageKnowledgeDescription)).getText().toString().trim();
    }

    @Override
    public int getLanguage() {
        //get position in respective list
        return ((Spinner)findViewById(R.id.spinnerAddNewLanguageKnowledgeSelectLang)).getSelectedItemPosition();
    }

    @Override
    public LevelOfKnowledge getLevelOfKnowledge() {

        Spinner spinner = ((Spinner)findViewById(R.id.spinnerAddNewLanguageKnowledgeSelectLevelOfKnowledge));
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
