package xyz.cekingx.facerecog.Interface

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import xyz.cekingx.facerecog.Entity.IdentificationResponse

interface IdentificationService {

    @Multipart
    @POST("/api/identifikasi")
    fun uploadImage(
        @Part foto: MultipartBody.Part,
        @Part("kecamatan") kecamatan: RequestBody,
        @Part("tanggal_lahir") tanggal_lahir: RequestBody
    ): Call<IdentificationResponse>

    companion object {
        operator fun invoke(): IdentificationService {
            return Retrofit.Builder()
                .baseUrl("http://cekingx.xyz/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IdentificationService::class.java)
        }
    }
}