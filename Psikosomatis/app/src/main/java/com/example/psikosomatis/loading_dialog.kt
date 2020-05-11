package com.vokasi.abyan_mahasiswa

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import com.example.psikosomatis.R

class LoadingDialog internal constructor(private val activity: Activity) {
    internal lateinit var mydialog : Dialog

    fun StartLoadingDialog() {
        mydialog.dismiss()
    }

    fun dissmissDialog() {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        builder.setView(inflater.inflate(R.layout.activity_loading_dialog, null))
        builder.setCancelable(true)
        mydialog = builder.create()
        mydialog = builder.create()
        mydialog.show()
    }

}