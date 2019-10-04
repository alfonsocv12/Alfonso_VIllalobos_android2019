package com.example.VillalobosLab2019

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Switch
import android.widget.Toast
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
            switch((1..3).shuffled().first()){
                case 1:
                    imgRPS.setImageResource(R.drawable.paper);
                    break;
                default:
                    imgRPS.setImageResource(R.drawable.images);
                    break;
            }
            imgRPS.setImageResource(R.drawable.paper)
            imgRPS.setImageResource(R.drawable.rock)
            imgRPS.setImageResource(R.drawable.scissor)
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
