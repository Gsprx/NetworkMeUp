package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.AddNewReqLangKnowledge;

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
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.Language;
import com.example.networkmeup.domain.LevelOfKnowledge;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.EditReqLangKnowledgeActivity;

import java.util.ArrayList;

/**
 * The AddNewReqLangKnowledgeActivity class extends AppCompatActivity and implements the AddNewReqLangKnowledgeView interface.
 * This class is responsible for managing the addition of new required language knowledge details.
 */
public class AddNewReqLangKnowledgeActivity extends AppCompatActivity implements AddNewReqLangKnowledgeView{

    /**
     * This method is called when the activity is starting. It is where most initialization happens.
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_req_lang_knowledge);
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
         * Create a new instance of AddNewReqLangKnowledgePresenter with the current activity, user email, current job.
         */
        final AddNewReqLangKnowledgePresenter presenter = new AddNewReqLangKnowledgePresenter(this, userEmail, currJob);

        //create spinner declarations
        Spinner languageSpinner = findViewById(R.id.spinnerAddNewReqLangKnowledgeSelectLang);
        Spinner lvlOfKnowledgeSpinner = findViewById(R.id.spinnerAddNewReqLangKnowledgeSelectLevelOfKnowledge);

        ArrayList<String> levelsOfKnowledge = new ArrayList<>();
        ArrayList<String> languagesList = new ArrayList<>();

        //create spinner list for levels of knowledge
        for(int i = 0; i< LevelOfKnowledge.values().length; i++){
            levelsOfKnowledge.add(LevelOfKnowledge.values()[i].toString());
        }

        //create spinner list for languages
        LanguageDAO languageDAO = new LanguageDAOMemory();
        ArrayList<Language> Languages = languageDAO.getAll();
        for(Language language : Languages){
            languagesList.add(language.getLanguage());
        }

        //pass adapter to spinners and define behavior
        ArrayAdapter<String> levelsOfKnowledgeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, levelsOfKnowledge);
        lvlOfKnowledgeSpinner.setAdapter(levelsOfKnowledgeAdapter);
        lvlOfKnowledgeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * Callback method to be invoked when an item in this view has been selected.
             * @param parent The AdapterView where the selection happened.
             * @param view The view within the AdapterView that was clicked.
             * @param position The position of the view in the adapter.
             * @param id The row id of the item that is selected.
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLvlOfKnowledge = levelsOfKnowledge.get(position);
            }

            /**
             * Callback method to be invoked when the selection disappears from this view.
             * @param parent The AdapterView that now contains no selected item.
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });

        ArrayAdapter<String> languagesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, languagesList);
        languageSpinner.setAdapter(languagesAdapter);
        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            /**
             * Callback method to be invoked when an item in this view has been selected.
             * @param parent The AdapterView where the selection happened.
             * @param view The view within the AdapterView that was clicked.
             * @param position The position of the view in the adapter.
             * @param id The row id of the item that is selected.
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedLanguage = languagesList.get(position);
            }

            /**
             * Callback method to be invoked when the selection disappears from this view.
             * @param parent The AdapterView that now contains no selected item.
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });

        //when add button is pressed
        findViewById(R.id.btnAddNewReqLangknowledge).setOnClickListener(
                new View.OnClickListener() {
                    /**
                     * Called when the Add button has been clicked.
                     * @param v The view that was clicked.
                     */
                    @Override
                    public void onClick(View v) {
                        presenter.onAdd();
                    }
                }
        );
        // when back button is pressed
        findViewById(R.id.backbuttonAddNewReqLangKnowledge).setOnClickListener(
                new View.OnClickListener(){
                    /**
                     * Called when the Back button has been clicked.
                     * @param v The view that was clicked.
                     */
                    public void onClick(View v){
                        Intent intent = new Intent(AddNewReqLangKnowledgeActivity.this, EditReqLangKnowledgeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }
    /**
     * Method for activity continuity after a successful add.
     * @param message Message sent by the presenter.
     * @param userToken User token to be passed to next activity.
     * @param job Job object to be passed after being updated.
     */
    @Override
    public void successfulAdd(String message, String userToken, Job job){
        new AlertDialog.Builder(AddNewReqLangKnowledgeActivity.this)
                .setCancelable(false)
                .setTitle("Creation Completed!")
                .setMessage(message)

                //return back to modify job view when pressed
                .setPositiveButton("Return to Change Job Details",
                        new DialogInterface.OnClickListener(){

                            /**
                             * This method will be invoked when the positive button in the dialog is clicked.
                             * @param dialog The dialog that received the click.
                             * @param id The button that was clicked.
                             */
                            public void onClick (DialogInterface dialog,int id) {

                                Intent intent = new Intent(AddNewReqLangKnowledgeActivity.this, ChangeJobDetailsActivity.class);
                                intent.putExtra("token", userToken);
                                intent.putExtra("job", job);
                                startActivity(intent);
                            }}).create().show();
    }

    /**
     * Method to obtain description from a text field.
     * @return String value of the description typed by the user.
     */
    @Override
    public String getDescription() {
        return ((EditText)findViewById(R.id.editTextAddNewReqLangKnowledgeDescription)).getText().toString().trim();
    }

    /**
     * Method to obtain language from a spinner.
     * @return Integer value of the selected language.
     */
    @Override
    public int getLanguage() {
        //get position in respective list
        return ((Spinner)findViewById(R.id.spinnerAddNewReqLangKnowledgeSelectLang)).getSelectedItemPosition();
    }

    /**
     * Method to obtain level of knowledge from a spinner.
     * @return LevelOfKnowledge value of the selected level of knowledge.
     */
    @Override
    public LevelOfKnowledge getLevelOfKnowledge() {

        Spinner spinner = ((Spinner)findViewById(R.id.spinnerAddNewReqLangKnowledgeSelectLevelOfKnowledge));
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
