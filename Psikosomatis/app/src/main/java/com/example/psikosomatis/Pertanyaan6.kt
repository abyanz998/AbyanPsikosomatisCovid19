package com.example.psikosomatis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_pertanyaan1.*

class Pertanyaan6 : AppCompatActivity() {
    lateinit var radioGroup16: RadioGroup
    lateinit var radioGroup17: RadioGroup
    lateinit var radioGroup18: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertanyaan6)

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
        val soal10 = intent.getStringExtra("soal10")
        val soal11 = intent.getStringExtra("soal11")
        val soal12 = intent.getStringExtra("soal12")
        val soal13 = intent.getStringExtra("soal13")
        val soal14 = intent.getStringExtra("soal14")
        val soal15 = intent.getStringExtra("soal15")
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        radioGroup16 = findViewById(R.id.rg_soal16)
        radioGroup17 = findViewById(R.id.rg_soal17)
        radioGroup18 = findViewById(R.id.rg_soal18)

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
            val soal10 = soal10
            val soal11 = soal11
            val soal12 = soal12
            val soal13 = soal13
            val soal14 = soal14
            val soal15 = soal15
            val usernamee = username
            val passwordd = password

            val rgsoal16 = radioGroup16.checkedRadioButtonId
            val rg_soal6 = findViewById<RadioButton>(rgsoal16)
            val soal16 = rg_soal6.text.toString()

            val rgsoal17 = radioGroup17.checkedRadioButtonId
            val rg_soal17 = findViewById<RadioButton>(rgsoal17)
            val soal17 = rg_soal17.text.toString()

            val rgsoal18 = radioGroup18.checkedRadioButtonId
            val rg_soal18 = findViewById<RadioButton>(rgsoal18)
            val soal18 = rg_soal18.text.toString()

            val intent = Intent(this, hasil::class.java)
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
            intent.putExtra("soal13", soal13)
            intent.putExtra("soal14", soal14)
            intent.putExtra("soal15", soal15)
            intent.putExtra("soal16", soal16)
            intent.putExtra("soal17", soal17)
            intent.putExtra("soal18", soal18)
            intent.putExtra("username", usernamee)
            intent.putExtra("password", passwordd)
            startActivity(intent)
            finish()
        }

    }
}
