package com.rdhd.app.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.ContentLoadingProgressBar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.rdhd.app.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class QrCodeActivity extends AppCompatActivity {

    AppCompatImageView qrCodeImageView;
    AppCompatTextView qrCodeTextView;
    ContentLoadingProgressBar contentLoadingProgressBar;
    ImageView saveImageView, shareImageView, printImageView, homeImageView;

    AppCompatImageButton backButton;

    Context context;

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        context = getApplicationContext();
        contentLoadingProgressBar = findViewById(R.id.progressBar);
        qrCodeImageView = findViewById(R.id.qr_code_img_view);
        qrCodeTextView = findViewById(R.id.qr_code_txt_view);
        saveImageView = findViewById(R.id.save_qr_code);
        shareImageView = findViewById(R.id.share_qr_code);
        printImageView = findViewById(R.id.print_qr_code);
        homeImageView = findViewById(R.id.share_qr_home);
        backButton = findViewById(R.id.appCompatImageButton3);

        contentLoadingProgressBar.show();
        String qrCodeString = randomAlphaNumeric(12);
        generateqrcode(qrCodeString);
        contentLoadingProgressBar.hide();

        //qrCodeTextView.setText(qrCodeString);

        homeImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(QrCodeActivity.this,HomeActivity.class));
            }
        });

        saveImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToGllery();
            }
        });

        shareImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void saveToGllery(){
        //ImageView imageView = ((ImageView)qrCodeImageView);
        qrCodeImageView.buildDrawingCache();
        Bitmap bmp = qrCodeImageView.getDrawingCache();
        File storageLoc = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES); //context.getExternalFilesDir(null);

        File file = new File(storageLoc, "HeyPay " + new Date().toString() + ".jpg");

        try{
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.close();

            scanFile(context, Uri.fromFile(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void scanFile(Context context, Uri imageUri){
        Intent scanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        scanIntent.setData(imageUri);
        context.sendBroadcast(scanIntent);

    }



    private void generateqrcode(String sample){
        qrCodeTextView.setText(sample);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(sample, BarcodeFormat.QR_CODE,1000,1000);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            qrCodeImageView.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }


    private void share(){
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Here is the share content body";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "اشتراک گذاری با "));
    }

}
