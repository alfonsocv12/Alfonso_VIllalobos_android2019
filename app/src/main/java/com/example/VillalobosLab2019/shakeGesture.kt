package com.example.VillalobosLab2019

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
            selectImage()
        }
    }

    /*
    * Funcion encargada a
    * seleccionar una imagen*/
    private fun selectImage(){
        when((1..3).shuffled().first()){
            1->imgRPS.setImageResource(R.drawable.paper)
            2->imgRPS.setImageResource(R.drawable.rock)
            3->imgRPS.setImageResource(R.drawable.scissor)
        }
    }

    override fun onResume() {
        super.onResume()
        mSensorManager!!.registerListener(mSensorListener, mSensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_UI)
    }

    override fun onPause() {
        mSensorManager!!.unregisterListener(mSensorListener)
        super.onPause()
    }
}
