package com.rdhd.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseArray
import android.widget.Toast
import com.google.zxing.Result
import com.rdhd.app.BaseActivity
import com.rdhd.app.R
import com.rdhd.app.dialogs.ServiceRequestDialog
import com.rdhd.app.models.GetService
import com.rdhd.app.repositories.RetrofitClient
import com.rdhd.app.repositories.local.UserPrefs
import kotlinx.android.synthetic.main.activity_code_scanner.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CodeScannerActivity : BaseActivity(), ZXingScannerView.ResultHandler {

    override fun handleResult(rawResult: Result?) {
        //fetchService(rawResult!!.text)

        // @TODO Fix this bullshit, Fuck the time
        ServiceRequestDialog(this, GetService(name = "بیمه تعاون",
            price = "20000",
            pricepp = "200",
            period = "7",
            id = "hasani",
            starttime = System.currentTimeMillis(),
            endtime = System.currentTimeMillis() + 24 * 3600 * 1000
        ), {
            finish()
        }, {
            UserPrefs.increaseScore(this, 100)
            Toast.makeText(this, "درخواست شما ثبت شد!", Toast.LENGTH_SHORT).show()
            finish()
        }).show()
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


    private fun fetchService(serviceId : String) {
        RetrofitClient.getmInstance().api.getGetService(serviceId).enqueue(object : Callback<List<GetService>> {
            override fun onFailure(call: Call<List<GetService>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<GetService>>,
                response: Response<List<GetService>>
            ) {
                val body = response.body()!!
                val getService = GetService(name = body[0]!!.name,
                    price = body[0]!!.price,
                    pricepp = body[0]!!.pricepp,
                    period = body[0]!!.period,
                    id = body[1]!!.id,
                    starttime = body[0].starttime,
                    endtime = body[0].endtime
                    )
            }

        })
    }

}
