package com.example.networkmeup.utils.RecyclerViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.Application;

import java.util.ArrayList;

public class SelectEmployerApplicationRecyclerViewAdapter {
    private ArrayList<Application> Applications;
    private Context context;
    private SelectEmployerApplicationRecyclerViewAdapter.ItemClickListener clickListener;

    public SelectEmployerApplicationRecyclerViewAdapter(Context context, ArrayList<Application> applications){
        this.context = context;
        this.Applications = applications;
    }
    @NonNull
    @Override
    //Creates the look for the rows in the UI recycler view
    public SelectEmployerApplicationRecyclerViewAdapter.SelectEmployerApplicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method creates the look for the rows that we specified
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_application_employer_row, parent, false);
        return new SelectEmployerApplicationRecyclerViewAdapter.SelectEmployerApplicationViewHolder(view);
    }

    @Override

    //Assign(bind) the data to use for each row
    //changes the data on the recycler view based on the position of the recycler
    public void onBindViewHolder(@NonNull SelectEmployerApplicationRecyclerViewAdapter.SelectEmployerApplicationViewHolder holder, int position) {
        //set each holder's members to match the data on the Application data found on the position (of the position int passed in the method)

        //for example set the Description field of the holder to the one matching the Application instance in the list[position]
        holder.status.setText(Boolean.toString(Applications.get(position).getStatus()));
        holder.coverletter.setText(Applications.get(position).getCoverLetter());
        holder.applicant.setText(Applications.get(position).getEmployee().getName());
    }

    @Override
    public int getItemCount() {
        return Applications.size();
    }

    //catch click events with a click listener that we set
    public void setClickListener(SelectEmployeeApplicationRecyclerViewAdapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    //method of this interface must be implemented by parent activity
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class SelectEmployerApplicationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //this class holds the TextView items in the Application_recycler_view_row layout file

        TextView status;
        TextView coverletter;
        TextView applicant;

        public SelectEmployerApplicationViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            this.status = itemView.findViewById(R.id.textView624);
            this.coverletter = itemView.findViewById(R.id.textEmployeeApplicationCoverLetter);
            this.applicant = itemView.findViewById(R.id.textEmployeeApplicationJobTitle);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}
