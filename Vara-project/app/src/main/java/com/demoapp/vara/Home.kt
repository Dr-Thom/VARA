package com.demoapp.vara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*
import kotlin.concurrent.timerTask

class Home : AppCompatActivity() {
    private lateinit var mDatabase : DatabaseReference
    private var mAuth = FirebaseAuth.getInstance()
    var user = FirebaseAuth.getInstance().currentUser


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val timer = Timer()
        timer.schedule(timerTask {
            nextScreen()  }, 30000)

        val nameTxt = findViewById<View>(R.id.dispTxt) as TextView

        var uid = user!!.uid

        mDatabase = FirebaseDatabase.getInstance().getReference("Names")

        mDatabase.child(uid).child("Name").addValueEventListener( object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {
               //TODO("not implemented")
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                nameTxt.text =  "Welcome " + snapshot.value.toString()
            }
        })

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == R.id.signOut) {
            mAuth.signOut()
            Toast.makeText(this, "Signed Out :(", Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun nextScreen(){
        startActivity(Intent(this, HomeMsg :: class.java))
    }

}
