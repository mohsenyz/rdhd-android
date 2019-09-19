package com.rdhd.app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rdhd.app.R;
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
    EditText email,password;
    CheckBox checkBox;
    ImageButton signin;
    Button signup;

    TextView never_signed_in;

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

        never_signed_in = findViewById(R.id.never_signed_in);

        never_signed_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity.class));
            }
        });


    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
