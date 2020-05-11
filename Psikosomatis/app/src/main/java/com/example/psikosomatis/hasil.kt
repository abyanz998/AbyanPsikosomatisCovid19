package com.example.psikosomatis

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_hasil.*
import kotlinx.android.synthetic.main.activity_login.*
import org.json.JSONObject

class hasil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)
        var intent = intent
        var soal1 = intent.getStringExtra("soal1")
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
        val soal16 = intent.getStringExtra("soal16")
        val soal17 = intent.getStringExtra("soal17")
        val soal18 = intent.getStringExtra("soal18")
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        val context = this

        //textview buat nampilin doang tapi ga pake juga gapapa kalo buat API
        val satu = findViewById<TextView>(R.id.satu)
        satu.text = soal1
        val dua = findViewById<TextView>(R.id.dua)
        dua.text = soal2
        val tiga = findViewById<TextView>(R.id.tiga)
        tiga.text = soal3
        val empat = findViewById<TextView>(R.id.empat)
        empat.text = soal4
        val lima = findViewById<TextView>(R.id.lima)
        lima.text = soal5
        val enam = findViewById<TextView>(R.id.enam)
        enam.text = soal6
        val tujuh = findViewById<TextView>(R.id.tujuh)
        tujuh.text = soal7
        val delapan = findViewById<TextView>(R.id.delapan)
        delapan.text = soal8
        val sembilan = findViewById<TextView>(R.id.sembilan)
        sembilan.text = soal9
        val sepuluh = findViewById<TextView>(R.id.sepuluh)
        sepuluh.text = soal10
        val sebelas = findViewById<TextView>(R.id.sebelas)
        sebelas.text = soal11
        val duabelas = findViewById<TextView>(R.id.duabelas)
        duabelas.text = soal12
        val tigabelas = findViewById<TextView>(R.id.tigabelas)
        tigabelas.text = soal13
        val empatbelas = findViewById<TextView>(R.id.empatbelas)
        empatbelas.text = soal14
        val limabelas = findViewById<TextView>(R.id.limabelas)
        limabelas.text = soal15
        val enambelas = findViewById<TextView>(R.id.enambelas)
        enambelas.text = soal16
        val tujuhbelas = findViewById<TextView>(R.id.tujuhbelas)
        tujuhbelas.text = soal17
        val delapanbelas = findViewById<TextView>(R.id.delapanbelas)
        delapanbelas.text = soal18

        var nomor1: Int = 0
        var nomor2: Int = 0
        var nomor3: Int = 0
        var nomor4: Int = 0
        var nomor5: Int = 0
        var nomor6: Int = 0
        var nomor7: Int = 0
        var nomor8: Int = 0
        var nomor9: Int = 0
        var nomor10: Int = 0
        var nomor11: Int = 0
        var nomor12: Int = 0
        var nomor13: Int = 0
        var nomor14: Int = 0
        var nomor15: Int = 0
        var nomor16: Int = 0
        var nomor17: Int = 0
        var nomor18: Int = 0

        var usernamee = username
        var passwordd = password

        val ya: String = "Ya"

        val skor2: Double

        val persen: Double

        val ringan: Double = 33.333

        val sedang: Double = 66.666

        val total: Double = 100.0


        postkerserver(usernamee, passwordd)

        // ini perhitungan skor butir
        if (soal1 == ya)
            nomor1 = 1
        else
            nomor1 = 0


        if (soal2 == ya) {
            nomor2 = 1
        } else {
            nomor2 = 0
        }

        if (soal3 == ya) {
            nomor3 = 0
        } else {
            nomor3 = 1
        }

        if (soal4 == ya) {
            nomor4 = 1
        } else {
            nomor4 = 0
        }

        if (soal5 == ya) {
            nomor5 = 1
        } else {
            nomor5 = 0
        }

        if (soal6 == ya) {
            nomor6 = 1
        } else {
            nomor6 = 0
        }

        if (soal7 == ya) {
            nomor7 = 0
        } else {
            nomor7 = 1
        }

        if (soal8 == ya) {
            nomor8 = 1
        } else {
            nomor8 = 0
        }

        if (soal9 == ya) {
            nomor9 = 1
        } else {
            nomor9 = 0
        }

        if (soal10 == ya) {
            nomor10 = 1
        } else {
            nomor10 = 0
        }

        if (soal11 == ya) {
            nomor11 = 1
        } else {
            nomor11 = 0
        }

        if (soal12 == ya) {
            nomor12 = 1
        } else {
            nomor12 = 0
        }

        if (soal3 == ya) {
            nomor13 = 1
        } else {
            nomor13 = 0
        }

        if (soal14 == ya) {
            nomor14 = 1
        } else {
            nomor14 = 0
        }

        if (soal5 == ya) {
            nomor15 = 1
        } else {
            nomor15 = 0
        }

        if (soal6 == ya) {
            nomor16 = 0
        } else {
            nomor16 = 1
        }

        if (soal7 == ya) {
            nomor17 = 0
        } else {
            nomor17 = 1
        }

        if (soal18 == ya) {
            nomor18 = 0
        } else {
            nomor18 = 1
        }

        // ini perhitungan skor skala nya
        val skor: Int =
            nomor1 + nomor2 + nomor3 + nomor4 + nomor5 + nomor6 + nomor7 + nomor8 + nomor9 + nomor10 + nomor11 + nomor12 + nomor13 + nomor14 + nomor15 + nomor16 + nomor17 + nomor18
        skor2 = skor.toDouble()
        persen = (skor2 / 18) * 100
        tampilskor.setText("" + persen)

        // ini kategorisasi menggunakan metode statistik hipotetik

        if (persen < ringan) {
            tampilkategor.setText("RINGAN")
            solusi.setOnClickListener {
                val intent = Intent(context, Penanganan1::class.java)
                startActivity(intent)
                finish()
            }
        }

        if (persen >= ringan && persen < sedang) {

            tampilkategor.setText("SEDANG")

            solusi.setOnClickListener {
                val intent = Intent(context, Penanganan2::class.java)
                startActivity(intent)
                finish()
            }
        }

        if (persen >= sedang ) {
                tampilkategor.setText("BERATT")
            val context = this

            solusi.setOnClickListener {
                val intent = Intent(context, Penanganan3::class.java)
                startActivity(intent)
                finish()
            }
        }

    }

    fun postkerserver(usernamee:String,passwordd:String)
    {

        AndroidNetworking.post("http://192.168.43.68/psiko/ceklogin.php")
            .addBodyParameter("gmail", usernamee)
            .addBodyParameter("password", passwordd)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {

                    val jsonArray = response.getJSONArray("result")

                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        var iduser = jsonObject.optString("id_user")
                        idd.setText(iduser)

                    }

                }

                override fun onError(error: ANError) { // handle error
                }

            })

    }


}

