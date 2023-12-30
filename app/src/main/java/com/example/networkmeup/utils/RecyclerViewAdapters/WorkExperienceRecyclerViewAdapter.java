package com.example.networkmeup.utils.RecyclerViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.WorkExperience;

import java.util.ArrayList;

public class WorkExperienceRecyclerViewAdapter extends RecyclerView.Adapter<WorkExperienceRecyclerViewAdapter.WorkExperienceViewHolder> {

    ArrayList<WorkExperience> workExperiences;
    Context context;

    public WorkExperienceRecyclerViewAdapter(Context context, ArrayList<WorkExperience> workExperiences) {
        this.context = context;
        this.workExperiences = workExperiences;
    }

    @NonNull
    @Override
    //Creates the look for the rows in the UI recycler view
    public WorkExperienceRecyclerViewAdapter.WorkExperienceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method creates the look for the rows that we specified
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_work_experience, parent, false);
        return new WorkExperienceRecyclerViewAdapter.WorkExperienceViewHolder(view);

    }

    @Override
    //Assign(bind) the data to use for each row
    public void onBindViewHolder(@NonNull WorkExperienceRecyclerViewAdapter.WorkExperienceViewHolder holder, int position) {
        //set each holder's members to match the data on the Work Experience data found on the position (of the position int passed in the method)
        //for example set the WorkExperienceDescription field of the holder to the one matching the Work Experience instance in the list[position]
        holder.WorkExperienceDescription.setText(workExperiences.get(position).getDescription());
        holder.YearsAtWork.setText(String.valueOf(workExperiences.get(position).getYears()));
        holder.WorkExpField.setText(workExperiences.get(position).getExpArea().getArea());
    }

    @Override
    public int getItemCount() {
        return workExperiences.size();
    }


    public static class WorkExperienceViewHolder extends RecyclerView.ViewHolder {
        //this class holds the TextView items in the WorkExperience_recycler_view_row layout file

        TextView WorkExpField;
        TextView YearsAtWork;
        TextView WorkExperienceDescription;

        public WorkExperienceViewHolder(@NonNull View itemView) {
            super(itemView);

            this.WorkExpField = itemView.findViewById(R.id.textWorkExperienceExpArea);
            this.WorkExperienceDescription = itemView.findViewById(R.id.textWorkExperienceDescription);
            this.YearsAtWork = itemView.findViewById(R.id.textWorkExperienceYears);
        }
    }

}