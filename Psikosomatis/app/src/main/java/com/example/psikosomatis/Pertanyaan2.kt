package com.example.psikosomatis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_pertanyaan1.*

class Pertanyaan2 : AppCompatActivity() {

    lateinit var radioGroup4: RadioGroup
    lateinit var radioGroup5: RadioGroup
    lateinit var radioGroup6: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertanyaan2)
        var intent = intent
        val soal1 = intent.getStringExtra("soal1")
        val soal2 = intent.getStringExtra("soal2")
        val soal3 = intent.getStringExtra("soal3")
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        radioGroup4 = findViewById(R.id.rg_soal4)
        radioGroup5 = findViewById(R.id.rg_soal5)
        radioGroup6 = findViewById(R.id.rg_soal6)

        btn_next.setOnClickListener {
            val soal1 = soal1
            val soal2 = soal2
            val soal3 = soal3
            val usernamee = username
            val passwordd = password
            val rgsoal4 = radioGroup4.checkedRadioButtonId
            val rg_soal4 = findViewById<RadioButton>(rgsoal4)
            val soal4 =rg_soal4.text.toString()

            val rgsoal5 = radioGroup5.checkedRadioButtonId
            val rg_soal5 = findViewById<RadioButton>(rgsoal5)
            val soal5 = rg_soal5.text.toString()

            val rgsoal6 = radioGroup6.checkedRadioButtonId
            val rg_soal6 = findViewById<RadioButton>(rgsoal6)
            val soal6 = rg_soal6.text.toString()
            val intent = Intent(this, Pertanyaan3::class.java)
            intent.putExtra("soal1", soal1)
            intent.putExtra("soal2", soal2)
            intent.putExtra("soal3", soal3)
            intent.putExtra("soal4", soal4)
            intent.putExtra("soal5", soal5)
            intent.putExtra("soal6", soal6)
            intent.putExtra("username", usernamee)
            intent.putExtra("password", passwordd)
            startActivity(intent)
            finish()
        }
    }
}
