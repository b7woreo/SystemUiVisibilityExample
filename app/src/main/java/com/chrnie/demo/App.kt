package com.chrnie.demo

import android.app.Application

class App : Application(){

    override fun onCreate() {
        // mock app launch execute blocking operation
        Thread.sleep(2000)
        super.onCreate()
    }
}
