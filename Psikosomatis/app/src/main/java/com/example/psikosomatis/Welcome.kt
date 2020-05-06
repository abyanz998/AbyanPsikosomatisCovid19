package com.example.psikosomatis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome.*

class Welcome : AppCompatActivity() {

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
}
