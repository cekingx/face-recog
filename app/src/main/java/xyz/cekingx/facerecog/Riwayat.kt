package xyz.cekingx.facerecog

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Riwayat (
    val riwayat_tinggal: String
) : Parcelable