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

public class HourAdapter extends RecyclerView.Adapter<HourAdapter.ViewHolder> {

    public ArrayList<HoursData> mHoursArray;
    public HourAdapter(ArrayList<HoursData> hours){
        this.mHoursArray = hours;
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        public final View view;
        public final TextView name;
        public final TextView hours;
        public final TextView country;
        public final ImageView badgUrl;

        public ViewHolder(@NonNull View view) {
            super( view );
            this.view = view;
            name = view.findViewById(R.id.tvName);
            hours = view.findViewById(R.id.tvHours);
            country = view.findViewById( R.id.tvCountry );
            badgUrl = view.findViewById( R.id.badgeUrl );
        }
    }

    @NonNull
    @Override
    public HourAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hours, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HourAdapter.ViewHolder holder, int position) {
        HoursData mHoursData = mHoursArray.get( position );
        holder.name.setText( mHoursData.getName() );
        holder.hours.setText( mHoursData.getHours() );
        holder.country.setText( mHoursData.getCountry() );
        Picasso.get().load(mHoursData.getBadgUrl()).into(holder.badgUrl);
    }

    @Override
    public int getItemCount() {
        if (mHoursArray != null){
            return mHoursArray.size();
        } else {
            return 0;
        }

    }


}
