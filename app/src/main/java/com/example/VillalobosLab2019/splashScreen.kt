package com.example.VillalobosLab2019

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager

class splashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)
        splash()
    }

    /*Funcion dedicada a iniciar la spashScreen*/
    private fun splash(){
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },4000)
    }
}
