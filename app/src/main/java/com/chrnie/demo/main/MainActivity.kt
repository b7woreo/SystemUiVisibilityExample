package com.chrnie.demo.main

import android.content.Intent
import android.os.Bundle
import com.chrnie.demo.BaseActivity
import com.chrnie.demo.R
import com.chrnie.demo.lean.back.LeanBackModeActivity
import com.chrnie.demo.splash.SplashActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_toggle_status_bar_visible.setOnClickListener {
            startActivity(Intent(this, LeanBackModeActivity::class.java))
        }
    }
}
