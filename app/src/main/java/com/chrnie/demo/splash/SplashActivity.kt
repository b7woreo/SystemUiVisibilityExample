package com.chrnie.demo.splash

import android.content.Intent
import android.os.Bundle
import com.chrnie.demo.BaseActivity
import com.chrnie.demo.R
import com.chrnie.demo.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        root_view.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
