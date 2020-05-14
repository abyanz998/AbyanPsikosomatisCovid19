package com.example.psikosomatis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_welcome.*

class Welcome : AppCompatActivity() {
    private var backPressedTime: Long = 0                                                              // ini cumma buat nyimpen lama waktu
    internal lateinit var backToast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        login.setOnClickListener {
            startActivity(Intent(this, SignIn::class.java))
            finish()
        }

        signup.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }
    }

    override fun onBackPressed() {                                                                  // ini emang fungsi bawaan dengan isi super.onBackPressed() untuk keluar dari aplikasi
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel()
            super.onBackPressed()                                                                   // ini BAWAAN kalau kita tekan back dengan kondisi 1 maka akan langsung keluar

        } else {
            backToast = Toast.makeText(baseContext, "Tekan lagi untuk keluar dari aplikasi", Toast.LENGTH_LONG)
            backToast.setGravity(Gravity.TOP,0,140)
            backToast.show()
        }
        backPressedTime = System.currentTimeMillis()
    }
}
