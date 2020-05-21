package com.example.psikosomatis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_information1.*
import kotlinx.android.synthetic.main.activity_psiko.*
import org.json.JSONObject

class Psiko : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_psiko)
        val context = this

        btn_definisi.setOnClickListener {
            val intent = Intent(context, definisii::class.java)
            startActivity(intent)

        }

        btn_gejala.setOnClickListener {
            val intent = Intent(context, gejala::class.java)
            startActivity(intent)
            finish()
        }

        btn_mengatasi.setOnClickListener {
            val intent = Intent(context, mengatasii::class.java)
            startActivity(intent)
            finish()
        }
    }
}
