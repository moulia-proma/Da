package com.liilab.android_basics.presentation.screen.AlertDialog

import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageButton

import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.liilab.android_basics.R


class Dialogs(val context: Context) {
    private lateinit var btnCustomAlertCancel: ImageButton
    fun DefaultAlert() {

        MaterialAlertDialogBuilder(context)
            .setTitle("This is a default Alert")
            .setMessage("Press yes or no")
            .setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }


            })
            .setNegativeButton("No", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }


            })
            .show()
    }

    fun CustomAlert() {
        val layoutInflater = LayoutInflater.from(context)
        val customAlertview = layoutInflater.inflate(R.layout.custom_alert, null)
        btnCustomAlertCancel = customAlertview.findViewById(R.id.cancel_alert)

        val customAlert = MaterialAlertDialogBuilder(context)
            .setView(customAlertview)
            .create()

        customAlert.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customAlert.show()
        btnCustomAlertCancel.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                customAlert.dismiss()
            }

        }
        )
    }
}

