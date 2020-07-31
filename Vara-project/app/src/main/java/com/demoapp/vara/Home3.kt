package com.demoapp.vara

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import java.util.*
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit
import kotlin.concurrent.timerTask

class Home3 : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);

<<<<<<< HEAD
        prepareAd();
//        MobileAds.initialize(this) {}
//        mInterstitialAd = InterstitialAd(this);
//        mInterstitialAd.adUnitId= getString(R.string.int_add_id)
//        mInterstitialAd.loadAd(AdRequest.Builder().build());
        mInterstitialAd.show();
        val timer = Timer()
        timer.schedule(timerTask {
            nextScreen()  }, 30000)
//
=======

        MobileAds.initialize(this,getString(R.string.ad_app_id))
        mInterstitialAd = InterstitialAd(this);
        mInterstitialAd.adUnitId= getString(R.string.int_add_id)
        mInterstitialAd.loadAd(AdRequest.Builder().build());

        mInterstitialAd.adListener =object:AdListener() {
            override fun onAdLoaded() {
                    mInterstitialAd.show()
                    super.onAdLoaded()
            }
        }

        val timer = Timer()
        timer.schedule(timerTask {
            nextScreen()  }, 35000)
//        prepareAd();


>>>>>>> develop
//        val scheduler = Executors.newSingleThreadScheduledExecutor()
//        scheduler.scheduleAtFixedRate({
//          // Log.i("hello", "world")
//            runOnUiThread {
//                if (mInterstitialAd.isLoaded) {
//                    mInterstitialAd.show()
//                } else {
//                    Log.d("TAG", " Interstitial not loaded")
//                }
//                prepareAd()
//            }
//        }, 5, 20, TimeUnit.SECONDS)
<<<<<<< HEAD
    }


     private fun prepareAd() {
         mInterstitialAd = InterstitialAd(this);
        mInterstitialAd.adUnitId= getString(R.string.int_add_id)
       mInterstitialAd.loadAd(AdRequest.Builder().build());
     }
=======
  }



//    private fun prepareAd() {
//        mInterstitialAd = InterstitialAd(this);
//        mInterstitialAd.adUnitId= getString(R.string.int_add_id)
//        mInterstitialAd.loadAd(AdRequest.Builder().build());
//    }
>>>>>>> develop

    private fun nextScreen(){
        startActivity(Intent(this, HomeFMsg :: class.java))
    }

}