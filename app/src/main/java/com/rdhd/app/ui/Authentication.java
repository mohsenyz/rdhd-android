package com.rdhd.app.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jkb.vcedittext.VerificationCodeEditText;
import com.rdhd.app.R;
import com.rdhd.app.repositories.local.UserPrefs;

import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class Authentication extends AppCompatActivity {

    VerificationCodeEditText otpCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        otpCode = findViewById(R.id.otpCode);
        findViewById(R.id.cirLoginButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otpCode.getText().toString().trim().length() == 6) {
                    UserPrefs.INSTANCE.setToken(Authentication.this, "default");
                    finishAffinity();
                    startActivity(new Intent(Authentication.this, ProviderHomeActivity.class));
                } else {
                    Toast.makeText(Authentication.this, "کد رو اشتباه وارد کردی عزیز", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }
}
