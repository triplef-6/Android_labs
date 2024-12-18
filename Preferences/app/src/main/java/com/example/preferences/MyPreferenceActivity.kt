package com.example.preferences

//import android.R
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceActivity


class MyPreferenceActivity: PreferenceActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        addPreferencesFromResource(R.xml.settings)
        fragmentManager.beginTransaction()
            .replace(android.R.id.content, MyPrefsFragment())
            .commit()
    }

    override fun onHeaderClick(header: Header?, position: Int) {
        val intent = Intent(this@MyPreferenceActivity, HeaderPrefsActivity::class.java)
        startActivity(intent)
    }
}