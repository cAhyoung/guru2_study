package service_pra.com.example.service_pra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var soundIntent: Intent
    lateinit var startButton: Button
    lateinit var stopButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        soundIntent = Intent(this, MusicService::class.java)
        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)

        startButton.setOnClickListener{
            startService(soundIntent)
            Log.i("서비스 테스트", "startService()")
        }
        stopButton.setOnClickListener {
            stopService(soundIntent)
            Log.i("서비스테스트", "stopService()")
        }
    }
}