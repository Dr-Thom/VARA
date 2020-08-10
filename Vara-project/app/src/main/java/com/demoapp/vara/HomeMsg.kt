package com.demoapp.vara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.concurrent.timerTask

class HomeMsg : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_msg)

        val timer = Timer()
        timer.schedule(timerTask {
            nextScreen()  }, 15000)
    }

    private fun nextScreen(){
        startActivity(Intent(this, Home3 :: class.java))
    }

}