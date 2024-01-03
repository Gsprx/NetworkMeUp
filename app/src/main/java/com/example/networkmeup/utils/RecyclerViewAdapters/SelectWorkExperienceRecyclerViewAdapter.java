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
import com.example.networkmeup.domain.WorkExperience;
import com.example.networkmeup.domain.WorkExperience;

import java.util.ArrayList;

public class SelectWorkExperienceRecyclerViewAdapter extends RecyclerView.Adapter<SelectWorkExperienceRecyclerViewAdapter.SelectWorkExperienceViewHolder>{
    private ArrayList<WorkExperience> workExp;
    private Context context;
    private ItemClickListener clickListener;

    public SelectWorkExperienceRecyclerViewAdapter(Context context, ArrayList<WorkExperience> workExp){
        this.context = context;
        this.workExp = workExp;
    }
    @NonNull
    @Override
    //Creates the look for the rows in the UI recycler view
    public SelectWorkExperienceRecyclerViewAdapter.SelectWorkExperienceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method creates the look for the rows that we specified
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_work_experience_row, parent, false);
        return new SelectWorkExperienceRecyclerViewAdapter.SelectWorkExperienceViewHolder(view);
    }

    @Override
    //Assign(bind) the data to use for each row
    //changes the data on the recycler view based on the position of the recycler
    public void onBindViewHolder(@NonNull SelectWorkExperienceRecyclerViewAdapter.SelectWorkExperienceViewHolder holder, int position) {
        //set each holder's members to match the data on the WorkExp data found on the position (of the position int passed in the method)

        //for example set the workExpDescription field of the holder to the one matching the WorkExp instance in the list[position]
        holder.workExpDescription.setText(workExp.get(position).getDescription());
        holder.workExpYears.setText(workExp.get(position).getYears());
        holder.workExpExpField.setText(workExp.get(position).getExpArea().getArea());
    }

    @Override
    public int getItemCount() {
        return workExp.size();
    }

    //catch click events with a click listener that we set
    public void setClickListener(SelectWorkExperienceRecyclerViewAdapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    //method of this interface must be implemented by parent activity
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class SelectWorkExperienceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //this class holds the TextView items in the work_Experience_recycler_view_row layout file

        TextView workExpExpField;
        TextView workExpYears;
        TextView workExpDescription;

        public SelectWorkExperienceViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            this.workExpExpField = itemView.findViewById(R.id.textWorkExperienceExpArea);
            this.workExpYears = itemView.findViewById(R.id.textWorkExperienceYears);
            this.workExpDescription = itemView.findViewById(R.id.textWorkExperienceDescription);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}
