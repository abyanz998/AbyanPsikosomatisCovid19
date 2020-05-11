package com.example.psikosomatis

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.Window
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {

    private var backPressedTime: Long = 0                                                              // ini cumma buat nyimpen lama waktu
    internal lateinit var backToast: Toast
    internal lateinit var mydialog : Dialog
    internal lateinit var txt : TextView
    internal lateinit var txt2 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        var intent = intent
        val username = intent.getStringExtra("username")
        val password = intent.getStringExtra("password")

        val sharedPreferences = getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
        sharedPreferences.apply {
            val namaa = getString("NAMA", "")
            tampilnama.setText(namaa)                                                               // ini untuk menampilkan session setelah login
        }

        // ini fungsi untuk keluar/ LOGOUT
        btn_logout.setOnClickListener{
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()
            val context = this
            editor.putString("STATUS","0")
            editor.apply()

            startActivity(Intent(context, Welcome::class.java))
            finish()
        }

        btn_psiko.setOnClickListener {
            val context = this
            startActivity(Intent(context, Psiko::class.java))
        }

        btn_tes.setOnClickListener {
            ShowDialog(username, password)
        }

    }

    override fun onBackPressed() {                                                                  // ini emang fungsi bawaan dengan isi super.onBackPressed() untuk keluar dari aplikasi
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel()
            val sharedPreferences=getSharedPreferences("CEKLOGIN", Context.MODE_PRIVATE)
            val editor=sharedPreferences.edit()
            editor.putString("STATUS","0")
            editor.apply()
            super.onBackPressed()                                                                   // ini BAWAAN kalau kita tekan back dengan kondisi 1 maka akan langsung keluar

        } else {
            backToast = Toast.makeText(baseContext, "Tekan lagi untuk keluar dari aplikasi", Toast.LENGTH_LONG)
            backToast.setGravity(Gravity.TOP,0,140)
            backToast.show()
        }
        backPressedTime = System.currentTimeMillis()
    }

    fun ShowDialog(username:String, password:String){
        mydialog = Dialog(this)
        mydialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        mydialog.setContentView(R.layout.activity_dialog_tes)
        mydialog.setTitle("Dialog box")

        txt2 = mydialog.findViewById(R.id.batal) as TextView
        txt2.isEnabled = true
        txt2.setOnClickListener {
          mydialog.cancel()
        }

        txt = mydialog.findViewById(R.id.lanjut) as TextView
        txt.isEnabled = true

        txt.setOnClickListener {

            val context = this
            val usernamee = username                                                                // ini untuk variabel username
            val passwordd = password                                                                // ini untuk variabel password
            val intent = Intent(context, Pertanyaan1::class.java)
            intent.putExtra("username", usernamee)
            intent.putExtra("password", passwordd)
            startActivity(intent)
            mydialog.cancel()                                                                       // ini untuk keluar dari dialog boxnya
        }
        mydialog.show()                                                                             // ini untuk menampilkan dialogboxnya
    }

}
