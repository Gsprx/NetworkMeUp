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

import com.example.networkmeup.daoMemory.EmployerDAOMemory;
import com.example.networkmeup.domain.Application;
import com.example.networkmeup.domain.Employer;
import com.example.networkmeup.domain.Job;

import org.w3c.dom.Text;

public class EmployeeApplicationRecyclerViewAdapter extends RecyclerView.Adapter<EmployeeApplicationRecyclerViewAdapter.EmployeeApplicationViewHolder>{
        ArrayList<Application> applications;
        Context context;

        public EmployeeApplicationRecyclerViewAdapter(Context context, ArrayList<Application> Applications){
            this.context = context;
            this.applications = Applications;
        }
    @NonNull
    @Override
    //Creates the look for the rows in the UI recycler view
    public EmployeeApplicationRecyclerViewAdapter.EmployeeApplicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method creates the look for the rows that we specified
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_application_employee_row, parent, false);
        return new EmployeeApplicationRecyclerViewAdapter.EmployeeApplicationViewHolder(view);
        }

    @Override

    //Assign(bind) the data to use for each row
    //changes the data on the recycler view based on the position of the recycler
    public void onBindViewHolder(@NonNull EmployeeApplicationRecyclerViewAdapter.EmployeeApplicationViewHolder holder, int position) {
        //set each holder's members to match the data on the Application data found on the position (of the position int passed in the method)
        Application  application = applications.get(position);
        //for example set the Description field of the holder to the one matching the Application instance in the list[position]

        //if the application is not answered, write N/A (Not available)
        holder.status.setText(application.getAnswered()==true ? (application.getStatus() == true ? "Accepted" : "Rejected" ) : "N/A");
        holder.coverLetter.setText(application.getCoverLetter());
        holder.appID.setText(String.valueOf(application.getID()));
        for (Employer emp : new EmployerDAOMemory().getAll()){
            for(Job job : emp.getJobs()){
                for(Application app: job.getApplications()){
                    if(app.getID().equals(application.getID())){
                        holder.company.setText(emp.getCompanyName());
                        holder.sector.setText(emp.getSector());
                        holder.jobTitle.setText(job.getTitle());
                        holder.jobDesc.setText(job.getDescription());
                    }

                }
            }
        }

        }

@Override
public int getItemCount() {
        return applications.size();
        }

public static class EmployeeApplicationViewHolder extends RecyclerView.ViewHolder{
    //this class holds the TextView items in the application_recycler_view_row layout file

    TextView status;
    TextView appID;
    TextView coverLetter;
    TextView jobTitle;
    TextView jobDesc;
    TextView sector;
    TextView company;

    public EmployeeApplicationViewHolder(@NonNull View itemView) {
        super(itemView);

        this.status = itemView.findViewById(R.id.textEmployeeApplicationStatus);
        this.coverLetter = itemView.findViewById(R.id.textEmployeeApplicationCoverLetter);
        this.jobTitle = itemView.findViewById(R.id.textEmployeeApplicationJobTitle);
        this.company = itemView.findViewById(R.id.textViewEmployeeApplicationCompanyNameFill);
        this.sector = itemView.findViewById(R.id.textViewEmployeeApplicationSectorFill);
        this.appID = itemView.findViewById(R.id.textEmployeeApplicationID);
        this.jobDesc = itemView.findViewById(R.id.textEmployeeApplicationJobDescription);
    }
}

}
