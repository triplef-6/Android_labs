package com.example.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialogFragment3: DialogFragment() {

    private val catNames = arrayOf("Васька", "Рыжик", "Мурзик")

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Выберите любимое имя кота")
                .setSingleChoiceItems(catNames, -1
                ) { dialog, item ->
                    Toast.makeText(activity, "Любимое имя кота:  ${catNames[item]}",
                        Toast.LENGTH_SHORT).show()
                }
                .setPositiveButton("OK"
                ) { dialog, id ->
                    // User clicked OK, so save the selectedItems results somewhere
                    // or return them to the component that opened the dialog
                }
                .setNegativeButton("Отмена") {
                        dialog, id ->
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}