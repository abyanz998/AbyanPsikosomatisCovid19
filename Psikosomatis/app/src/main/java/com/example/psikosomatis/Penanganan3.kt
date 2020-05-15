package com.example.psikosomatis

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_penanganan2.*
import kotlinx.android.synthetic.main.activity_penanganan3.*
import org.json.JSONArray

class Penanganan3 : AppCompatActivity() {

    internal var number: String?=""
    internal var phone: Int = +119

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penanganan3)

        dial_btn2.setOnClickListener {
            //dialer intent
            val sharedPreferences = getSharedPreferences("TES", Context.MODE_PRIVATE)
            val  idtes4 = sharedPreferences.getString("IDTES","")
            val nama_psikolog = "KEMEN PPA"
            val alamat_psikolog = "JL Merdeka Barat No.15 DKI Jakarta"
            val nomor :String = phone.toString()

            AndroidNetworking.post("https://psikosomatis.000webhostapp.com/tenaga_medis.php")
                .addBodyParameter("id_hasil_tes", idtes4)
                .addBodyParameter("nama_psikolog", nama_psikolog)
                .addBodyParameter("alamat_psikolog", alamat_psikolog)
                .addBodyParameter("nomor_telepon", nomor)
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


            number = phone.toString().trim()
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+ Uri.encode(number)))
            startActivity(intent)
        }
    }
}
