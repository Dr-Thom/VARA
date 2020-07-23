package com.demoapp.vara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.timerTask

class HomeFMsg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_f_msg)

        val timer = Timer()
        timer.schedule(timerTask {
            nextScreen()  }, 30000)
    }

    private fun nextScreen(){
        startActivity(Intent(this, Home :: class.java))
    }

}