package com.webakruti.gmr.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.webakruti.gmr.R;

import java.util.List;

/**
 * Created by DELL on 9/29/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    Activity context;
    int size;


    public ListAdapter(Activity context, int size) {
        this.context = context;
        this.size = size;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {


    }

    @Override
    public int getItemCount() {
        return size;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView textViewMcCode;
        private TextView textViewMcName;
        private TextView textViewTimeDate;
        private TextView textViewMcReading;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewMcCode = (TextView) itemView.findViewById(R.id.textViewMcCode);
            textViewMcName = (TextView) itemView.findViewById(R.id.textViewMcName);
            textViewTimeDate = (TextView) itemView.findViewById(R.id.textViewTimeDate);
            textViewMcReading = (TextView) itemView.findViewById(R.id.textViewMcReading);

        }
    }

}
