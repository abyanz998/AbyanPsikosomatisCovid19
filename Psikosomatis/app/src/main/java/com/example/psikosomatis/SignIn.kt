package com.example.psikosomatis

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_information1.*
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject

class SignIn : AppCompatActivity() {
    internal lateinit var mydialog : Dialog
    internal lateinit var txt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)       // ini tuh buat nyimpen data secara local jadi buat data cache user berupa json key-value String sama context
        val stat=sharedPreferences.getString("STATUS","")                             // ini nilai status cuy

        if (stat=="1"){
            startActivity(Intent(this@SignIn,Menu::class.java))
            finish()
        }

        else {

            btn_login.setOnClickListener{

                if (validate()){

                    var username= TextUsername.text.toString()
                    var password= TextPassword.text.toString()
                    postkerserver(username,password)
                } else{

                    Toast.makeText(applicationContext, "Masukkan Username dan Password anda", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun validate() : Boolean{
        if (TextUsername.text.toString().isEmpty()){
            TextUsername.error = "Masukkan Username anda"
            return false
        }else if (TextPassword.text.toString().isEmpty()){
            TextPassword.error = "Masukkan Password anda "
            return false
        }
        return true
    }

    fun postkerserver(username:String,password:String)
    {
        AndroidNetworking.post("https://psikosomatis.000webhostapp.com/ceklogin.php")
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

                        Log.e("_kotlinnama", jsonObject.optString("nama"))

                        if (statuslogin=="1"){
                            val sharedPreferences= getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
                            val editor           = sharedPreferences.edit()                         // editor itu berfungsi buat edit variabel sharedPreferences

                            editor.putString("STATUS",statuslogin)                                  // nentuin value nya diedit dengan nilai variabel
                            editor.putString("NAMA",jsonObject.optString("nama").toString())
                            editor.putString("ID",jsonObject.optString("id_user").toString())
                            editor.apply()                                                          // nyimpen valuenya

                            mydialog = Dialog(this@SignIn)
                            mydialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
                            mydialog.setContentView(R.layout.dialog_login)
                            mydialog.setTitle("Dialog box")

                            txt = mydialog.findViewById(R.id.btn_ok) as TextView
                            txt.isEnabled = true

                            txt.setOnClickListener {

                                val usernamee = username                                            // ini untuk variabel username
                                val passwordd = password                                            // ini untuk variabel password
                                val intent = Intent(this@SignIn, Menu::class.java)
                                intent.putExtra("username", usernamee)
                                intent.putExtra("password", passwordd)
                                startActivity(intent)
                                finish()
                                mydialog.cancel()                                                   // ini untuk keluar dari dialog boxnya
                            }
                            mydialog.show()
                        }

                    }

                }

                override fun onError(error: ANError) { // handle error
                }

            })

    }

}
