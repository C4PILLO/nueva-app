package com.example.nuevaapp.androidmaster.vozapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.Button
import android.widget.TextView
import com.example.nuevaapp.R
import java.util.Locale

class VozActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var tts: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_voz)
        tts = TextToSpeech(this,this)
        findViewById<Button>(R.id.btnPlay).setOnClickListener { speak() }
    }
    private fun speak(){
        var message: String = findViewById<TextView>(R.id.etMessage).text.toString()
        if (message.isEmpty()){
            findViewById<TextView>(R.id.holaKotlin).text = getString(R.string.introduzca_el_texcto)
            message = getString(R.string.alerta)
        }
        tts!!.speak(message, TextToSpeech.QUEUE_FLUSH,null,"")
    }
    override fun onInit(status: Int) {
        if ( status == TextToSpeech.SUCCESS) {
            findViewById<TextView>(R.id.holaKotlin).text = getString(R.string.listo)
            tts!!.language = Locale("ES")
        } else{
            findViewById<TextView>(R.id.holaKotlin).text = getString(R.string.no_disponible)
        }
    }

    override fun onDestroy() {
        if (tts != null) {
            tts!!.stop()
            tts!!.shutdown()
        }
        super.onDestroy()
    }
}