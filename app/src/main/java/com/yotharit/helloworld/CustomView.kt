package com.yotharit.helloworld

import android.annotation.TargetApi
import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View

class CustomView : View {

    private var isBlue: Boolean = false
    private var isDown: Boolean = false

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
        initWithAttrs(attrs, 0, 0)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
        initWithAttrs(attrs, defStyleAttr, 0)
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
            super(context, attrs, defStyleAttr, defStyleRes) {
        init()
        initWithAttrs(attrs, defStyleAttr, defStyleRes)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        var paint: Paint = Paint()
        paint.color = Color.RED
        if (isBlue) {
            paint.color = Color.BLUE
        }
        canvas.drawLine(0f, 0f, measuredWidth.toFloat(), measuredHeight.toFloat(), paint)
        if (isDown) {
            paint.color = Color.GREEN
            //Convert dp to pixel
            var px: Float = TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 5f, context.resources.displayMetrics)
            paint.strokeWidth = px

            //drawLine
            canvas.drawLine(0f,measuredHeight.toFloat(),measuredWidth.toFloat(),0f,paint)

        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event!!.action) {
            MotionEvent.ACTION_DOWN -> {
                isDown = true
                invalidate()
                return true
            }
//            MotionEvent.ACTION_MOVE ->
            MotionEvent.ACTION_UP -> {
                isDown = false
                invalidate()
                return true
            }
            MotionEvent.ACTION_CANCEL -> {
                isDown = false
                invalidate()
                return true
            }
        }

        return super.onTouchEvent(event)
    }

    private fun init() {

    }

    private fun initWithAttrs(attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        var a: TypedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.CustomView, defStyleAttr, defStyleRes)
        try {
            isBlue = a.getBoolean(R.styleable.CustomView_isBlue, false)
        } finally {
            a.recycle()
        }
    }

}