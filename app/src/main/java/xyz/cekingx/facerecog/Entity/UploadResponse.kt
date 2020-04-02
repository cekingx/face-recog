package xyz.cekingx.facerecog.Entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import xyz.cekingx.facerecog.Entity.Riwayat

@Parcelize
data class UploadResponse(
    val nik: String,
    val nama: String,
    val tempat_lahir: String,
    val tanggal_lahir: String,
    val jenis_kelamin: String,
    val gol_darah: String,
    val kabupaten: String,
    val kecamatan: String,
    val desa: String,
    val alamat: String,
    val agama: String,
    val status_perkawinan: String,
    val pekerjaan: String,
    val kewarganegaraan: String,
    val confidence: String,
    val riwayat: ArrayList<Riwayat>
) : Parcelable