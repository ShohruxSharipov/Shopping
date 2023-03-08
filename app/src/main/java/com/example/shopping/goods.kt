package com.example.shopping

import android.os.Parcel
import android.os.Parcelable

data class goods(var img: String?, var name: String?, var cost: String?):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(img)
        parcel.writeString(name)
        parcel.writeString(cost)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<goods> {
        override fun createFromParcel(parcel: Parcel): goods {
            return goods(parcel)
        }

        override fun newArray(size: Int): Array<goods?> {
            return arrayOfNulls(size)
        }
    }

}