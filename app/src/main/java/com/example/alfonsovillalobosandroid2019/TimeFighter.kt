package com.example.alfonsovillalobosandroid2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_time_fighter.*
import java.nio.file.attribute.AclFileAttributeView

class TimeFighter : AppCompatActivity() {
    /*
    * Esta es la parte donde se
    * inician las variables*/
    var score = 0
    var startTime:Long = 60000
    lateinit var timer : CountDownTimer

    /*
    * Funcion constructora*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_fighter)
        gameScore1.text = getString(R.string.score, score.toString())
        timeLeft1.text = getString(R.string.timeLeft, (startTime / 1000).toString())
        setTimer()
        btnTapMe.setOnClickListener {
            if(score == 0){
                timer.start()
            }
            incrementScore()
        }
    }

    /*
    * Funcion encargada de iniciar el
    * timer*/
    private fun setTimer(){
        timer = object: CountDownTimer(startTime, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                val timeLeftSeconds = millisUntilFinished / 1000
                timeLeft1.text = getString(R.string.timeLeft, timeLeftSeconds.toString())
            }

            override fun onFinish() {
                endGame()
            }
        }
    }

    /*
    * Accion al terminar el
    * juego*/
    private fun endGame(){
        Toast.makeText(this, getString(R.string.end_game, score.toString()), Toast.LENGTH_SHORT).show()
        btnTapMe.isEnabled = false
    }

    /*
    * Funcion encargada de incrementar el score*/
    private fun incrementScore(){
        gameScore1.text = getString(R.string.score, (score++).toString())
    }
}
