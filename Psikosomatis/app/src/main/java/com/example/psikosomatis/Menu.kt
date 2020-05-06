package com.example.psikosomatis

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var intent = intent
        val nama = intent.getStringExtra("nama")
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        // ini fungsi untuk keluar/ LOGOUT
        btn_logout.setOnClickListener{
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()
            val context = this
            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(context, Welcome::class.java))
            finish()
        }

        btn_psiko.setOnClickListener {
            val context = this
            startActivity(Intent(context, Psiko::class.java))
        }

        btn_tes.setOnClickListener {
            val context = this
            val usernamee = username
            val passwordd = password
            val intent = Intent(context, Pertanyaan1::class.java)
            intent.putExtra("username", usernamee)
            intent.putExtra("password", passwordd)
            startActivity(intent)
        }

    }
}
