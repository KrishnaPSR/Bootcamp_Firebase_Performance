package com.example.firebase

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class DemoService: FirebaseMessagingService() {
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        Log.d("onMessageReceived","${p0.messageId}")
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("onNewToken","${token}")
    }
}