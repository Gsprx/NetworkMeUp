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
import com.example.networkmeup.domain.LanguageKnowledge;

import java.util.ArrayList;

public class LanguageKnowledgeRecyclerViewAdapter extends RecyclerView.Adapter<LanguageKnowledgeRecyclerViewAdapter.LanguageKnowledgeViewHolder> {
    ArrayList<LanguageKnowledge> languages;
    Context context;

    public LanguageKnowledgeRecyclerViewAdapter(Context context, ArrayList<LanguageKnowledge> languages){
        this.context = context;
        this.languages = languages;
    }
    @NonNull
    @Override
    //Creates the look for the rows in the UI recycler view
    public LanguageKnowledgeRecyclerViewAdapter.LanguageKnowledgeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this method creates the look for the rows that we specified
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_language_knowledge_row, parent, false);
        return new LanguageKnowledgeRecyclerViewAdapter.LanguageKnowledgeViewHolder(view);
    }

    @Override

    //Assign(bind) the data to use for each row
    //changes the data on the recycler view based on the position of the recycler
    public void onBindViewHolder(@NonNull  LanguageKnowledgeRecyclerViewAdapter.LanguageKnowledgeViewHolder holder, int position) {
        //set each holder's members to match the data on the Language Knowledge data found on the position (of the position int passed in the method)

        //for example set the eduDescription field of the holder to the one matching the Language Knowledge instance in the list[position]
        holder.LanguageKnowledgeDescription.setText(languages.get(position).getDescription());

        holder.LanguageKnowledgeLvlOfknowledge.setText(languages.get(position).getLvlOfKnowledge().toString());
        holder.LanguageKnowledgelanguage.setText(languages.get(position).getLanguage().getLanguage());
    }

    @Override
    public int getItemCount() {
        return languages.size();
    }

    public static class LanguageKnowledgeViewHolder extends RecyclerView.ViewHolder{
        //this class holds the TextView items in the Language_Knowledge_recycler_view_row layout file

        TextView LanguageKnowledgelanguage;
        TextView LanguageKnowledgeLvlOfknowledge;
        TextView LanguageKnowledgeDescription;

        public LanguageKnowledgeViewHolder(@NonNull View itemView) {
            super(itemView);

            this.LanguageKnowledgelanguage = itemView.findViewById(R.id.textLanguageKnowledgeLanguuage);
            this.LanguageKnowledgeDescription = itemView.findViewById(R.id.textLanguageKnowledgeDescription);
            this.LanguageKnowledgeLvlOfknowledge = itemView.findViewById(R.id.textLanguageKnowledgeLevel);
        }
    }
}

