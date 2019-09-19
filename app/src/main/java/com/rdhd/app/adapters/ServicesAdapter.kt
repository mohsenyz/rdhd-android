package com.rdhd.app.adapters

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rdhd.app.R
import com.rdhd.app.models.Service
import com.rdhd.app.utils.inflate
import kotlinx.android.synthetic.main.item_service.view.*

class ServicesAdapter(val list : List<Service>) : RecyclerView.Adapter<ServicesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.item_service, false)
        return ViewHolder(inflatedView)
    }

    val colors = listOf(Color.parseColor("#F44336"), Color.parseColor("#E91E63"), Color.parseColor("#9C27B0"), Color.parseColor("#8BC34A"), Color.parseColor("#009688"))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.icon.setImageResource(list[position].serviceIcon)
        holder.icon.setColorFilter(colors.shuffled()[0])
        holder.title.text = list[position].serviceName
    }

    open inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val icon = itemView.icon
        val title = itemView.caption
    }

}