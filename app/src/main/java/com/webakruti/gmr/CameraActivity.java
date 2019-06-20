package com.webakruti.gmr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraActivity extends AppCompatActivity implements View.OnClickListener{
   // private ImageView imageViewBack;
    private Button buttonScan;
    private ImageView imageViewShowList;

    String scannedData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

       /* imageViewBack = (ImageView)findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

        imageViewShowList = (ImageView)findViewById(R.id.imageViewShowList);
        imageViewShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CameraActivity.this,ListActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonScan = (Button)findViewById(R.id.buttonScan);
        buttonScan.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonScan:
                Intent intent = new Intent(CameraActivity.this, ScanBarcodeActivity.class);
                startActivity(intent);
                finish();
                /*IntentIntegrator integrator = new IntentIntegrator(CameraActivity.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Scan QR Code");
                integrator.setBeepEnabled(false);
                //used to open back camera while scanning
                integrator.setCameraId(0);
                //used to open front camera while scanning
                //integrator.setCameraId(1);
                integrator.setBarcodeImageEnabled(false);
                integrator.setOrientationLocked(false);
               // integrator.setCaptureLayout(R.layout.custom_layout);
                integrator.initiateScan();*/

        }
    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result=IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        if(result!=null)
        {


            scannedData = result.getContents();
            if(scannedData!=null)
            {
                *//*Intent intent = new Intent(CameraActivity.this, SaveBarcodeDataActivity.class);
                intent.putExtra("scannedData",scannedData);
                startActivity(intent);
                finish();*//*
                try {
                    JSONObject object = new JSONObject(result.getContents());
                    String mcode = object.getString("machineCode");
                    String mname = object.getString("machineName");
                    Intent intent = new Intent(CameraActivity.this, SaveBarcodeDataActivity.class);
                    intent.putExtra("machineCode", mcode);
                    intent.putExtra("machineName", mname);

                    intent.putExtra("barcodeData", scannedData);
                    startActivity(intent);
                    finish();
                }catch (JSONException e) {
                    e.printStackTrace();
                }
            }else{
                Toast.makeText(CameraActivity.this,"No data found!!",Toast.LENGTH_SHORT).show();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }*/
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
