package com.rdhd.app.adapters

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rdhd.app.R
import com.rdhd.app.models.BankCard
import com.rdhd.app.utils.fa
import com.rdhd.app.utils.inflate
import kotlinx.android.synthetic.main.item_card_select.view.*

class CardSelectAdapter(val list : List<BankCard>) : RecyclerView.Adapter<CardSelectAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.item_card_select, false)
        return ViewHolder(inflatedView)
    }

    val colors = listOf(Color.parseColor("#F44336"), Color.parseColor("#E91E63"), Color.parseColor("#9C27B0"), Color.parseColor("#8BC34A"), Color.parseColor("#009688"))

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = list[position]
        holder.serial.text = card.cardnumber!!.fa()
        holder.expireTime.text = card.year.toString().fa() + "/" + card.month.toString().fa()
        holder.checkbox.isChecked = card.checked
        holder.cvv2.text = card.cv2!!.fa()
        holder.checkbox.setOnCheckedChangeListener { buttonView, isChecked ->
            list[holder.adapterPosition].checked = isChecked
        }

        holder.itemView.setOnClickListener {
            holder.checkbox.isChecked = !holder.checkbox.isChecked
            list[holder.adapterPosition].checked = holder.checkbox.isChecked
        }
    }

    open inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val serial = itemView.serial
        val cvv2 = itemView.cvv2
        val expireTime = itemView.expireTime
        val checkbox = itemView.checkbox
    }

}