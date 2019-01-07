package com.webakruti.gmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SaveBarcodeDataActivity extends AppCompatActivity {
    private ImageView imageViewBack;
    private TextView textViewMcode;
    private TextView textViewMname;
    private TextView textViewMtimedate;
    private TextView textViewMreading;
    private Button buttonSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_barcode_data);

        buttonSave = (Button)findViewById(R.id.buttonSave);
        textViewMcode = (TextView)findViewById(R.id.textViewMcode);
        textViewMname = (TextView)findViewById(R.id.textViewMname);
        textViewMtimedate = (TextView)findViewById(R.id.textViewMtimedate);
        textViewMreading = (TextView)findViewById(R.id.textViewMreading);

        imageViewBack = (ImageView)findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaveBarcodeDataActivity.this,ListActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
