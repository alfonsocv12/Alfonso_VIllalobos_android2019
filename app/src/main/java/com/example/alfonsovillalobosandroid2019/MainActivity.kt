package com.example.alfonsovillalobosandroid2019

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /*
    * Funcion costructora*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setClickBtnHelloWorld()
        setClickBtnTimeFighter()
    }

    /*
    * Funcion encargada de inicializar
    * el button de hello world*/
    private fun setClickBtnHelloWorld(){
        btnHelloWorld.setOnClickListener {
            startActivity(Intent(this, HelloWorld::class.java))
        }
    }

    /*
    * Funcion encargada de inicializar
    * el button de setTimeFIghter*/
    private fun setClickBtnTimeFighter(){
        btnTimeFighter.setOnClickListener {
            startActivity(Intent(this, TimeFighter::class.java))
        }
    }
}
