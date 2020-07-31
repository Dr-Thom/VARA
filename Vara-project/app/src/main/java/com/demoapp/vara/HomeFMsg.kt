package com.demoapp.vara

import android.app.Application
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import io.grpc.InternalChannelz.id
import kotlinx.android.synthetic.main.activity_email_dialog.view.*
import java.util.*

class HomeFMsg : AppCompatActivity() {
    lateinit var db: DocumentReference
    private var id: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_f_msg)

//        val timer = Timer()
//        timer.schedule(timerTask {
//            nextScreen()  }, 45000)


        // val t=Timer()
        val dialog = AlertDialog.Builder(this);
        val dialogView = layoutInflater.inflate(R.layout.activity_email_dialog, null);
        dialog.setView(dialogView)
        dialog.setCancelable(false)
        val dialog2 = dialog.show()
        dialogView.submit_btn.setOnClickListener {
            val emails = findViewById<View>(R.id.Email_Txt) as EditText
            val email = emails.text.toString().trim()

            if (email.isNotEmpty()) {
                email2(email)
            }
        }
        finish()
        dialog2.dismiss()
    }


    //    private fun nextScreen(){
//        startActivity(Intent(this, Home :: class.java))
//    }
    private fun email2(email: String) {
        val note = UserData(email).toMap()
        val fireDB = FirebaseFirestore.getInstance()
        fireDB.collection("UserData")
            .add(note)
            .addOnSuccessListener {
                Log.e(TAG, "DocumentSnapshot written with ID: ")
            }
            .addOnFailureListener { e ->
                Log.e(TAG, "Error adding Note document", e)
            }
    }
}


//  private fun email() {
//      val emails= findViewById<View>(R.id.Email_Txt) as EditText
//      val email = emails.text.toString().trim()
//      if (email.isNotEmpty()) {
//          try {
//              db = FirebaseFirestore.getInstance().document("UserData")
//              val emailData = hashMapOf("email" to email)
//
//              db.collection("UserData").document("uid").set(emailData as Map<String, Any>)
//                  .addOnSuccessListener(OnSuccessListener<Void> {
//                      Toast.makeText(
//                          this,
//                          "Successfully uploaded to the database :)",
//                          Toast.LENGTH_LONG
//                      ).show()
//                  })
//                  .addOnFailureListener(OnFailureListener {
//                      Toast.makeText(this, "Error in submission :)", Toast.LENGTH_LONG).show()
//                  })
//          }catch (e:Exception) {
//              Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
//          }
//      }else {
//          Toast.makeText(this, "Please fill up the fields :(", Toast.LENGTH_LONG).show()
//      }
//
//  }
