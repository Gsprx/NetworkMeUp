package com.example.networkmeup.utils.RecyclerViewAdapters;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.networkmeup.R;
import java.util.ArrayList;
import com.example.networkmeup.domain.Application;

public class ApplicationRecyclerViewAdapter extends RecyclerView.Adapter<ApplicationRecyclerViewAdapter.ApplicationViewHolder>{
        ArrayList<Application> Applications;
        Context context;

        public ApplicationRecyclerViewAdapter(Context context, ArrayList<Application> Applications){
            this.context = context;
            this.Applications = Applications;
        }
    @NonNull
    @Override
    //Creates the look for the rows in the UI recycler view
    public ApplicationRecyclerViewAdapter.ApplicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method creates the look for the rows that we specified
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_application_employee_row, parent, false);
        return new ApplicationRecyclerViewAdapter.ApplicationViewHolder(view);
        }

    @Override

    //Assign(bind) the data to use for each row
    //changes the data on the recycler view based on the position of the recycler
    public void onBindViewHolder(@NonNull ApplicationRecyclerViewAdapter.ApplicationViewHolder holder, int position) {
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

public static class ApplicationViewHolder extends RecyclerView.ViewHolder{
    //this class holds the TextView items in the application_recycler_view_row layout file

    TextView status;
    TextView coverletter;
    TextView applicant;

    public ApplicationViewHolder(@NonNull View itemView) {
        super(itemView);

        this.status = itemView.findViewById(R.id.recyclerViewapplicationStatus);
        this.coverletter = itemView.findViewById(R.id.textEmployeeApplicationCoverLetter);
        this.applicant = itemView.findViewById(R.id.textEmployeeApplicationJobTitle);
    }
}

}
