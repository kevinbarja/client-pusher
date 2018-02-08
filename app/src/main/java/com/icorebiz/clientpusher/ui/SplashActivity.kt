package com.icorebiz.clientpusher.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewCompat
import android.support.v4.view.animation.FastOutSlowInInterpolator
import com.icorebiz.clientpusher.R
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ViewCompat.animate(logo)
                .scaleX(1F)
                .scaleY(1F)
                .alpha(1F)
                .setInterpolator(FastOutSlowInInterpolator())
                .setStartDelay(150)
                .setDuration(1000)
                .withEndAction {
                    setup()
                }
                .start()
    }

    private fun setup(){
        // Check Pusher
        Thread.sleep(500)
        startActivity<MainActivity>()
        finish()
    }
}
