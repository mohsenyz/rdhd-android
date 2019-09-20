package com.rdhd.app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.core.view.doOnLayout
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.deeplinkdispatch.DeepLink
import com.rdhd.app.BaseActivity
import com.rdhd.app.R
import com.rdhd.app.adapters.ServicesAdapter
import com.rdhd.app.dialogs.ServiceRequestDialog
import com.rdhd.app.models.Service
import com.rdhd.app.utils.convertDpToPixel
import kotlinx.android.synthetic.main.activity_home.*


@DeepLink("hpay://home")
class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        topSection.doOnLayout {
            val parent = (linkBarSection.parent as ViewGroup)
            val layoutParam = parent.layoutParams as FrameLayout.LayoutParams
            layoutParam.topMargin = topSection.bottom - convertDpToPixel(4F, this).toInt()
            parent.layoutParams = layoutParam
        }

        servicesRecyclerView.layoutManager = GridLayoutManager(this, 3)
        val fake = listOf<Service>(Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance),Service("بیمه", R.drawable.insurance))
        servicesRecyclerView.adapter = ServicesAdapter(fake)
        services_layout.setOnClickListener{
            startActivity(Intent(this,ServicesActivity::class.java))
        }



        startActivity(Intent(this, CodeScannerActivity::class.java))

        ServiceRequestDialog(this).show()

        qr_code_reader_layout.setOnClickListener {
            startActivity(Intent(this,QrCodeActivity::class.java))
        }

    }
}
