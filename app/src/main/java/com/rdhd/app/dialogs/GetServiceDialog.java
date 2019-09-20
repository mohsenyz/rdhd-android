package com.rdhd.app.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alirezaafkar.sundatepicker.DatePicker;
import com.alirezaafkar.sundatepicker.interfaces.DateSetListener;
import com.rdhd.app.R;
import com.rdhd.app.ui.QrCodeActivity;

import java.util.Calendar;

public class GetServiceDialog extends Dialog {


    private Button startDateButton,endDateButton;
    private Button cancelButton, confirmButton;
    private EditText editText;
    private Context mContext;
    private String startdate, endDate;
    public GetServiceDialog(@NonNull Context context) {
        super(context);
        mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_get_service_dialog);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));

        startDateButton = findViewById(R.id.start_date_picker);
        endDateButton = findViewById(R.id.end_date_picker);

        cancelButton = findViewById(R.id.get_dialog_cancel);

        editText = findViewById(R.id.editTextPhoneNum);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        confirmButton = findViewById(R.id.get_dialog_confirm);





        startDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new DatePicker.Builder()
                        .id(1)
                        .build(new DateSetListener() {
                            @Override
                            public void onDateSet(int id, @Nullable Calendar calendar, int day, int month, int year) {
                                startdate = calendar.getTime().toString();
                            }
                        })
                        .show(((AppCompatActivity) mContext).getSupportFragmentManager(), "");
            }
        });

        endDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePicker.Builder()
                        .id(1)
                        .build(new DateSetListener() {
                            @Override
                            public void onDateSet(int id, @Nullable Calendar calendar, int day, int month, int year) {
                                startdate = calendar.getTime().toString();
                            }
                        })
                        .show(((AppCompatActivity) mContext).getSupportFragmentManager(), "");
            }
        });


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, QrCodeActivity.class);
                intent.putExtra("phoneNum",editText.getText().toString());
                intent.putExtra("startingdate",startdate);
                intent.putExtra("endingDate",endDate);
                dismiss();
                mContext.startActivity(intent);
            }
        });
    }
}
