import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View

class BundleSavedState : View.BaseSavedState {

    private lateinit var bundle : Bundle

    fun getBundle() : Bundle {
        return bundle
    }
    fun setBundle(bundle : Bundle) {
        this.bundle = bundle
    }


    constructor(source: Parcel?) : super(source) {
        bundle = source!!.readBundle()
    }

    constructor(superState: Parcelable?) : super(superState)

    override fun writeToParcel(out: Parcel?, flags: Int) {
        super.writeToParcel(out, flags)
        out!!.writeBundle(bundle)
    }

    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<BundleSavedState> {
            override fun createFromParcel(source: Parcel) = BundleSavedState(source)

            override fun newArray(size: Int) = arrayOfNulls<BundleSavedState>(size)
        }
    }

}