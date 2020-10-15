package com.example.Gads2020Project;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.ViewHolder> {

    public ArrayList<SkillsData> mSkillsArray;
    public SkillsAdapter(ArrayList<SkillsData> skills){
        this.mSkillsArray = skills;
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        public final View view;
        public final TextView name;
        public final TextView score;
        public final TextView country;
        public final ImageView badgUrl;

        public ViewHolder(@NonNull View view) {
            super( view );
            this.view = view;
            name = view.findViewById(R.id.tvSkillName);
            score = view.findViewById(R.id.tvSkillScore);
            country = view.findViewById( R.id.tvCountry );
            badgUrl = view.findViewById( R.id.badgeUrl );
        }
    }

    @NonNull
    @Override
    public SkillsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_skills, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SkillsAdapter.ViewHolder holder, int position) {
        SkillsData mSkillsData = mSkillsArray.get( position );
        holder.name.setText( mSkillsData.getName() );
        holder.score.setText( mSkillsData.getScore() );
        holder.country.setText( mSkillsData.getCountry() );
        Picasso.get().load(mSkillsData.getBadgUrl()).into(holder.badgUrl);
    }

    @Override
    public int getItemCount() {
        if (mSkillsArray != null){
            return mSkillsArray.size();
        } else {
            return 0;
        }

    }


}
