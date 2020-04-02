package xyz.cekingx.facerecog.Interface

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import xyz.cekingx.facerecog.Entity.LoginRequest
import xyz.cekingx.facerecog.Entity.LoginResponse

interface LoginService {

    @POST("api/login")
    fun login(
        @Body
        user: LoginRequest
    ) : Call<LoginResponse>

    companion object {
        operator fun invoke(): LoginService {
            return Retrofit.Builder()
                .baseUrl("http://cekingx.xyz/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(LoginService::class.java)
        }
    }
}