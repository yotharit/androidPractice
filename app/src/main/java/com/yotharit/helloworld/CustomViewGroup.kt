package com.yotharit.helloworld

import android.annotation.TargetApi
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.util.AttributeSet
import android.util.SparseArray
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import BundleSavedState

class CustomViewGroup : FrameLayout {

    private lateinit var btnHello: Button

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
        View.inflate(context, R.layout.sample_layout, this)
    }

    private fun initInstance() {
        btnHello = findViewById(R.id.btnCustomViewGroupHello)
    }

    public fun setButtonText(text: String) {
        btnHello.text = text
    }

    override fun dispatchSaveInstanceState(container: SparseArray<Parcelable>?) {
        dispatchFreezeSelfOnly(container)
    }

    override fun dispatchRestoreInstanceState(container: SparseArray<Parcelable>?) {
        dispatchThawSelfOnly(container)
    }

    override fun onSaveInstanceState(): Parcelable {
        var superState: Parcelable = super.onSaveInstanceState()

        var childrenStates: Bundle = Bundle()
        var i: Int = 0
        while (i < childCount) {
            var id: Int = getChildAt(i).id
            if (id != 0) {
                var childrenState: SparseArray<Parcelable> = SparseArray()
                getChildAt(i).saveHierarchyState(childrenState)
                childrenStates.putSparseParcelableArray(id.toString(), childrenState)
            }
        }
        var bundle: Bundle = Bundle()
        bundle.putBundle("childrenStates",childrenStates)

        var ss : BundleSavedState = BundleSavedState(superState)
        ss.setBundle(bundle)
        return ss
    }


    override fun onRestoreInstanceState(state: Parcelable?) {
        var ss : BundleSavedState = state as BundleSavedState
        super.onRestoreInstanceState(ss.superState)

        var childrenStates : Bundle = ss.getBundle().getBundle("childrenStates")
        var i : Int = 0
        while(i<childCount) {
            var id : Int = getChildAt(i).id
            if(id!=0) {
                if(childrenStates.containsKey(id.toString())) {
                    var childrenState:SparseArray<Parcelable> = childrenStates.getSparseParcelableArray(id.toString())
                    getChildAt(i).restoreHierarchyState(childrenState)
                }
            }
        }
    }
}