package com.rdhd.app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.rdhd.app.repositories.local.UserPrefs
import com.rdhd.app.ui.LoginActivity

import io.github.inflationx.viewpump.ViewPumpContextWrapper

open class BaseActivity(val requiresAuth : Boolean = false) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.enter, R.anim.exit)
        super.onCreate(savedInstanceState)
        if (requiresAuth) {
            if (!UserPrefs.isLoggedIn(this)) {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left)
    }


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}
