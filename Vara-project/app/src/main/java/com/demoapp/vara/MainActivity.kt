package com.demoapp.vara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBtn = findViewById<View>(R.id.loginBtn) as Button
        val regTxt = findViewById<View>(R.id.regTxt) as TextView

        loginBtn.setOnClickListener(View.OnClickListener {
            view -> login()
        })

        regTxt.setOnClickListener(View.OnClickListener {
            View -> register()
        })

    }
    private fun login(){
        val emailTxt = findViewById<View>(R.id.emailTxt) as EditText
        val passwordTxt = findViewById<View>(R.id.passwordTxt) as EditText
        var email= emailTxt.text.toString()
        var password = passwordTxt.text.toString()

        if (!email.isEmpty() && !password.isEmpty()){
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, OnCompleteListener{
                task ->
                if (task.isSuccessful){
                    startActivity(Intent(this, Home :: class.java))
                    Toast.makeText(this, "Suceesfully logged in:)", Toast.LENGTH_LONG).show()
                } else{
                    Toast.makeText(this, "Error ;(", Toast.LENGTH_LONG).show()
                }
            })
        } else {
            Toast.makeText(this, "Please fill up the credentials :(", Toast.LENGTH_LONG).show()
        }
    }
    private fun register(){
        startActivity(Intent(this, Register :: class.java))
    }
}
