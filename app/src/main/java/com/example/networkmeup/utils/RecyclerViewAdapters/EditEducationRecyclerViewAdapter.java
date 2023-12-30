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


//This specific implementation of the Edit Education RecyclerView implements clickable elements on the list.
//These are used to change/delete the specifically clicked on Education item.
public class EditEducationRecyclerViewAdapter extends RecyclerView.Adapter<EditEducationRecyclerViewAdapter.EditEducationViewHolder> {
    private ArrayList<Education> educations;
    private Context context;
    private ItemClickListener clickListener;

    public EditEducationRecyclerViewAdapter(Context context, ArrayList<Education> educations){
        this.context = context;
        this.educations = educations;
    }
    @NonNull
    @Override
    //Creates the look for the rows in the UI recycler view
    public EditEducationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method creates the look for the rows that we specified
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_education_row, parent, false);
        return new EditEducationViewHolder(view);
    }

    @Override

    //Assign(bind) the data to use for each row
    //changes the data on the recycler view based on the position of the recycler
    public void onBindViewHolder(@NonNull EditEducationViewHolder holder, int position) {
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

    //catch click events with a click listener that we set
    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    //method of this interface must be implemented by parent activity
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class EditEducationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //this class holds the TextView items in the education_recycler_view_row layout file

        TextView educationExpField;
        TextView educationLvlOfStudies;
        TextView educationDescription;

        public EditEducationViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            this.educationExpField = itemView.findViewById(R.id.textEducationExpField);
            this.educationDescription = itemView.findViewById(R.id.textEducationDescription);
            this.educationLvlOfStudies = itemView.findViewById(R.id.textEducationLevelOfStudies);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}
