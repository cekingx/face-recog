package xyz.cekingx.facerecog.Interface

import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import xyz.cekingx.facerecog.Entity.UploadResponse

interface MyAPI {

    @Multipart
    @POST("api/compare")
    fun uploadImage(
        @Part foto: MultipartBody.Part,
        @Part("nik") nik: RequestBody
    ): Call<UploadResponse>

    companion object {
        operator fun invoke(): MyAPI {
            return Retrofit.Builder()
                .baseUrl("http://157.230.247.169/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyAPI::class.java)
        }
    }
}