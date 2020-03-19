package xyz.cekingx.facerecog

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UploadResponse(
    val nik: String,
    val nama: String,
    val tempat_lahir: String,
    val tanggal_lahir: String,
    val jenis_kelamin: String,
    val gol_darah: String,
    val alamat: String,
    val agama: String,
    val status_perkawinan: String,
    val pekerjaan: String,
    val kewarganegaraan: String,
    val confidence: String,
    val riwayat: ArrayList<Riwayat>
) : Parcelable