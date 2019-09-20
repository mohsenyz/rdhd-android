package com.rdhd.app.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import com.rdhd.app.BaseActivity
import com.rdhd.app.R
import com.rdhd.app.adapters.NewCardFormPagerAdapter
import com.rdhd.app.utils.TextWatch
import com.wajahatkarim3.easyflipview.EasyFlipView
import kotlinx.android.synthetic.main.activity_new_card.*
import kotlinx.android.synthetic.main.new_card_front.*



class NewCardActivity : BaseActivity(), TextWatch {

    lateinit var viewPagerAdapter : NewCardFormPagerAdapter

    override fun emit(value: String, type: String) {
        when (type) {
            "serial" -> {
                if (!value.isEmpty()) {
                    if (flip.currentFlipState == EasyFlipView.FlipState.FRONT_SIDE) flip.flipTheView()
                    if (value.length == 16) {
                        viewPager.setCurrentItem(viewPager.currentItem + 1)
                    }
                    var index = 0
                    var string = ""
                    while (index < value.length) {
                        string += value.substring(index, Math.min(index + 4, value.length)) + " "
                        index += 4
                    }
                    serialFront.text = string
                } else {
                    if (flip.currentFlipState == EasyFlipView.FlipState.BACK_SIDE) flip.flipTheView()
                }
            }
            "cvv2" -> {
                if (value.length == 4) {
                    viewPager.setCurrentItem(viewPager.currentItem + 1)
                }
                cvv2Front.text = value
            }
            "date" -> {
                if (value.contains("/") && value.length == 5) {
                    viewPager.setCurrentItem(viewPager.currentItem + 1)
                }
                expireTimeFront.text = value
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_card)
        viewPagerAdapter =  NewCardFormPagerAdapter(supportFragmentManager)
        viewPager.adapter = viewPagerAdapter
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        close.setOnClickListener {
            finish()
        }
    }
}
