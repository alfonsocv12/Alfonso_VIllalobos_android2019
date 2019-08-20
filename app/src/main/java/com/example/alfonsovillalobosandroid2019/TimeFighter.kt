package com.example.alfonsovillalobosandroid2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_time_fighter.*
import java.nio.file.attribute.AclFileAttributeView

class TimeFighter : AppCompatActivity() {
    /*
    * Esta es la parte donde se
    * inician las variables*/
    var score = 0
    var startTime:Long = 20000
    var countDownInterval:Long = 1000
    lateinit var timer : CountDownTimer

    /*
    * Funcion constructora*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_fighter)
        gameScore1.text = getString(R.string.score, score.toString())
        timeLeft1.text = getString(R.string.time_left, (startTime / countDownInterval).toString())
        setTimer()
        btnTapMe.setOnClickListener {
            if(score == 0){
                timer.start()
            }
            incrementScore()
        }

        btnRestart.setOnClickListener {
            restartGame()
        }
    }

    /*
    * Funcion encargada
    * de reiniciar el juego*/
    private fun restartGame(){
        score = 0
        btnRestart.isVisible = false
        btnTapMe.isEnabled = true
        timer.cancel()
        gameScore1.text = getString(R.string.score, score.toString())
        timeLeft1.text = getString(R.string.time_left, (startTime / countDownInterval).toString())
    }

    /*
    * Funcion encargada de iniciar el
    * timer*/
    private fun setTimer(){
        timer = object: CountDownTimer(startTime, countDownInterval) {
            override fun onTick(millisUntilFinished: Long) {
                timeLeft1.text = getString(R.string.time_left, (millisUntilFinished / countDownInterval).toString())
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
        btnRestart.isVisible = true
    }

    /*
    * Funcion encargada de incrementar el score*/
    private fun incrementScore(){
        gameScore1.text = getString(R.string.score, (score++).toString())
    }
}
