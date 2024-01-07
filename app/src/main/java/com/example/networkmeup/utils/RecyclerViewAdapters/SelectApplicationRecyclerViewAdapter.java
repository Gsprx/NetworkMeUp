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

public class SelectApplicationRecyclerViewAdapter extends RecyclerView.Adapter<SelectApplicationRecyclerViewAdapter.SelectApplicationViewHolder>{

    private ArrayList<Application> Applications;
    private Context context;
    private ItemClickListener clickListener;

    public SelectApplicationRecyclerViewAdapter(Context context, ArrayList<Application> applications){
        this.context = context;
        this.Applications = applications;
        }
    @NonNull
    @Override
    //Creates the look for the rows in the UI recycler view
    public SelectApplicationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method creates the look for the rows that we specified
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_application_employee_row, parent, false);
        return new SelectApplicationViewHolder(view);
        }

    @Override

    //Assign(bind) the data to use for each row
    //changes the data on the recycler view based on the position of the recycler
    public void onBindViewHolder(@NonNull SelectApplicationViewHolder holder, int position) {
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
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
        }

//method of this interface must be implemented by parent activity
public interface ItemClickListener {
    void onItemClick(View view, int position);
}

public class SelectApplicationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    //this class holds the TextView items in the Application_recycler_view_row layout file

    TextView status;
    TextView coverletter;
    TextView applicant;

    public SelectApplicationViewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener(this);

        this.status = itemView.findViewById(R.id.recyclerViewapplicationStatus);
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
