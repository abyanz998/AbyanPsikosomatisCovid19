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
import org.json.JSONArray

class Penanganan2 : AppCompatActivity() {
    internal var number: String?=""
    internal var phone: Int = +119

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penanganan2)
        val saransedang = "SARAN PENGOBATAN MANDIRI"

        postpenanganan(saransedang)
        dial_btn.setOnClickListener {
            //dialer intent
            number = phone.toString().trim()

            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+ Uri.encode(number)))
            startActivity(intent)
        }
    }

    fun postpenanganan (saransedang:String)
    {
        val sharedPreferences = getSharedPreferences("TES", Context.MODE_PRIVATE)
        val  idtes3 = sharedPreferences.getString("IDTES","")

        AndroidNetworking.post("https://psikosomatis.000webhostapp.com/penanganan_sedang.php")
            .addBodyParameter("id_hasil_tes", idtes3)
            .addBodyParameter("saran_pengobatan", saransedang)
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
