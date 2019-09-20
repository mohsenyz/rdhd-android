package com.rdhd.app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rdhd.app.BaseActivity
import com.rdhd.app.R
import com.rdhd.app.adapters.ServicesPagerAdapter
import kotlinx.android.synthetic.main.activity_service.*
import android.graphics.Typeface
import android.widget.TextView
import android.view.ViewGroup



class ServiceActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        viewPager.adapter = ServicesPagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)
        changeTabsFont()

        close.setOnClickListener {
            finish()
        }
    }


    private fun changeTabsFont() {
        val vg = tabLayout.getChildAt(0) as ViewGroup
        val typeface = Typeface.createFromAsset(getAssets(), "fonts/iran.ttf")
        val tabsCount = vg.childCount
        for (j in 0 until tabsCount) {
            val vgTab = vg.getChildAt(j) as ViewGroup
            val tabChildsCount = vgTab.childCount
            for (i in 0 until tabChildsCount) {
                val tabViewChild = vgTab.getChildAt(i)
                if (tabViewChild is TextView) {
                    tabViewChild.setTypeface(typeface, Typeface.NORMAL)
                }
            }
        }
    }
}
