package com.example.psikosomatis

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONArray

class SignUp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val context = this

        btn_signup.setOnClickListener{

                var nama=editTextNama.text.toString()
                var gmail=editTextUsername.text.toString()
                var password=editTextPassword.text.toString()


                postkerserver(nama,gmail,password)
                startActivity(Intent(this, SignIn::class.java))
            }
        }

    fun postkerserver(nama:String,gmail:String,password:String)
    {

        AndroidNetworking.post("http://192.168.43.68/psiko/register.php")
            .addBodyParameter("nama", nama)
            .addBodyParameter("gmail", gmail)
            .addBodyParameter("password", password)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {


                }

                override fun onError(error: ANError) { // handle error
                }

            })

    }
    }



