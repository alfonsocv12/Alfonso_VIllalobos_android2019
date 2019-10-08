package com.example.VillalobosLab2019

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shared_preferences.*
import kotlinx.android.synthetic.main.login_dialog.*

class sharedPreferences : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        val sharedPreference:SharedPreferences? = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var editor:SharedPreferences.Editor? = sharedPreference.edit()
        var name:String? = sharedPreference.getString("name", "")

        this.txtSHName.setText(name)

        btnSHCancel.setOnClickListener {
            editor.remove("name")
            editor.apply()
        }

        btnSHSave.setOnClickListener {
            editor.putString("name",txtName.text.toString())
            editor.apply()
        }
    }
}
