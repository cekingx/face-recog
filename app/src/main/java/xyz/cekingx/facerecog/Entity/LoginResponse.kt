package xyz.cekingx.facerecog.Entity

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("status")
    var status: String? = null,

    @SerializedName("petugas")
    var petugas: Petugas? = null,

    @SerializedName("error")
    var error: String? = null
)