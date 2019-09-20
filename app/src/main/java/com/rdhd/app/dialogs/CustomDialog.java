package com.rdhd.app.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.alirezaafkar.sundatepicker.DatePicker;
import com.alirezaafkar.sundatepicker.interfaces.DateSetListener;
import com.rdhd.app.R;
import com.rdhd.app.models.ProviderService;
import com.rdhd.app.repositories.interfaces.SubmitDialog;

import java.util.Calendar;

public class CustomDialog extends Dialog {
    Button startDate;
    private Context context;
    private SubmitDialog submitDialogListener;
    private ProviderService mProviderService;

    //fields
    EditText serviceName, servicePeriod, servicePrice, serviceCol;
    Button confirm, cancel;
    public CustomDialog(@NonNull Context context, SubmitDialog submitDialogListener) {
        super(context);
        this.context=context;
        this.submitDialogListener = submitDialogListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.new_provider_service_dialog);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));

        serviceName = findViewById(R.id.editTextServiceName);
        Toast.makeText(context, "in dialog"+ serviceName.getText().toString(), Toast.LENGTH_SHORT).show();
        servicePeriod = findViewById(R.id.editTextServicePeriod);
        servicePrice = findViewById(R.id.editTextServicePrice);
        serviceCol = findViewById(R.id.editTextServiceCol);
        confirm = findViewById(R.id.dialog_confirm);
        cancel = findViewById(R.id.dialog_cancel);


         mProviderService = new ProviderService(serviceName.getText().toString()
                ,"",servicePrice.getText().toString()
                ,servicePeriod.getText().toString(),"",serviceCol.getText().toString());

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "in dialog"+ serviceName.getText().toString(), Toast.LENGTH_SHORT).show();
                mProviderService = new ProviderService(serviceName.getText().toString()
                        ,"",servicePrice.getText().toString()
                        ,servicePeriod.getText().toString(),"",serviceCol.getText().toString());
                submitDialogListener.OnSubmitListener(mProviderService);
                dismiss();
            }
        });




        //startDate = findViewById(R.id.start_date_picker);

//        startDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                new DatePicker.Builder()
//                        .id(1)
//                        .build(new DateSetListener() {
//                            @Override
//                            public void onDateSet(int id, @Nullable Calendar calendar, int day, int month, int year) {
//
//                            }
//                        })
//                        .show(((AppCompatActivity) context).getSupportFragmentManager(), "");
//            }
//        });

    }
}
