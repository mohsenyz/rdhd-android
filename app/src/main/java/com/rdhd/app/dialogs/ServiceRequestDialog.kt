package com.rdhd.app.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import com.rdhd.app.R

class ServiceRequestDialog(context : Context) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_service_request)
    }

}