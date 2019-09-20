package com.rdhd.app.dialogs

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import com.rdhd.app.R
import com.rdhd.app.models.GetService
import com.rdhd.app.utils.fa
import kotlinx.android.synthetic.main.dialog_service_request.*
import kotlinx.android.synthetic.main.dialog_service_request.view.*
import saman.zamani.persiandate.PersianDate
import saman.zamani.persiandate.PersianDateFormat
import kotlin.math.floor
import androidx.appcompat.app.AppCompatActivity


class ServiceRequestDialog(val mContext : Context, val service : GetService, val onRejectListener : () -> Unit = {}, val onAcceptListener : () -> Unit = {}) : Dialog(mContext) {

    var selectedCards = listOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_service_request)
        with(window) {
            setBackgroundDrawable(ColorDrawable(0))
            setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            setGravity(Gravity.CENTER)
        }

        titleView.text = service.name
        value_1.text = service.pricepp!!.fa() + " ریال هر " + service.period!!.fa() + " روز"
        val dateFormat = PersianDateFormat("Y/m/j")
        val fromDate = PersianDate(service.starttime)
        val toDate = PersianDate(service.endtime)
        value_2.text = "از " + dateFormat.format(fromDate).fa() + " تا " + dateFormat.format(toDate).fa()
        value_3.text = floor((service.endtime - service.starttime).toDouble() / (24 * 3600 * 1000)).toString().fa() + " روز"
        value_4.text = service.price.toString().fa()

        button.setOnClickListener {
            val bs = CardSelectorBottomSheetFragment({
                selectedCards = it
                if (it.size == 0) {
                    button.text = "انتخاب کارت"
                } else {
                    button.text = it.size.toString().fa() + " کارت بانکی انتخاب شد"
                }
            }, selectedCards)
            bs.show((mContext as AppCompatActivity).supportFragmentManager, bs.getTag())
        }


        cancel.setOnClickListener {
            onRejectListener()
        }

        submit.setOnClickListener {
            if (selectedCards.size == 0) {
                Toast.makeText(context!!, "شما باید حداقل یک کارت را انتخاب کنید", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            onAcceptListener()
        }
    }

}