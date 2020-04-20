package com.example.psikosomatis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_information1.*

class Information1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information1)

        val context = this

        balik.setOnClickListener {
            val intent = Intent(context, Information2::class.java)
            startActivity(intent)
        }
    }
}
