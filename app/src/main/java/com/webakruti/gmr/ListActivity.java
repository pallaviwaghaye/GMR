package com.webakruti.gmr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.webakruti.gmr.adapter.ListAdapter;

public class ListActivity extends AppCompatActivity {
    private Button buttonSync;
    private RecyclerView recyclerView;
    private TextView textViewNoData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        buttonSync = (Button)findViewById(R.id.buttonSync);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        textViewNoData = (TextView)findViewById(R.id.textViewNoData);

        buttonSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ListActivity.this,"Data Saved Successfully !!",Toast.LENGTH_LONG).show();
            }
        });

        //recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(ListActivity.this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager1);
        recyclerView.setAdapter(new ListAdapter(ListActivity.this, 10));


    }
}
