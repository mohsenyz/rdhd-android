package com.rdhd.app.adapters

import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rdhd.app.R
import com.rdhd.app.models.BankCard
import com.rdhd.app.utils.fa
import com.rdhd.app.utils.inflate
import kotlinx.android.synthetic.main.item_card.view.*

class CardListAdapter(val list : MutableList<BankCard>, val onItemDeleted : (BankCard) -> Unit) : RecyclerView.Adapter<CardListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = parent.inflate(R.layout.item_card, false)
        return ViewHolder(inflatedView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val card = list[position]
        holder.serial.text = card.cardnumber!!.fa()
        holder.expireTime.text = card.year.toString().fa() + "/" + card.month.toString().fa()
        holder.cvv2.text = card.cv2!!.fa()
    }

    open inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val serial = itemView.serial
        val cvv2 = itemView.cvv2
        val expireTime = itemView.expireTime
    }

    fun deleteItem(pos : Int) {
        var item = list[pos]
        list.remove(item)
        notifyItemRemoved(pos)
        onItemDeleted(item) //@TODO and handle more
    }

}