package com.example.psikosomatis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_pertanyaan1.*

class Pertanyaan4 : AppCompatActivity() {

    lateinit var radioGroup10: RadioGroup
    lateinit var radioGroup11: RadioGroup
    lateinit var radioGroup12: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertanyaan4)

        var intent = intent
        val soal1 = intent.getStringExtra("soal1")
        val soal2 = intent.getStringExtra("soal2")
        val soal3 = intent.getStringExtra("soal3")
        val soal4 = intent.getStringExtra("soal4")
        val soal5 = intent.getStringExtra("soal5")
        val soal6 = intent.getStringExtra("soal6")
        val soal7 = intent.getStringExtra("soal7")
        val soal8 = intent.getStringExtra("soal8")
        val soal9 = intent.getStringExtra("soal9")
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        radioGroup10 = findViewById(R.id.rg_soal10)
        radioGroup11 = findViewById(R.id.rg_soal11)
        radioGroup12 = findViewById(R.id.rg_soal12)

        btn_next.setOnClickListener {
            val soal1 = soal1
            val soal2 = soal2
            val soal3 = soal3
            val soal4 = soal4
            val soal5 = soal5
            val soal6 = soal6
            val soal7 = soal7
            val soal8 = soal8
            val soal9 = soal9
            val usernamee = username
            val passwordd = password

            val rgsoal10 = radioGroup10.checkedRadioButtonId
            val rg_soal0 = findViewById<RadioButton>(rgsoal10)
            val soal10 = rg_soal0.text.toString()

            val rgsoal11 = radioGroup11.checkedRadioButtonId
            val rg_soal11 = findViewById<RadioButton>(rgsoal11)
            val soal11 = rg_soal11.text.toString()

            val rgsoal2 = radioGroup12.checkedRadioButtonId
            val rg_soal12 = findViewById<RadioButton>(rgsoal2)
            val soal12 = rg_soal12.text.toString()


            val intent = Intent(this, Pertanyaan5::class.java)
            intent.putExtra("soal1", soal1)
            intent.putExtra("soal2", soal2)
            intent.putExtra("soal3", soal3)
            intent.putExtra("soal4", soal4)
            intent.putExtra("soal5", soal5)
            intent.putExtra("soal6", soal6)
            intent.putExtra("soal7", soal7)
            intent.putExtra("soal8", soal8)
            intent.putExtra("soal9", soal9)
            intent.putExtra("soal10", soal10)
            intent.putExtra("soal11", soal11)
            intent.putExtra("soal12", soal12)
            intent.putExtra("username", usernamee)
            intent.putExtra("password", passwordd)
            startActivity(intent)
            finish()
        }
    }
}
