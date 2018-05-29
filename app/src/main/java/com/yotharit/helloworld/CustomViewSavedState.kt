package com.yotharit.helloworld

import android.annotation.TargetApi
import android.os.Build
import android.os.Parcel
import android.os.Parcelable
import android.view.View

class CustomViewSavedState : View.BaseSavedState {

    private var blue : Boolean = false

    fun isBlue() : Boolean {
        return blue
    }
    fun setBlue(blue : Boolean) {
        this.blue = blue
    }


    constructor(source: Parcel?) : super(source) {
        blue = source!!.readInt() == 1
    }
    constructor(superState: Parcelable) : super(superState)

    override fun writeToParcel(out: Parcel?, flags: Int) {
        super.writeToParcel(out, flags)
        out!!.writeInt(if(blue) 1 else 0)
    }



    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<CustomViewSavedState> {
            override fun createFromParcel(source: Parcel) = CustomViewSavedState(source)

            override fun newArray(size: Int) = arrayOfNulls<CustomViewSavedState>(size)
        }
    }

}