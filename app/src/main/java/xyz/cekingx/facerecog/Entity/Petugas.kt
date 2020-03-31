package xyz.cekingx.facerecog.Entity

import com.google.gson.annotations.SerializedName

data class Petugas (
    @SerializedName("nama")
    var nama: String = "",

    @SerializedName("instansi")
    var instansi: String = "",

    @SerializedName("username")
    var username: String = "",

    @SerializedName("password")
    var password: String = ""
)