package com.example.VillalobosLab2019

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shake_gesture.*

class shakeGesture : AppCompatActivity() {
    private var mSensorManager: SensorManager? = null
    private var mSensorListener: ShakeEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shake_gesture)
        mSensorManager = this.getSystemService(Context.SENSOR_SERVICE) as SensorManager?
        mSensorListener = ShakeEventListener()

        this.mSensorListener!!.setOnShakeListener {
            switchImage()
        }
    }

    /*
    * Funcion encargada a
    * seleccionar una imagen */
    private fun switchImage(){
        when((1..3).shuffled().first()){
            1->setNewSelection(R.drawable.paper, R.string.text_paper)
            2->setNewSelection(R.drawable.rock, R.string.text_rock)
            3->setNewSelection(R.drawable.scissor, R.string.text_scissors)
        }
    }

    /*
    * Funcion dedicada a cambiar la foto
    * y el texto de la accion*/
    private fun setNewSelection(resource: Int, text: Int){
        imgRPS.setImageResource(resource)
        textSP.setText(text)
        
    }

    /*
    * Funcion encargada de sobre escribir
    * el resumen de la app */
    override fun onResume() {
        super.onResume()
        mSensorManager!!.registerListener(mSensorListener, mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_UI)
    }

    /*
    * Funcion encargada de sobre escribir
    * cuando la app esta en pausa*/
    override fun onPause() {
        mSensorManager!!.unregisterListener(mSensorListener)
        super.onPause()
    }
}
