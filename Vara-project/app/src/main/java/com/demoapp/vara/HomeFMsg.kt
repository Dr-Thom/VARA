package com.demoapp.vara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_dialog_email.view.*
import java.util.*
import kotlin.concurrent.timerTask

class HomeFMsg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_f_msg)

        val timer = Timer()
        timer.schedule(timerTask {
            nextScreen()  }, 30000)


        val dialog = AlertDialog.Builder(this);
        val dialogView = layoutInflater.inflate(R.layout.activity_dialog_email, null);
        dialog.setView(dialogView)
        dialog.setCancelable(false)
        val dialog2 = dialog.show()
        dialogView.submit_btn_yes.setOnClickListener {
            dialog2.dismiss()
            Toast.makeText(this, "Thank you for sharing", Toast.LENGTH_LONG).show()
        }
        dialogView.submit_btn_no.setOnClickListener {
            dialog2.dismiss()
            Toast.makeText(this, "Thank you may be next time", Toast.LENGTH_LONG).show()
        }
    }

    private fun nextScreen(){
        startActivity(Intent(this, Home :: class.java))
    }

}