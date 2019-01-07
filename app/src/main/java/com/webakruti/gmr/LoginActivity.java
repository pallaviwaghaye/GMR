package com.webakruti.gmr;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonLogin;
   // private ImageView imageViewBack;
    //private LinearLayout linearLayoutGotoLogin;
    private ProgressDialog progressDialogForAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //SharedPreferenceManager.setApplicationContext(LoginActivity.this);

        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        /*linearLayoutGotoLogin = (LinearLayout) findViewById(R.id.linearLayoutGotoLogin);
        linearLayoutGotoLogin.setOnClickListener(this);*/

        /*imageViewBack = (ImageView) findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });*/

        buttonLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.buttonLogin:

                Intent intent = new Intent(LoginActivity.this, CameraActivity.class);
                startActivity(intent);
                finish();
                /*if (editTextName.getText().toString().length() > 0) {
                    if (editTextMobileNumber.getText().toString().length() > 0) {
                        if (editTextMobileNumber.getText().toString().length() == 10) {
                            Intent intent = new Intent(RegistrationActivity.this, OtpActivity.class);
                            startActivity(intent);
                            finish();
                            if (NetworkUtil.hasConnectivity(RegistrationActivity.this)) {
                                callRegistartionAPI();
                            } else {
                                Toast.makeText(RegistrationActivity.this, R.string.no_internet_message, Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegistrationActivity.this, "Mobile number must be valid", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegistrationActivity.this, "Mobile number Can't be empty", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegistrationActivity.this, "Name Can't be empty", Toast.LENGTH_SHORT).show();

                }
*/
                break;

           /* case R.id.linearLayoutGotoLogin:
                Intent intent2 = new Intent(LoginActivity.this, LoginActivity.class);
                startActivity(intent2);
                finish();

                break;*/


        }
    }



}
