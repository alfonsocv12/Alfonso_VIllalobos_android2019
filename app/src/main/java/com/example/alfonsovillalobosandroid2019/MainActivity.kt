package com.example.alfonsovillalobosandroid2019

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.children
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /*
    * Funcion costructora*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSameBtnSise()
        setClickBtnHelloWorld()
        setClickBtnTimeFighter()
        setClickBtnTempConverter()
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

    /*
    * Funcion encargada de inicializar
    * el button de centigrados a fahrenheit*/
    private  fun setClickBtnTempConverter(){
        btnTempConverter.setOnClickListener{
            startActivity(Intent(this,TempConverter::class.java))
        }
    }

    /*
    * Funcion encargada de acomodar
    * los tamaños de los botones*/
    private fun setSameBtnSise(){
        val maxWith = getMaxWidth()
    }

    /*
    * Funcion encargada de obtener
    * el tamaño maximo de los botones*/
    private fun getMaxWidth(){
        Log.d("ctrol51", layoutMain.getViewById())
    }
}
