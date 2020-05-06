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
        val soal16 = intent.getStringExtra("soal16")
        val soal17 = intent.getStringExtra("soal17")
        val soal18 = intent.getStringExtra("soal18")
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

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


        var usernamee=  username
        var passwordd= password

        postkerserver(usernamee,passwordd)
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

                        var nama1 = jsonObject.optString("id_user")
                        val namaa = namauser.setText((nama1))
//
                    }



                }

                override fun onError(error: ANError) { // handle error
                }

            })

    }

}
