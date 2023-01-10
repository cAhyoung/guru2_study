package com.example.mediaplayer

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class MusicService : Service() {

    lateinit var mediaPlayer: MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
        TODO("Return the communication channel to the service.")
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i("서비스 테스트", "onStartCommand()")

        mediaPlayer = MediaPlayer.create(this, R.raw.song1)
        mediaPlayer.isLooping = true
        mediaPlayer.start()


        return super.onStartCommand(intent, flags, startId)
    }

    override fun onCreate() {
        Log.i("서비스 테스트", "onCreate()")

        super.onCreate()
    }

    override fun onDestroy() {
        Log.i("서비스 테스트", "onDestroy()")

        mediaPlayer.stop()

        super.onDestroy()
    }
}