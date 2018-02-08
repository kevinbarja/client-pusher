package com.icorebiz.clientpusher.preference

import android.content.Context

class PusherPreference(context: Context) : BasePreference(context, "pusher") {
    var pusherInstalled: Boolean by PreferenceDelegate()
    var pusherToken: String by PreferenceDelegate()
    var playServiceAvailable : Boolean by PreferenceDelegate()
}