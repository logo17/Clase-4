package com.loguito.clase4.views.models

import android.os.Parcel
import android.os.Parcelable

// TODO 3: Creamos el modelo de información
data class UserInformation(val name: String, val email: String, val imageUrl: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(imageUrl)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserInformation> {
        override fun createFromParcel(parcel: Parcel): UserInformation {
            return UserInformation(parcel)
        }

        override fun newArray(size: Int): Array<UserInformation?> {
            return arrayOfNulls(size)
        }
    }
}