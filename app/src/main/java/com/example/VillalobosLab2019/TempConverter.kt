package com.example.VillalobosLab2019

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_temp_converter.*

class TempConverter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_temp_converter)
        setClickbtnConvert()
    }

    /*
    * Funcion encargada de inicializar el
    * boton de conversion*/
    private fun setClickbtnConvert(){
        btnConvert.setOnClickListener {
            convert()
        }
    }

    /*
    * Funcion encargada de convertir centigrados a
    * farenheit*/
    private fun convert(){
        val gradesDouble = ((editTextTemp.text.toString().toDouble() - 32.0) * (5.0 / 9.0))
        returnGradesCelcius(gradesDouble)
        changeColor(gradesDouble)
    }

    /*
    * Return convert of grades*/
    private fun returnGradesCelcius(grades: Double){
        Toast.makeText(this, grades.toString(), Toast.LENGTH_LONG).show()
    }

    /*
    * Funcion encargada de cambiar
    * el color de atras*/
    private fun changeColor(grades: Double){
        when (grades){
            in 0.0..10.0 -> layoutTempConverter.setBackgroundColor(Color.rgb(12,12,12))
            in 10.0..30.0 -> layoutTempConverter.setBackgroundColor(Color.rgb(14,20,5))
        }
    }
}
