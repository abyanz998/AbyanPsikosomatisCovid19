package com.example.psikosomatis

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.vokasi.abyan_mahasiswa.LoadingDialog
import kotlinx.android.synthetic.main.activity_pertanyaan6.*
import org.json.JSONArray
import org.json.JSONObject

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

        AndroidNetworking.post("http://192.168.43.68/psiko/ceklogin.php")
            .addBodyParameter("gmail", username)
            .addBodyParameter("password", password)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {
                override fun onResponse(response: JSONObject) {

                    val jsonArray = response.getJSONArray("result")

                    for (i in 0 until jsonArray.length()) {
                        val jsonObject = jsonArray.getJSONObject(i)
                        val id = jsonObject.optString("id").toString()  // ini optString gapapa kalau langsung di setText masihh bisa pake nama1
                        val id_user = id.toString()
                    }

                }

                override fun onError(error: ANError) { // handle error
                }

            })
        radioGroup16 = findViewById(R.id.rg_soal16)
        radioGroup17 = findViewById(R.id.rg_soal17)
        radioGroup18 = findViewById(R.id.rg_soal18)

        val loadingDialog = LoadingDialog(this@Pertanyaan6)                                    // progress bar mengambil class konstruktor dari loading_dialog.kt

        btn_next.setOnClickListener(View.OnClickListener {

            loadingDialog.dissmissDialog()                                                          // progresss bar
            val handler = Handler()
            handler.postDelayed({ loadingDialog.StartLoadingDialog()
                val jawaban1 = soal1
                val jawaban2 = soal2
                val jawaban3 = soal3
                val jawaban4 = soal4
                val jawaban5 = soal5
                val jawaban6 = soal6
                val jawaban7 = soal7
                val jawaban8 = soal8
                val jawaban9 = soal9
                val jawaban10 = soal10
                val jawaban11 = soal11
                val jawaban12 = soal12
                val jawaban13 = soal13
                val jawaban14 = soal14
                val jawaban15 = soal15

                val rgsoal16 = radioGroup16.checkedRadioButtonId
                val rg_soal6 = findViewById<RadioButton>(rgsoal16)
                val jawaban16 = rg_soal6.text.toString()

                val rgsoal17 = radioGroup17.checkedRadioButtonId
                val rg_soal17 = findViewById<RadioButton>(rgsoal17)
                val jawaban17 = rg_soal17.text.toString()

                val rgsoal18 = radioGroup18.checkedRadioButtonId
                val rg_soal18 = findViewById<RadioButton>(rgsoal18)
                val jawaban18 = rg_soal18.text.toString()


                postjawaban(jawaban1,jawaban2,jawaban3,jawaban4,jawaban5,jawaban6,jawaban7,jawaban8,jawaban9,jawaban10,jawaban11,jawaban12,jawaban13,jawaban14,jawaban15,jawaban16,jawaban17,jawaban18)


                val intent = Intent(this, hasil::class.java)
                intent.putExtra("soal1", jawaban1)
                intent.putExtra("soal2", jawaban2)
                intent.putExtra("soal3", jawaban3)
                intent.putExtra("soal4", jawaban4)
                intent.putExtra("soal5", jawaban5)
                intent.putExtra("soal6", jawaban6)
                intent.putExtra("soal7", jawaban7)
                intent.putExtra("soal8", jawaban8)
                intent.putExtra("soal9", jawaban9)
                intent.putExtra("soal10", jawaban10)
                intent.putExtra("soal11", jawaban11)
                intent.putExtra("soal12", jawaban12)
                intent.putExtra("soal13", jawaban13)
                intent.putExtra("soal14", jawaban14)
                intent.putExtra("soal15", jawaban15)
                intent.putExtra("soal16", jawaban16)
                intent.putExtra("soal17", jawaban17)
                intent.putExtra("soal18", jawaban18)
                intent.putExtra("username", username)
                intent.putExtra("password", password)
                startActivity(intent)
                finish()

            }, 6000)


        })

    }


    fun postjawaban (jawaban1:String,jawaban2:String,jawaban3:String,jawaban4:String,jawaban5:String,jawaban6:String,jawaban7:String,jawaban8:String,jawaban9:String,jawaban10:String,jawaban11:String,jawaban12:String,jawaban13:String,jawaban14:String,jawaban15:String,jawaban16:String,jawaban17:String,jawaban18:String)
    {
        AndroidNetworking.post("http://192.168.43.68/psiko/tes.php")
            .addBodyParameter("id_user", "9")
            .addBodyParameter("pertanyaan_1", jawaban1)
            .addBodyParameter("pertanyaan_2", jawaban2)
            .addBodyParameter("pertanyaan_3", jawaban3)
            .addBodyParameter("pertanyaan_4", jawaban4)
            .addBodyParameter("pertanyaan_5", jawaban5)
            .addBodyParameter("pertanyaan_6", jawaban6)
            .addBodyParameter("pertanyaan_7", jawaban7)
            .addBodyParameter("pertanyaan_8", jawaban8)
            .addBodyParameter("pertanyaan_9", jawaban9)
            .addBodyParameter("pertanyaan_10", jawaban10)
            .addBodyParameter("pertanyaan_11", jawaban11)
            .addBodyParameter("pertanyaan_12", jawaban12)
            .addBodyParameter("pertanyaan_13", jawaban13)
            .addBodyParameter("pertanyaan_14", jawaban14)
            .addBodyParameter("pertanyaan_15", jawaban15)
            .addBodyParameter("pertanyaan_16", jawaban16)
            .addBodyParameter("pertanyaan_17", jawaban17)
            .addBodyParameter("pertanyaan_18", jawaban18)

            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray?) {
                    Log.i("Pesan", "MANTAP")
                }

                override fun onError(anError: ANError?) {
                    Log.i("Pesan", "BOCOR")
                }
            })
    }


}


