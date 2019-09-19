package com.rdhd.app

import android.app.Activity
import android.os.Bundle
import com.airbnb.deeplinkdispatch.DeepLinkHandler
import com.rdhd.app.modules.AppDeepLinkModule
import com.rdhd.app.modules.AppDeepLinkModuleLoader

@DeepLinkHandler(AppDeepLinkModule::class)
class LinkDispatcher : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val deepLinkDelegate = DeepLinkDelegate(AppDeepLinkModuleLoader())
        deepLinkDelegate.dispatchFrom(this)
        finish()
    }

}