package com.chrnie.demo.lean.back

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import com.chrnie.demo.BaseActivity
import com.chrnie.demo.R
import kotlinx.android.synthetic.main.activity_lean_back_mode.*
import kotlinx.android.synthetic.main.activity_lean_back_mode.view.*

class LeanBackModeActivity : BaseActivity() {

    private val shadowDrawable by lazy {
        ColorDrawable(
            resources.getColor(R.color.colorShade)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lean_back_mode)

        window.decorView.apply {
            setOnSystemUiVisibilityChangeListener { visibility ->
                if (visibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                    root_view.topDrawable = shadowDrawable
                    root_view.bottomDrawable = shadowDrawable
                    title_bar.visibility = View.VISIBLE
                    bottom_bar.visibility = View.VISIBLE
                } else {
                    root_view.topDrawable = null
                    root_view.bottomDrawable = null
                    title_bar.visibility = View.INVISIBLE
                    bottom_bar.visibility = View.INVISIBLE
                }
            }
        }

        root_view.setOnClickListener { toggleSystemUI() }
        showSystemUI()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            showSystemUI()
        }
    }

    private fun toggleSystemUI() = with(window.decorView) {
        if (systemUiVisibility and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
            showSystemUI()
        } else {
            hideSystemUI()
        }
    }

    private fun showSystemUI(): Unit = with(window.decorView) {
        systemUiVisibility = (systemUiVisibility
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION)
    }

    private fun hideSystemUI(): Unit = with(window.decorView) {
        systemUiVisibility = (systemUiVisibility
                and View.SYSTEM_UI_FLAG_FULLSCREEN.inv()
                and View.SYSTEM_UI_FLAG_HIDE_NAVIGATION.inv())
    }
}
