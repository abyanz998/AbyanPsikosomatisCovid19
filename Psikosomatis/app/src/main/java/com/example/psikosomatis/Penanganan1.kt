package com.example.psikosomatis

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import org.json.JSONArray

class Penanganan1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_penanganan1)
        val saran = "SARAN PENCEGAHAN"
        postpenanganan(saran)
    }

    fun postpenanganan (saran:String)
    {
        val sharedPreferences = getSharedPreferences("TES", Context.MODE_PRIVATE)
        val  idtes2 = sharedPreferences.getString("IDTES","")

        AndroidNetworking.post("http://192.168.43.68/psiko/penanganan_ringan.php")
            .addBodyParameter("id_hasil_tes", idtes2)
            .addBodyParameter("saran_pencegahan", saran)
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
