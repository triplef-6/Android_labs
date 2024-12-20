package com.example.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialogFragment2: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Выбор есть всегда")
                .setMessage("Выбери пищу")
                .setIcon(R.drawable.hungrycat)
                .setCancelable(true)
                .setPositiveButton("Вкусная пища") { _, _ ->
                    Toast.makeText(
                        activity,
                        "Вы сделали правильный выбор",
                        Toast.LENGTH_LONG
                    ).show()
                }
                .setNegativeButton(
                    "Здоровая пища"
                ) { _, _ ->
                    Toast.makeText(
                        activity, "Возможно вы правы",
                        Toast.LENGTH_LONG
                    ).show()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}

