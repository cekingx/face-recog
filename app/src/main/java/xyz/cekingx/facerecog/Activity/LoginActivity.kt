package xyz.cekingx.facerecog.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import xyz.cekingx.facerecog.Entity.LoginRequest
import xyz.cekingx.facerecog.Entity.LoginResponse
import xyz.cekingx.facerecog.Interface.LoginService
import xyz.cekingx.facerecog.R
import xyz.cekingx.facerecog.snackbar

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val frombottom: Animation = AnimationUtils.loadAnimation(this,
            R.anim.frombottom
        )

        bgapp.animate().translationY((-1900).toFloat()).setDuration(800).setStartDelay(1300)
        textsplash.animate().translationY(140.toFloat()).alpha(0F).setDuration(800).setStartDelay(1300)

        texthome.startAnimation(frombottom)
        menus1.startAnimation(frombottom)

        login.setOnClickListener {
            val username = username.text.toString()
            val password = password.text.toString()
            val user = LoginRequest(username, password)
            login(user)
        }
    }

    private fun login(user: LoginRequest) {
        LoginService().login(
            user
        ).enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                login_root.snackbar("Something went wrong")
            }

            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                response.body()?.let {
                    if (it.status == "200") {
                        login_root.snackbar(it.status!!)
                        val intent = Intent(this@LoginActivity, MainActivity::class.java).apply {
                            putExtra("USERNAME", it.petugas!!.nama)
                        }

                        startActivity(intent)
                    } else if (it.status == "403") {
                        login_root.snackbar(it.error!!)
                    } else {
                        login_root.snackbar(it.error!!)
                    }
                }
            }
        })
    }
}
