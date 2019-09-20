package com.rdhd.app.dialogs

import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.rdhd.app.R
import com.rdhd.app.adapters.CardSelectAdapter
import com.rdhd.app.models.BankCard
import kotlinx.android.synthetic.main.card_selector_bsf.*
import kotlinx.android.synthetic.main.card_selector_bsf.view.*
import kotlinx.android.synthetic.main.dialog_service_request.*

class CardSelectorBottomSheetFragment(val onItemSelected : (List<String>) -> Unit, val selectedItems : List<String> = listOf()) : BottomSheetDialogFragment() {

    lateinit var recyclerView: RecyclerView
    var cards : List<BankCard>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.card_selector_bsf, container, false)
        recyclerView = view.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        cards = listOf<BankCard>(BankCard("6037 9972 0829 2046", "test", "6564", 11, 99, "", false),
            BankCard("6037 9972 0829 2047", "test", "6564", 11, 99, "", false),
            BankCard("6037 9972 0829 2048", "test", "6564", 11, 99, "", false))
        for (item in selectedItems) {
            cards!!.find { it.cardnumber == item }!!.checked = true
        }
        recyclerView.adapter = CardSelectAdapter(cards!!)
        return view
    }


    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
        onItemSelected(cards!!.filter { it.checked }.map { it.cardnumber!! })
    }

}