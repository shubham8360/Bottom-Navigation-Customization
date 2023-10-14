package com.project.test

import android.app.Application
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        val asyncHandler = EpoxyAsyncUtil.getAsyncBackgroundHandler()
        EpoxyController.defaultDiffingHandler = asyncHandler
    }
}