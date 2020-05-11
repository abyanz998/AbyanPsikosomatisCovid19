package com.example.psikosomatis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_pertanyaan1.*

class Pertanyaan3 : AppCompatActivity() {

    lateinit var radioGroup7: RadioGroup
    lateinit var radioGroup8: RadioGroup
    lateinit var radioGroup9: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertanyaan3)

        var intent = intent
        val soal1 = intent.getStringExtra("soal1")
        val soal2 = intent.getStringExtra("soal2")
        val soal3 = intent.getStringExtra("soal3")
        val soal4 = intent.getStringExtra("soal4")
        val soal5 = intent.getStringExtra("soal5")
        val soal6 = intent.getStringExtra("soal6")
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        radioGroup7 = findViewById(R.id.rg_soal7)
        radioGroup8 = findViewById(R.id.rg_soal8)
        radioGroup9 = findViewById(R.id.rg_soal9)

        btn_next.setOnClickListener {
            val soal1 = soal1
            val soal2 = soal2
            val soal3 = soal3
            val soal4 = soal4
            val soal5 = soal5
            val soal6 = soal6
            val usernamee = username
            val passwordd = password

            val rgsoal7 = radioGroup7.checkedRadioButtonId
            val rg_soal7 = findViewById<RadioButton>(rgsoal7)
            val soal7 =rg_soal7.text.toString()

            val rgsoal8 = radioGroup8.checkedRadioButtonId
            val rg_soal8 = findViewById<RadioButton>(rgsoal8)
            val soal8 = rg_soal8.text.toString()

            val rgsoal9 = radioGroup9.checkedRadioButtonId
            val rg_soal9 = findViewById<RadioButton>(rgsoal9)
            val soal9 = rg_soal9.text.toString()

            val intent = Intent(this, Pertanyaan4::class.java)
            intent.putExtra("soal1", soal1)
            intent.putExtra("soal2", soal2)
            intent.putExtra("soal3", soal3)
            intent.putExtra("soal4", soal4)
            intent.putExtra("soal5", soal5)
            intent.putExtra("soal6", soal6)
            intent.putExtra("soal7", soal7)
            intent.putExtra("soal8", soal8)
            intent.putExtra("soal9", soal9)
            intent.putExtra("username", usernamee)
            intent.putExtra("password", passwordd)
            startActivity(intent)
            finish()
        }
    }
}
