package com.example.nuevaapp.androidmaster.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.nuevaapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnInicio = findViewById<AppCompatButton>(R.id.buttonInicio)
        val etNombre = findViewById<AppCompatEditText>(R.id.nombre)

        btnInicio.setOnClickListener {
            val nombre: String = etNombre.text.toString()
            if (nombre.isNotEmpty()){
                val intent = Intent(this, ResultadoActivity::class.java )
                intent.putExtra("EXTRA_NAME",nombre)
                startActivity(intent)

            }

        }
    }


}