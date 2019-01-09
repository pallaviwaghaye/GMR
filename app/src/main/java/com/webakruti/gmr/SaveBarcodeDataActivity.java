package com.webakruti.gmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.webakruti.gmr.SQLiteDB.DatabaseManager;
import com.webakruti.gmr.model.GMREntry;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SaveBarcodeDataActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView imageViewBack;
    private EditText edittextMcode;
    private EditText edittextMname;
    private EditText edittextMtimedate;
    private EditText edittextMreading;
    private TextView textViewScannedData;
    private Button buttonSave;

    //String scannedData;
    String scannedData1;
    String mcode;
    String mname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_barcode_data);

       // scannedData = getIntent().getStringExtra("scannedData");
        scannedData1 = getIntent().getStringExtra("barcodeData");
        mcode = getIntent().getStringExtra("machineCode");
        mname = getIntent().getStringExtra("machineName");

        buttonSave = (Button)findViewById(R.id.buttonSave);
        edittextMcode = (EditText)findViewById(R.id.edittextMcode);
        edittextMname = (EditText)findViewById(R.id.edittextMname);
        edittextMtimedate = (EditText)findViewById(R.id.edittextMtimedate);
        edittextMreading = (EditText)findViewById(R.id.edittextMreading);
        textViewScannedData = (TextView)findViewById(R.id.textViewScannedData);

        imageViewBack = (ImageView)findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SaveBarcodeDataActivity.this,CameraActivity.class);
                startActivity(intent1);
                finish();
            }
        });

        edittextMcode.setText(mcode);
        edittextMname.setText(mname);

        //textViewScannedData.setText(scannedData);
      //  textViewScannedData.setText(scannedData1);

        buttonSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.buttonSave :
                /*Intent intent = new Intent(SaveBarcodeDataActivity.this,ListActivity.class);
                startActivity(intent);
                finish();*/

                if (edittextMcode.getText().toString().length() > 0) {
                    if (edittextMname.getText().toString().length() > 0) {
                        if (edittextMreading.getText().toString().length() > 0) {
                            /*Intent intent = new Intent(SaveBarcodeDataActivity.this,ListActivity.class);
                            startActivity(intent);
                            finish();*/
                            insertToDB();
                        } else {
                            Toast.makeText(SaveBarcodeDataActivity.this, "Please enter machine reading", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(SaveBarcodeDataActivity.this,"Please enter machine name",Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(SaveBarcodeDataActivity.this,"Please enter machine code",Toast.LENGTH_LONG).show();
                }


                break;
        }
    }


    private void insertToDB() {

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy, hh:mm a");
        String formattedDate = df.format(c);
        GMREntry gmrEntry = new GMREntry();
        gmrEntry.setMcode(edittextMcode.getText().toString());
        gmrEntry.setMname(edittextMname.getText().toString());
        gmrEntry.setMreading(edittextMreading.getText().toString());
        gmrEntry.setTimedate(formattedDate);
        DatabaseManager databaseManager = new DatabaseManager(SaveBarcodeDataActivity.this);
        databaseManager.insertCallEntryDetails(gmrEntry);

        Intent intent = new Intent(SaveBarcodeDataActivity.this, ListActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SaveBarcodeDataActivity.this,CameraActivity.class);
        startActivity(intent);
        finish();
        //super.onBackPressed();
    }
}
