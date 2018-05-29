package com.yotharit.helloworld

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

@SuppressLint("ParcelCreator")
class CoordinateParcelazble() : Parcelable {

    public  var x : Int = 0
    public  var y : Int = 0
    public  var z : Int = 0

    constructor(parcel: Parcel) : this() {
        x = parcel.readInt()
        y = parcel.readInt()
        z = parcel.readInt()
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(x)
        dest.writeInt(y)
        dest.writeInt(z)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CoordinateParcelazble> {
        override fun createFromParcel(parcel: Parcel): CoordinateParcelazble {
            return CoordinateParcelazble(parcel)
        }

        override fun newArray(size: Int): Array<CoordinateParcelazble?> {
            return arrayOfNulls(size)
        }
    }


}