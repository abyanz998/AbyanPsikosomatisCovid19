package com.example.psikosomatis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_pertanyaan1.*

class Pertanyaan5 : AppCompatActivity() {

    lateinit var radioGroup13: RadioGroup
    lateinit var radioGroup14: RadioGroup
    lateinit var radioGroup15: RadioGroup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pertanyaan5)

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
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        radioGroup13 = findViewById(R.id.rg_soal13)
        radioGroup14 = findViewById(R.id.rg_soal14)
        radioGroup15 = findViewById(R.id.rg_soal15)

        btn_next.setOnClickListener {

            val usernamee = username
            val passwordd = password

            val rgsoal13 = radioGroup13.checkedRadioButtonId
            val rg_soal3 = findViewById<RadioButton>(rgsoal13)
            val soal13 = rg_soal3.text.toString()

            val rgsoal14 = radioGroup14.checkedRadioButtonId
            val rg_soal14 = findViewById<RadioButton>(rgsoal14)
            val soal14 = rg_soal14.text.toString()

            val rgsoal15 = radioGroup15.checkedRadioButtonId
            val rg_soal15 = findViewById<RadioButton>(rgsoal15)
            val soal15 = rg_soal15.text.toString()



            val intent = Intent(this, Pertanyaan6::class.java)
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
            intent.putExtra("username", usernamee)
            intent.putExtra("password", passwordd)
            startActivity(intent)
            finish()
        }
    }
}
