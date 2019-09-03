package com.example.VillalobosLab2019

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    /*
    * Funcion costructora*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setClickBtnHelloWorld()
        setClickBtnTimeFighter()
        setClickBtnTempConverter()
        setClickBtnDialog()
        setClickBtnDialogManagement()
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
    * Funcion encargada de mandar al
    * Dialog*/
    private fun setClickBtnDialog(){
        btnActivityDialog.setOnClickListener {
            startActivity(Intent(this, Dialog::class.java))
        }
    }

    /*
    * Funcion encargada de regresar a
    * dialog management*/
    private fun setClickBtnDialogManagement(){
        btnDialogManagement.setOnClickListener {
            startActivity(Intent(this,DialogManagement::class.java))
        }
    }
}
