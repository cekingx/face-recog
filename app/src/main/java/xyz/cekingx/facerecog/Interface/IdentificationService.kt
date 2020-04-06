package xyz.cekingx.facerecog.Interface

import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import xyz.cekingx.facerecog.Entity.IdentificationResponse
import java.util.concurrent.TimeUnit


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
            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()
            return Retrofit.Builder()
                .baseUrl("http://cekingx.xyz/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
                .create(IdentificationService::class.java)
        }
    }
}