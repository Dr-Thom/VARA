package com.demoapp.vara

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds

class Home3 : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home3)

        MobileAds.initialize(this,getString(R.string.admob_app_id))

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = getString(R.string.interstrial_add_id)
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        mInterstitialAd.adListener = object: AdListener(){
            override fun onAdLoaded() {
                mInterstitialAd.show()
                super.onAdLoaded()
            }
        }
    }
}