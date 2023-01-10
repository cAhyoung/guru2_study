package timer_pra.com.example.timer_pra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*
import kotlin.concurrent.timer


class MainActivity : AppCompatActivity() {
    private var time = 0
    private var isRunning = false
    private var timerTask: Timer? = null

    lateinit var secEditText: EditText
    lateinit var setButton: Button
    lateinit var secTextView: TextView
    lateinit var milliTextView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        secTextView = findViewById(R.id.secTextView)
        milliTextView = findViewById(R.id.milliTextView)
        secEditText = findViewById(R.id.secEditText)
        setButton = findViewById(R.id.setButton)

        setButton.setOnClickListener{
            time = secEditText.text.toString().toInt()*100
            start()
        }

    }

    private fun start() {
        timerTask = timer(period=10){
            time--
            val sec = time / 100
            val milli = time % 100

            if(sec==0 && milli==0) timerTask?.cancel()

            runOnUiThread{
                secTextView.text = "$sec"
                milliTextView.text = "$milli"
            }
        }
    }

}