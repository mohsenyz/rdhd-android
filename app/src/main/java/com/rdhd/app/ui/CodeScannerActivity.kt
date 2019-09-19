package com.rdhd.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import android.widget.Toast
import com.google.zxing.Result
import com.rdhd.app.BaseActivity
import com.rdhd.app.R
import kotlinx.android.synthetic.main.activity_code_scanner.*
import me.dm7.barcodescanner.zxing.ZXingScannerView


class CodeScannerActivity : BaseActivity(), ZXingScannerView.ResultHandler {

    override fun handleResult(rawResult: Result?) {
        Toast.makeText(this, rawResult?.text, Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        scannerView.stopCamera();           // Stop camera on pause
    }


    override fun onResume() {
        super.onResume()
        scannerView.setResultHandler(this)
        scannerView.startCamera()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_code_scanner)

        close.setOnClickListener {
            finish()
        }
    }

}
