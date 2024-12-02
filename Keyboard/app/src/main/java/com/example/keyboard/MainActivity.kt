package com.example.keyboard

//import android.R
//import android.R
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(), TextView.OnEditorActionListener {
    var back_pressed: Long = 0
    var editSearch: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        editSearch = findViewById<View>(R.id.editSearch) as EditText
        editSearch!!.setOnEditorActionListener(this)
        val editGo = findViewById<View>(R.id.editGo) as EditText
        editGo.setOnEditorActionListener(this)
//        val ipt = EditText(this)
//        ipt.inputType = InputType.TYPE_CLASS_PHONE
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Подтверждение")
            setMessage("Вы уверены, что хотите выйти из программы?")

            setPositiveButton("Да") { _, _ ->
                super.onBackPressed()
            }

            setNegativeButton("Нет"){_, _ ->
                // if user press no, then return the activity
                Toast.makeText(this@MainActivity, "Thank you",
                    Toast.LENGTH_LONG).show()
            }
            setCancelable(true)
        }.create().show()
    }


//    override fun onBackPressed() {
//        if (back_pressed + 2000 > System.currentTimeMillis()) super.onBackPressed()
//        else Toast.makeText(
//            baseContext, "Press once again to exit!",
//            Toast.LENGTH_SHORT
//        ).show()
//        back_pressed = System.currentTimeMillis()
//    }

    override fun onUserLeaveHint() {
        val toast = Toast.makeText(applicationContext, "Нажата кнопка HOME", Toast.LENGTH_SHORT)
        toast.show()
        super.onUserLeaveHint()
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_MENU -> {
                Toast.makeText(this, "Нажата кнопка Меню", Toast.LENGTH_SHORT)
                    .show()
                return true
            }

            KeyEvent.KEYCODE_SEARCH -> {
                Toast.makeText(this, "Нажата кнопка Поиск", Toast.LENGTH_SHORT)
                    .show()
                return true
            }

            KeyEvent.KEYCODE_BACK -> {
                onBackPressed()
                return true
            }

            KeyEvent.KEYCODE_VOLUME_UP -> {
                event.startTracking()
                return true
            }

            KeyEvent.KEYCODE_VOLUME_DOWN -> {
                Toast.makeText(this, "Нажата кнопка громкости", Toast.LENGTH_SHORT)
                    .show()
                return false
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
            // обрабатываем нажатие кнопки поиска
            if (editSearch!!.text.toString() != "cat") {
                Toast.makeText(this, "Не буду ничего искать!", Toast.LENGTH_LONG).show()
            }
            return true
        }
        if (actionId == EditorInfo.IME_ACTION_GO) {
            // обрабатываем нажатие кнопки GO
            return true
        }
        return false
    }
}