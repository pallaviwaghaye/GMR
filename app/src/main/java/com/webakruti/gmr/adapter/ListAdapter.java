package com.webakruti.gmr.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
import com.webakruti.gmr.SQLiteDB.DatabaseManager;
import com.webakruti.gmr.model.GMREntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 9/29/2018.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    /*Activity context;
    int size;*/
    private final DatabaseManager databaseManager;
    Activity context;
    List<GMREntry> list = new ArrayList<>();
    RecyclerView recyclerView;
    TextView textView;

    public ListAdapter(Activity context, List<GMREntry> list, RecyclerView recyclerView, TextView textView) {
        super();
        this.context = context;
        this.list = list;
        this.recyclerView = recyclerView;
        this.textView = textView;
        databaseManager = new DatabaseManager(context);


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
        final GMREntry gmrEntry = list.get(position);
        viewHolder.textViewMcCode.setText(gmrEntry.getMcode());
        viewHolder.textViewMcName.setText(gmrEntry.getMname());
        viewHolder.textViewMcReading.setText(gmrEntry.getMreading());
        viewHolder.textViewTimeDate.setText(gmrEntry.getTimedate());

        viewHolder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setTitle("Delete")
                        .setMessage("Are you sure to delete ?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                deleteAndUpdate(gmrEntry.getId(),position);
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                            }
                        })
                        .show();


            }
        });

    }

    private void deleteAndUpdate(int gmrid, int position) {
        int id = databaseManager.deleteEntry(gmrid);
        if (id > 0) {
            list.remove(position);
            this.notifyDataSetChanged();

            if(list.size() == 0) {
                recyclerView.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
            } else {
                recyclerView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        private TextView textViewMcCode;
        private TextView textViewMcName;
        private TextView textViewTimeDate;
        private TextView textViewMcReading;
        private ImageView imageViewDelete;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewMcCode = (TextView) itemView.findViewById(R.id.textViewMcCode);
            textViewMcName = (TextView) itemView.findViewById(R.id.textViewMcName);
            textViewTimeDate = (TextView) itemView.findViewById(R.id.textViewTimeDate);
            textViewMcReading = (TextView) itemView.findViewById(R.id.textViewMcReading);
            imageViewDelete = (ImageView)itemView.findViewById(R.id.imageViewDelete);

        }
    }

}
