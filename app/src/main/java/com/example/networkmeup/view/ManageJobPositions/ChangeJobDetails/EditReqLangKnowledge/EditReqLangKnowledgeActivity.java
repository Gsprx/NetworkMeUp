package com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.Job;
import com.example.networkmeup.domain.LanguageKnowledge;
import com.example.networkmeup.utils.RecyclerViewAdapters.SelectLanguageKnowledgeRecyclerViewAdapter;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.ChangeJobDetailsActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.AddNewReqLangKnowledge.AddNewReqLangKnowledgeActivity;
import com.example.networkmeup.view.ManageJobPositions.ChangeJobDetails.EditReqLangKnowledge.ChangeReqLangKnowledgeDetails.ChangeReqLangKnowledgeDetailsActivity;

import java.util.ArrayList;

/**
 * The EditReqLangKnowledgeActivity class extends AppCompatActivity and implements the EditReqLangKnowledgeView interface.
 * This class is responsible for managing the editing of required language knowledge details.
 */
public class EditReqLangKnowledgeActivity extends AppCompatActivity implements EditReqLangKnowledgeView{

    /**
     * This method is called when the activity is starting. It is where most initialization happens.
     * @param savedInstanceState If the activity is being re-initialized after
     *                           previously being shut down then this Bundle contains the data it most
     *                           recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_req_lang_knowledge);

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
         * Create a new instance of EditReqLangKnowledgePresenter with the current activity, user email, current job.
         */
        final EditReqLangKnowledgePresenter presenter = new EditReqLangKnowledgePresenter(this, userEmail,currJob);

        //get job data to pass to recycler view
        ArrayList<LanguageKnowledge> reqLangList = currJob.getReqLanguageKnowledge();

        //get recycler view reference
        RecyclerView recyclerView = findViewById(R.id.recyclerViewEditReqLangKnowledge);
        //create recycler view adapter
        SelectLanguageKnowledgeRecyclerViewAdapter adapter = new SelectLanguageKnowledgeRecyclerViewAdapter(this, reqLangList);
        adapter.setClickListener(new SelectLanguageKnowledgeRecyclerViewAdapter.ItemClickListener() {
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
        findViewById(R.id.btnEditReqLangKnowledgeAddNew).setOnClickListener(
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
        findViewById(R.id.backbuttonEditReqLangKnowledge).setOnClickListener(
                new View.OnClickListener(){
                    /**
                     * Called when the Back button has been clicked.
                     * @param v The view that was clicked.
                     */
                    public void onClick(View v){
                        Intent intent = new Intent(EditReqLangKnowledgeActivity.this, ChangeJobDetailsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        startActivity(intent);
                    }
                }
        );
    }

    /**
     * Method to change language knowledge details.
     * @param userToken User token to be passed to next activity.
     * @param position The position of the language knowledge in the list.
     * @param job Job object to be passed after being updated.
     */
    @Override
    public void changeLanguageKnowledgeDetails(String userToken, int position, Job job){
        Intent intent = new Intent(EditReqLangKnowledgeActivity.this, ChangeReqLangKnowledgeDetailsActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("position", position);
        intent.putExtra("job", job);
        startActivity(intent);
    }

    /**
     * Method to add new language knowledge.
     * @param userToken User token to be passed to next activity.
     * @param job Job object to be passed after being updated.
     */
    @Override
    public void addNewLanguageKnowledge(String userToken, Job job) {
        Intent intent = new Intent(EditReqLangKnowledgeActivity.this, AddNewReqLangKnowledgeActivity.class);
        intent.putExtra("token", userToken);
        intent.putExtra("job", job);
        startActivity(intent);
    }
}
