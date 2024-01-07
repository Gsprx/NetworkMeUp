package com.example.networkmeup.utils.RecyclerViewAdapters;

import android.annotation.SuppressLint;
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

public class SelectEmployerApplicationRecyclerViewAdapter extends RecyclerView.Adapter<SelectEmployerApplicationRecyclerViewAdapter.SelectEmployerApplicationViewHolder>{
    private ArrayList<Application> applications;
    private Context context;
    private SelectEmployerApplicationRecyclerViewAdapter.ItemClickListener clickListener;

    public SelectEmployerApplicationRecyclerViewAdapter(Context context, ArrayList<Application> applications){
        this.context = context;
        this.applications = applications;
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

        Application currApplication = applications.get(position);

        holder.appID.setText(String.valueOf(currApplication.getID()));
        holder.applicantName.setText(currApplication.getEmployee().getName());
        holder.applicantEmail.setText(currApplication.getEmployee().getEmail().getAddress());
        holder.applicantPhone.setText(currApplication.getEmployee().getPhone().getNumber());
        holder.coverLetter.setText(currApplication.getCoverLetter());
    }

    @Override
    public int getItemCount() {
        return applications.size();
    }

    //catch click events with a click listener that we set
    public void setClickListener(SelectEmployerApplicationRecyclerViewAdapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    //method of this interface must be implemented by parent activity
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class SelectEmployerApplicationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //this class holds the TextView items in the Application_recycler_view_row layout file

        TextView appID;
        TextView coverLetter;
        TextView applicantName;
        TextView applicantEmail;
        TextView applicantPhone;

        public SelectEmployerApplicationViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            this.appID = itemView.findViewById(R.id.textEmployerApplicationID);
            this.coverLetter = itemView.findViewById(R.id.textEmployerApplicationCoverLetter);
            this.applicantName = itemView.findViewById(R.id.textEmployerApplicationApplicantName);
            this.applicantEmail = itemView.findViewById(R.id.textEmployerApplicationApplicantEmail);
            this.applicantPhone = itemView.findViewById(R.id.textEmployerApplicationApplicantPhone);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}
