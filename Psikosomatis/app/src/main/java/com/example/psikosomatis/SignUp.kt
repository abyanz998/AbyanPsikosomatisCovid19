package com.example.psikosomatis

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.TextView
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import com.androidnetworking.interfaces.JSONObjectRequestListener
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONArray

class SignUp : AppCompatActivity() {
    internal lateinit var mydialog : Dialog
    internal lateinit var txt : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btn_signup.setOnClickListener{

                var nama=editTextNama.text.toString()
                var gmail=editTextUsername.text.toString()
                var password= editTextPassword.text.toString()

                postkerserver(nama,gmail,password)


            mydialog = Dialog(this@SignUp)
            mydialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            mydialog.setContentView(R.layout.dialog1)
            mydialog.setTitle("Dialog box")

            txt = mydialog.findViewById(R.id.btn_ok) as TextView
            txt.isEnabled = true

            txt.setOnClickListener {
                startActivity(Intent(this, SignIn::class.java))
                finish()
                mydialog.cancel()                                                                       // ini untuk keluar dari dialog boxnya
            }
            mydialog.show()
            }
        }

    fun postkerserver(nama:String,gmail:String,password:String)
    {

        AndroidNetworking.post("https://psikosomatis.000webhostapp.com/register.php")
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



