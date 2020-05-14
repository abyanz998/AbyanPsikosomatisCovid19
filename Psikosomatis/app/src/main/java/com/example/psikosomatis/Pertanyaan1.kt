package com.example.psikosomatis

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_pertanyaan1.*

class Pertanyaan1 : AppCompatActivity() {
    lateinit var radioGroup1: RadioGroup
    lateinit var radioGroup2: RadioGroup
    lateinit var radioGroup3: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertanyaan1)

        var intent = intent
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        radioGroup1 = findViewById(R.id.rg_soal1)
        radioGroup2 = findViewById(R.id.rg_soal2)
        radioGroup3 = findViewById(R.id.rg_soal3)


        btn_next.setOnClickListener {
            val usernamee = username
            val passwordd = password
            val rgsoal1 = radioGroup1.checkedRadioButtonId
            val rg_soal1 = findViewById<RadioButton>(rgsoal1)
            val soal1 =rg_soal1.text.toString()

            val rgsoal2 = radioGroup2.checkedRadioButtonId
            val rg_soal2 = findViewById<RadioButton>(rgsoal2)
            val soal2 = rg_soal2.text.toString()

            val rgsoal3 = radioGroup3.checkedRadioButtonId
            val rg_soal3 = findViewById<RadioButton>(rgsoal3)
            val soal3 = rg_soal3.text.toString()

            val intent = Intent(this, Pertanyaan2::class.java)
            intent.putExtra("soal1", soal1)
            intent.putExtra("soal2", soal2)
            intent.putExtra("soal3", soal3)
            intent.putExtra("username", usernamee)
            intent.putExtra("password", passwordd)
            startActivity(intent)
            finish()
        }
    }

}
