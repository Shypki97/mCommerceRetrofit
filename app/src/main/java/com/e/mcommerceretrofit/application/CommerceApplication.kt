package com.e.mcommerceretrofit.application

import android.app.Application

class CommerceApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        //InitializeDebug().init(this)
    }
}