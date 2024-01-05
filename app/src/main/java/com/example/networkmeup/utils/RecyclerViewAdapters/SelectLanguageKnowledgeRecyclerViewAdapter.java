package com.example.networkmeup.utils.RecyclerViewAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.networkmeup.R;
import com.example.networkmeup.domain.LanguageKnowledge;

import java.util.ArrayList;

public class SelectLanguageKnowledgeRecyclerViewAdapter extends RecyclerView.Adapter<SelectLanguageKnowledgeRecyclerViewAdapter.SelectLanguageKnowledgeViewHolder>{
    private ArrayList<LanguageKnowledge> Lang;
    private Context context;
    private ItemClickListener clickListener;

    public SelectLanguageKnowledgeRecyclerViewAdapter(Context context, ArrayList<LanguageKnowledge> Lang){
        this.context = context;
        this.Lang = Lang;
    }
    @NonNull
    @Override
    //Creates the look for the rows in the UI recycler view
    public SelectLanguageKnowledgeRecyclerViewAdapter.SelectLanguageKnowledgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method creates the look for the rows that we specified
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_language_knowledge_row, parent, false);
        return new SelectLanguageKnowledgeRecyclerViewAdapter.SelectLanguageKnowledgeViewHolder(view);
    }

    @Override
    //Assign(bind) the data to use for each row
    //changes the data on the recycler view based on the position of the recycler
    public void onBindViewHolder(@NonNull SelectLanguageKnowledgeRecyclerViewAdapter.SelectLanguageKnowledgeViewHolder holder, int position) {
        //set each holder's members to match the data on the WorkExp data found on the position (of the position int passed in the method)

        //for example set the workExpDescription field of the holder to the one matching the WorkExp instance in the list[position]
        holder.LanguageKnowledgeDescription.setText(Lang.get(position).getDescription());
        holder.LanguageKnowledgeLevel.setText(Lang.get(position).getLvlOfKnowledge().toString());
        holder.Language.setText(Lang.get(position).getLanguage().getLanguage());
    }

    @Override
    public int getItemCount() {
        return Lang.size();
    }

    //catch click events with a click listener that we set
    public void setClickListener(SelectLanguageKnowledgeRecyclerViewAdapter.ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    //method of this interface must be implemented by parent activity
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public class SelectLanguageKnowledgeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //this class holds the TextView items in the recycler_view_language_knowledge_row layout file

        TextView Language;
        TextView LanguageKnowledgeLevel;
        TextView LanguageKnowledgeDescription;

        public SelectLanguageKnowledgeViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            this.Language = itemView.findViewById(R.id.textLanguageKnowledgeLanguage);
            this.LanguageKnowledgeLevel = itemView.findViewById(R.id.textLanguageKnowledgeLevel);
            this.LanguageKnowledgeDescription = itemView.findViewById(R.id.textLanguageKnowledgeDescription);
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) {
                clickListener.onItemClick(v, getAdapterPosition());
            }
        }
    }
}