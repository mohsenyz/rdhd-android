package com.rdhd.app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rdhd.app.R;
import com.rdhd.app.repositories.local.UserPrefs;
import com.rdhd.app.utils.StringUtilsKt;
//import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;


public class LoginActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText phoneNumber,password;
    CheckBox checkBox;
    ImageButton signin;
    Button signup;

    TextView already_signed_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
//
//        email = (EditText)findViewById(R.id.email);
//        password = (EditText)findViewById(R.id.password);
//
//        checkBox = (CheckBox)findViewById(R.id.checkbox);

//        signin =(ImageButton)findViewById(R.id.signin);
//
//        signup = (Button) findViewById(R.id.signup);

//
//        signin.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(LoginActivity.this,"Sign In Button Clicked",Toast.LENGTH_LONG).show();
//            }
//        });
//
//        signup.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(LoginActivity.this,SignUpActivity.class);
//                startActivity(i);
//            }
//        });

        already_signed_up = findViewById(R.id.already_signed_up);

        already_signed_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
                finish();
            }
        });


        phoneNumber = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);

        findViewById(R.id.cirLoginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phoneNumber.getText().toString().trim() == "") {
                    Toast.makeText(LoginActivity.this, "لطفا شماره تلفن خود را وارد کنید", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.getText().toString().trim() == "") {
                    Toast.makeText(LoginActivity.this, "لطفا شماره تلفن خود را وارد کنید", Toast.LENGTH_SHORT).show();
                    return;
                }

                String result = StringUtilsKt.normalizePhone(phoneNumber.getText().toString());
                if (result == null) {
                    Toast.makeText(LoginActivity.this, "شماره تلفن معتبر نیست", Toast.LENGTH_SHORT).show();
                    return;
                }
                UserPrefs.INSTANCE.setToken(LoginActivity.this, "default");
                startActivity(new Intent(LoginActivity.this, ProviderHomeActivity.class));
                finish();
            }
        });


    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
