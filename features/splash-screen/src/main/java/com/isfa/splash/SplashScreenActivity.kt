package com.isfa.splash

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            // Navigate to Home screen
            val applink = "bps-app://home"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(applink))
            startActivity(intent)
            finish()
        }, 3000)
    }
}