package com.rdhd.app.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rdhd.app.R
import com.rdhd.app.utils.inflate

class CurrentServiceAdapter() : RecyclerView.Adapter<CurrentServiceAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.item_current_service, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount() = 10

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

    open inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    }

}