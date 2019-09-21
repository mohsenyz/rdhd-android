package com.rdhd.app.ui

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.core.view.doOnLayout
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.deeplinkdispatch.DeepLink
import com.rdhd.app.BaseActivity
import com.rdhd.app.R
import com.rdhd.app.adapters.ServicesAdapter
import com.rdhd.app.dialogs.ServiceRequestDialog
import com.rdhd.app.models.GetService
import com.rdhd.app.models.Service
import com.rdhd.app.repositories.local.UserPrefs
import com.rdhd.app.utils.convertDpToPixel
import com.rdhd.app.utils.fa
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_home.linkBarSection
import kotlinx.android.synthetic.main.activity_home.nestedScrollView
import kotlinx.android.synthetic.main.activity_home.profileBtn
import kotlinx.android.synthetic.main.activity_home.services
import kotlinx.android.synthetic.main.activity_home.servicesRecyclerView
import kotlinx.android.synthetic.main.activity_home.topSection
import kotlinx.android.synthetic.main.activity_home.topSectionSyncValue
import kotlinx.android.synthetic.main.activity_home.topSectionSyncValue2
import kotlinx.android.synthetic.main.activity_home.topSectionValue2
import kotlinx.android.synthetic.main.provider_home_activity.*


@DeepLink("hpay://home")
class ProviderHomeActivity : BaseActivity(requiresAuth = true) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.provider_home_activity)

        initializeViews()
        requestPermissions()
        val fake = listOf<Service>(Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance))
        servicesRecyclerView.adapter = ServicesAdapter(fake)


        nestedScrollView.setOnTouchListener { v, event ->
            topSection.dispatchTouchEvent(event)
        }

    }

    private fun initializeViews() {

        topSection.doOnLayout {
            val parent = (linkBarSection.parent as ViewGroup)
            val layoutParam = parent.layoutParams as FrameLayout.LayoutParams
            layoutParam.topMargin = topSection.bottom - convertDpToPixel(24F, this).toInt()
            parent.layoutParams = layoutParam
        }

        servicesRecyclerView.layoutManager = GridLayoutManager(this, 3)

        profileBtn.setOnClickListener {
            startActivity(Intent(this, CardManagementActivity::class.java))
        }

        payments.setOnClickListener {
            startActivity(Intent(this, PaymentsActivity::class.java))
        }

        services.setOnClickListener {
            startActivity(Intent(this, ServicesActivity::class.java))
        }

        topSectionSyncValue.setOnClickListener {
            topSectionSyncValue.animate().setDuration(2000).rotation(720F).withEndAction {
                topSectionSyncValue.rotation = 0F
            }.start()
        }


        topSectionSyncValue2.setOnClickListener {
            topSectionSyncValue2.animate().setDuration(2000).rotation(720F).withEndAction {
                topSectionSyncValue2.rotation = 0F
            }.start()
        }

    }


    private fun requestPermissions() {
        ActivityCompat.requestPermissions(this, listOf(Manifest.permission.CAMERA).toTypedArray(), 0)
    }


    override fun onResume() {
        super.onResume()
        topSectionValue2.text = UserPrefs.score(this).toString().fa()
    }
}