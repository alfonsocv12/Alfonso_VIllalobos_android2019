package com.example.alfonsovillalobosandroid2019

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.login_dialog.view.*

class Dialog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        showDialog()
    }

    /*
    * Funcion encargada de dar
    * funcion al boton de mostrar dialogo*/
    private fun showDialog(){
        btnShowDialog.setOnClickListener {
            val myDialogView = layoutInflater.inflate(R.layout.login_dialog, null)
            val mBuilder = AlertDialog.Builder(this).setView(myDialogView).setTitle("login form").show()
            setLogin(myDialogView, mBuilder)
        }
    }

    /*
    * Funcion encargada de darle accion
    * al boton del loggin*/
    private fun setLogin(myDialogView: View, mBuilder: AlertDialog){
        myDialogView.btnLogin.setOnClickListener {
            val name = myDialogView.txtName.text.toString()
            val email = myDialogView.txtEmail.text.toString()
            val password = myDialogView.txtPassword.text.toString()
            txtLogin.setText(" Nombre: ${name} \n Email: ${email} \n Password: ${password}")
            mBuilder.dismiss()
        }
    }
}
