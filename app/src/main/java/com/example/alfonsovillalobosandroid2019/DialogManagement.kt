package com.example.alfonsovillalobosandroid2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog_management.*
import kotlinx.android.synthetic.main.activity_dialog_management.view.*
import kotlinx.android.synthetic.main.dialog_image.view.*
import kotlinx.android.synthetic.main.dialog_image.view.btnAccept
import kotlinx.android.synthetic.main.logout_dialog.view.*

class DialogManagement : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_management)
        setClickShowImage()
        setClickLogout()
    }

    /*
    * Funcion dedicada a set lisener
    * on show image*/
    private fun setClickShowImage(){
        btnShowImage.setOnClickListener {
            val myImageView = layoutInflater.inflate(R.layout.dialog_image, null)
            val mBuilder = AlertDialog.Builder(this).setView(myImageView).setTitle("image view").show()
            setClickAccept(myImageView, mBuilder)
        }
    }

    /*
    * Funcion encargada de regresar
    * listener*/
    private  fun setClickAccept(myImageView: View, mBuilder: AlertDialog){
        myImageView.btnAccept.setOnClickListener {

        }
    }

    /*
    * Funcion dedicada a set lisener
    * on logout*/
    private fun setClickLogout(){
        btnLogout.setOnClickListener {
            val myLogoutView = layoutInflater.inflate(R.layout.logout_dialog, null)
            val mBuilder = AlertDialog.Builder(this).setView(myLogoutView).setTitle("image view").show()
            setClickLogout(myLogoutView, mBuilder)
        }
    }

    /*
    * Funcion encargada de darle funcion
    * a los botones de la vista*/
    private fun setClickLogout(myLogoutView: View, mBuilder: AlertDialog){
        myLogoutView.btnAccept.setOnClickListener {

        }
        myLogoutView.btnCancel.setOnClickListener {

        }
    }
}
