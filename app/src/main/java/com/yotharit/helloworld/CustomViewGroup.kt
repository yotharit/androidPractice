package com.yotharit.helloworld

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.FrameLayout

class CustomViewGroup : FrameLayout {

    private lateinit var btnHello : Button

    constructor(context: Context?) : super(context) {
        initInflate()
        initInstance()
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initInflate()
        initInstance()
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initInflate()
        initInstance()
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) :
            super(context, attrs, defStyleAttr, defStyleRes) {
        initInflate()
        initInstance()
    }

    private fun initInflate() {
        View.inflate(context,R.layout.sample_layout,this)
    }
    private fun initInstance() {
        btnHello = findViewById(R.id.btnCustomViewGroupHello)
    }

    public fun setButtonText(text:String) {
        btnHello.text = text
    }
}