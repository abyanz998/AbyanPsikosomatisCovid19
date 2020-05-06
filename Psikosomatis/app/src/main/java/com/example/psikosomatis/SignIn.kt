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
import kotlinx.android.synthetic.main.activity_information1.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject

class SignIn : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE) // ini tuh buat nyimpen data secara local jadi buat data cache user berupa json key-value String sama context
        val stat=sharedPreferences.getString("STATUS","")  // ini buat ngambil data nya cuy

        if (stat=="1"){

            startActivity(Intent(this@SignIn,Menu::class.java))
            finish()

        }

        else {

            btn_login.setOnClickListener{
                // jadi kan dia kalau diklik tombol start/login dia ngirim data ini ke postkerserver
                // postkeserver disana nampilin datanya lho pakai select*from soalnya

                var username= TextUsername.text.toString()
                var password= TextPassword.text.toString()

                postkerserver(username,password)

            }
        }
    }

    fun postkerserver(username:String,password:String)
    {

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
                        Log.e("_kotlinTitle", jsonObject.optString("status"))
                        var statuslogin= jsonObject.optString("status")
//                        txttes.setText(statuslogin)

                        // aku pengen coba set text ke sini ajaa bisa ngga jadi mmuncul angka 1 sama id_usernya buat ngetes doang gitu
                        // kalau nampilin pake yang jamsholat aja dan ga mesti pake adapter deh!
                        // ternyata di jamsholat itu bisa langsung set text ajaa dengan syarat di php nya pake yang jamsholat itu terus tinggal di set text kaya di appnya jamsholat
                        var nama1 = jsonObject.optString("nama").toString()
                        val namaa = txtnama.setText((nama1))
//                        var namaaa = txtnama.text.toString()


                        if (statuslogin=="1"){

                            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
                            val editor=sharedPreferences.edit()
                            val usernamee = username
                            val passwordd = password

                            editor.putString("STATUS",statuslogin)  // nentuin value nya apaa gitu
                            editor.putString("NAMA", nama1)
                            editor.apply()                          // nyimpen valuenya


                            val intent = Intent(this@SignIn,Menu::class.java)
                            intent.putExtra("nama", nama1)
                            intent.putExtra("username", usernamee)
                            intent.putExtra("password", passwordd)
                            startActivity(intent)
                            finish()
                        }
                    }



                }

                override fun onError(error: ANError) { // handle error
                }

            })

    }

}
