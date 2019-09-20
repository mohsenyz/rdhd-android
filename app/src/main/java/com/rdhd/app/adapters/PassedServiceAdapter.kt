package com.rdhd.app.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rdhd.app.R
import com.rdhd.app.models.BankCard
import com.rdhd.app.utils.fa
import com.rdhd.app.utils.inflate
import kotlinx.android.synthetic.main.item_card.view.*


class PassedServiceAdapter() : RecyclerView.Adapter<PassedServiceAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.item_passed_service, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    open inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    }

}