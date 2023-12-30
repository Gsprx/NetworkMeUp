package com.example.networkmeup.utils.RecyclerViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.Education;

import java.util.ArrayList;

public class EducationRecyclerViewAdapter extends RecyclerView.Adapter<EducationRecyclerViewAdapter.EducationViewHolder> {
    ArrayList<Education> educations;
    Context context;

    public EducationRecyclerViewAdapter(Context context, ArrayList<Education> educations){
        this.context = context;
        this.educations = educations;
    }
    @NonNull
    @Override
    //Creates the look for the rows in the UI recycler view
    public EducationRecyclerViewAdapter.EducationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method creates the look for the rows that we specified
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_education_row, parent, false);
        return new EducationRecyclerViewAdapter.EducationViewHolder(view);
    }

    @Override

    //Assign(bind) the data to use for each row
    //changes the data on the recycler view based on the position of the recycler
    public void onBindViewHolder(@NonNull EducationRecyclerViewAdapter.EducationViewHolder holder, int position) {
        //set each holder's members to match the data on the Education data found on the position (of the position int passed in the method)

        //for example set the eduDescription field of the holder to the one matching the Education instance in the list[position]
        holder.educationDescription.setText(educations.get(position).getDescription());

        holder.educationLvlOfStudies.setText(educations.get(position).getLvlOfStudies().toString());
        holder.educationExpField.setText(educations.get(position).getExpArea().getArea());
    }

    @Override
    public int getItemCount() {
        return educations.size();
    }

    public static class EducationViewHolder extends RecyclerView.ViewHolder{
        //this class holds the TextView items in the education_recycler_view_row layout file

        TextView educationExpField;
        TextView educationLvlOfStudies;
        TextView educationDescription;

        public EducationViewHolder(@NonNull View itemView) {
            super(itemView);

            this.educationExpField = itemView.findViewById(R.id.textEducationExpFieldField);
            this.educationDescription = itemView.findViewById(R.id.textEduactionDescription);
            this.educationLvlOfStudies = itemView.findViewById(R.id.textEducationLevelOfStudies);
        }
    }
}
