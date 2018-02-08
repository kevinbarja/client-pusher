package com.icorebiz.clientpusher.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class FcmMessagingReceiver : BroadcastReceiver(), AnkoLogger {

    override fun onReceive(context: Context?, intent: Intent?) {
        info("Firebase: onReceive")
        val extras = intent?.extras
        if (extras != null) {
            val data = extras.getString("data")
            info("Firebase: data: $data")
        }
    }

}