package com.example.networkmeup.utils.RecyclerViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.Job;

import java.util.ArrayList;

public class SelectJobsRecyclerViewAdapter extends RecyclerView.Adapter<SelectJobsRecyclerViewAdapter.SelectJobsViewHolder> {
    private ArrayList<Job> jobs;
    private Context context;
    private SelectJobsRecyclerViewAdapter.ItemClickListener clickListener;

    public SelectJobsRecyclerViewAdapter(Context context, ArrayList<Job> jobs){
        this.context = context;
        this.jobs = jobs;
    }
    @NonNull
    @Override
    //Creates the look for the rows in the UI recycler view
    public SelectJobsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method creates the look for the rows that we specified
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_jobs_row, parent, false);
        return new SelectJobsViewHolder(view);
    }

    @Override

    //Assign(bind) the data to use for each row
    //changes the data on the recycler view based on the position of the recycler
    public void onBindViewHolder(@NonNull SelectJobsViewHolder holder, int position) {
        //set each holder's members to match the data on the job data found on the position (of the position int passed in the method)
        holder.jobTitle.setText(jobs.get(position).getTitle());
        holder.jobAvailability.setText(jobs.get(position).getAvailability().toString());
        holder.jobDescription.setText(jobs.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return jobs.size();
    }

    //catch click events with a click listener that we set
    public void setClickListener(SelectJobsRecyclerViewAdapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    //method of this interface must be implemented by parent activity
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class SelectJobsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //this class holds the TextView items in the search_jobs_recycler_view_row layout file

        TextView jobTitle;
        TextView jobAvailability;
        TextView jobDescription;

        public SelectJobsViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            this.jobTitle = itemView.findViewById(R.id.textJobTitle);
            this.jobAvailability = itemView.findViewById(R.id.textJobAvailability);
            this.jobDescription = itemView.findViewById(R.id.textJobDescription);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}
