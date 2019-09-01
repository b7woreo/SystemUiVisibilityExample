package com.chrnie.demo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.FrameLayout
import com.chrnie.demo.R

class DrawWindowsInsetsLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    var leftDrawable: Drawable? = null
        set(value) {
            field = value
            invalidate()
        }

    var rightDrawable: Drawable? = null
        set(value) {
            field = value
            invalidate()
        }

    var topDrawable: Drawable? = null
        set(value) {
            field = value
            invalidate()
        }

    var bottomDrawable: Drawable? = null
        set(value) {
            field = value
            invalidate()
        }

    init {
        setWillNotDraw(false)

        val typedArray = context.theme.obtainStyledAttributes(
            attrs, R.styleable.DrawWindowsInsetsLayout, defStyleAttr, 0
        )

        leftDrawable =
            typedArray.getDrawable(R.styleable.DrawWindowsInsetsLayout_leftWindowsInsetsDrawable)
        rightDrawable =
            typedArray.getDrawable(R.styleable.DrawWindowsInsetsLayout_rightWindowsInsetsDrawable)
        topDrawable =
            typedArray.getDrawable(R.styleable.DrawWindowsInsetsLayout_topWindowsInsetsDrawable)
        bottomDrawable =
            typedArray.getDrawable(R.styleable.DrawWindowsInsetsLayout_bottomWindowsInsetsDrawable)

        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val width = width
        val height = height

        if (paddingLeft > 0 && leftDrawable != null) {
            leftDrawable!!.apply {
                setBounds(0, 0, paddingLeft, height)
                draw(canvas)
            }
        }

        if (paddingRight > 0 && rightDrawable != null) {
            rightDrawable!!.apply {
                setBounds(width - paddingRight, 0, width, height)
                draw(canvas)
            }
        }

        if (paddingTop > 0 && topDrawable != null) {
            topDrawable!!.apply {
                setBounds(0, 0, width, paddingTop)
                draw(canvas)
            }
        }

        if (paddingBottom > 0 && bottomDrawable != null) {
            bottomDrawable!!.apply {
                setBounds(0, height - paddingBottom, width, height)
                draw(canvas)
            }
        }
    }
}
