package com.example.menu

//import android.R
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.menu.ui.theme.MenuTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button);
        val textView: TextView = findViewById(R.id.textView);

        button.setOnClickListener(viewClickListener);
        textView.setOnClickListener(viewClickListener);

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val textView: TextView = findViewById(R.id.textView)
        when (item.itemId) {
            R.id.action_cat1 -> {
                textView.text = "Вы выбрали кота!"
                return true
            }

            R.id.action_cat2 -> {
                textView.text = "Вы выбрали кошку!"
                return true
            }

            R.id.action_cat3 -> {
                textView.text = "Вы выбрали котёнка!"
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


    var viewClickListener = View.OnClickListener { v -> showPopupMenu(v) }

    private fun showPopupMenu(v: View) {
        val popupMenu: PopupMenu = PopupMenu(this,  v)
        popupMenu.inflate(R.menu.popupmenu)

        popupMenu
            .setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu1 -> {
                        Toast.makeText(
                            getApplicationContext(),
                            "Вы выбрали PopupMenu 1",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }

                    R.id.menu2 -> {
                        Toast.makeText(
                            getApplicationContext(),
                            "Вы выбрали PopupMenu 2",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }

                    R.id.menu3 -> {
                        Toast.makeText(
                            getApplicationContext(),
                            "Вы выбрали PopupMenu 3",
                            Toast.LENGTH_SHORT
                        ).show()
                        true
                    }

                    else -> false
                }
            }

//        popupMenu.setOnDismissListener {
//            Toast.makeText(
//                getApplicationContext(), "onDismiss",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
        popupMenu.show()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MenuTheme {
        Greeting("Android")
    }
}