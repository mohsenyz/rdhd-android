package com.rdhd.app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.transition.TransitionManager
import com.google.android.material.snackbar.Snackbar
import com.rdhd.app.BaseActivity
import com.rdhd.app.R
import com.rdhd.app.adapters.CardListAdapter
import com.rdhd.app.fragments.NewCardFormFragment
import com.rdhd.app.models.BankCard
import com.rdhd.app.utils.SwipeToDeleteCallback
import kotlinx.android.synthetic.main.activity_card_management.*

class CardManagementActivity : BaseActivity() {


    lateinit var adapter : CardListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_management)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // @TODO What the fuck! Use repository, even for fake datas
        val cards = mutableListOf<BankCard>(
            BankCard("6037 9972 0829 2046", "test", "6564", 11, 99, "", false),
            BankCard("6037 9972 0829 2047", "test", "6564", 11, 99, "", false),
            BankCard("6037 9972 0829 2048", "test", "6564", 11, 99, "", false)
        )
        adapter = CardListAdapter(cards) { item ->
            TransitionManager.beginDelayedTransition(parentView)
            add.visibility = View.GONE
            Snackbar.make(parentView, "کارت بانکی پاک شد!", Snackbar.LENGTH_LONG)
                .setAction("بازگردانی", {
                    cards.add(item)
                    adapter.notifyItemInserted(cards.size - 2)
                }).show()
            Handler().postDelayed({
                TransitionManager.beginDelayedTransition(parentView)
                add.visibility = View.VISIBLE
            }, 3000)
        }
        recyclerView.adapter = adapter
        ItemTouchHelper(SwipeToDeleteCallback(adapter)).attachToRecyclerView(recyclerView)

        add.setOnClickListener {
            startActivity(Intent(this, NewCardActivity::class.java))
        }

        close.setOnClickListener {
            finish()
        }
    }
}
