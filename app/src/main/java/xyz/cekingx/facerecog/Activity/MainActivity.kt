package xyz.cekingx.facerecog.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import xyz.cekingx.facerecog.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nikIntent = Intent(this, NikInputActivity::class.java)
        val identificationIntent = Intent(this, IdentificationActivity::class.java)

        nik_button.setOnClickListener {
            startActivity(nikIntent)
        }

        identification_button.setOnClickListener {
            startActivity(identificationIntent)
        }
    }
}

