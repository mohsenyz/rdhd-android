package com.rdhd.app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;

import com.rdhd.app.R;
import com.rdhd.app.utils.StringUtilsKt;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class SignUpActivity extends AppCompatActivity{

    Toolbar toolbar;
    EditText name,phoneNumber,email,password;
    CheckBox checkBox;
    ImageButton signup;
    Button signin;
    TextView never_signed_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        never_signed_in = findViewById(R.id.never_signed_in);
        name = findViewById(R.id.editTextName);
        phoneNumber = findViewById(R.id.editTextPhoneNumber);
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);

        never_signed_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                finish();
            }
        });


        findViewById(R.id.registerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().trim() == "") {
                    Toast.makeText(SignUpActivity.this, "اسم میتونه خالی باشه؟", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (phoneNumber.getText().toString().trim() == "") {
                    Toast.makeText(SignUpActivity.this, "شماره تلفن :-/", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (email.getText().toString().trim() == "") {
                    Toast.makeText(SignUpActivity.this, "ایمیل رو وارد کنید!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.getText().toString().trim() == "") {
                    Toast.makeText(SignUpActivity.this, "پسورد رو لطفا وارد کنید :-/", Toast.LENGTH_SHORT).show();
                    return;
                }

                String phone = StringUtilsKt.normalizePhone(phoneNumber.getText().toString());
                if (phone == null) {
                    Toast.makeText(SignUpActivity.this, "شماره تلفن معتبر نیست", Toast.LENGTH_SHORT).show();
                    return;
                }

                startActivity(new Intent(SignUpActivity.this, Authentication.class));
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
