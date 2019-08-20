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
        setTextViewVariables()
        setTimer()
        setBtnTapMe()
        setBtnRestartGame()
    }

    /*
    * Funcion encargada de inicializar
    * variables de conteo*/
    private fun setTextViewVariables(){
        gameScore1.text = getString(R.string.score, score.toString())
        timeLeft1.text = getString(R.string.time_left, (startTime / countDownInterval).toString())
    }

    /*
    * Funcion encargada de
    * inicializar btn y
    * reiniciar el juego*/
    private fun setBtnRestartGame(){
        btnRestart.setOnClickListener{
            score = 0
            btnRestart.isVisible = false
            btnTapMe.isEnabled = true
            timer.cancel()
            setTextViewVariables()
        }
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
        btnTapMe.isEnabled = false
        btnRestart.isVisible = true
        Toast.makeText(this, getString(R.string.end_game, score.toString()), Toast.LENGTH_LONG).show()
    }

    /*
    * Funcion encargada de inicializar
    * bnt de Tap me e incrementar el
    * score con cada tap*/
    private fun setBtnTapMe(){
        btnTapMe.setOnClickListener {
            if(score == 0){
                timer.start()
                gameScore1.text = getString(R.string.score, (score++).toString())
            }
            gameScore1.text = getString(R.string.score, (score++).toString())
        }
    }
}
