package com.example.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.fragment.app.DialogFragment

class MyDialogFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val textView = TextView(activity)

            with(textView) {
                textView.text = "Важное сообщение! Пожалуйста, прочитайте его! Очень прошу!"
                textView.textSize = 18.0F
                textView.setTypeface(null, Typeface.BOLD)
                textView.gravity = Gravity.CENTER
            }

            val builder = AlertDialog.Builder(it)
            builder.setTitle("Важное сообщение!")
                .setCustomTitle(textView)
                .setMessage("Покормите кота!")
                .setIcon(R.drawable.hungrycat)
                .setPositiveButton("ОК, иду на кухню") {
                        dialog, id ->  dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}