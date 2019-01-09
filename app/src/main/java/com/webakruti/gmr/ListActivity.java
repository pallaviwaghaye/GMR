package com.webakruti.gmr;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.webakruti.gmr.SQLiteDB.DatabaseManager;
import com.webakruti.gmr.adapter.ListAdapter;
import com.webakruti.gmr.model.GMREntry;

import java.util.List;

public class ListActivity extends AppCompatActivity {
    private Button buttonSync;
    private RecyclerView recyclerView;
    private LinearLayoutManager mLayoutManger;
    private TextView textViewNoData;

    private ImageView imageViewBack;
    private ProgressDialog progressDialogForAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        DatabaseManager databaseManager = new DatabaseManager(ListActivity.this);
        List<GMREntry> list = databaseManager.getAllEntries();

        buttonSync = (Button)findViewById(R.id.buttonSync);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        textViewNoData = (TextView)findViewById(R.id.textViewNoData);
        imageViewBack = (ImageView)findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListActivity.this,CameraActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialogForAPI = new ProgressDialog(ListActivity.this);
                progressDialogForAPI.setCancelable(false);
                progressDialogForAPI.setIndeterminate(true);
                progressDialogForAPI.setMessage("Syncing Data...");
                progressDialogForAPI.show();


                if (progressDialogForAPI != null) {
                    Toast.makeText(ListActivity.this,"Data Sync Completed Successfully!!",Toast.LENGTH_LONG).show();
                    progressDialogForAPI.cancel();
                }
            }
        });

        /*//recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(ListActivity.this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager1);
        recyclerView.setAdapter(new ListAdapter(ListActivity.this, 10));*/

        recyclerView.setHasFixedSize(true);
        mLayoutManger = new LinearLayoutManager(ListActivity.this);
        recyclerView.setLayoutManager(mLayoutManger);

        if (list != null && list.size() > 0) {
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(new ListAdapter(ListActivity.this, list, recyclerView, textViewNoData));
            textViewNoData.setVisibility(View.GONE);
        } else {
            recyclerView.setVisibility(View.GONE);
            textViewNoData.setVisibility(View.VISIBLE);
        }


    }
}
