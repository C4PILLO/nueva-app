package com.example.nuevaapp.androidmaster.edadcaninaapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.nuevaapp.R

class EdadCaninaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edadcanina)

        val ageEdit : EditText = findViewById<EditText>(R.id.age_edit)
        val resultText: TextView = findViewById<TextView>(R.id.result_text)
        val button : Button = findViewById(R.id.button)

        button.setOnClickListener {

            val ageString: String = ageEdit.text.toString()

            if (ageString.isNotEmpty()) {
                val ageInt = ageString.toInt()
                val result: Int = ageInt * 7
                resultText.text = "Tu edad canina es $result años"
            } else if (ageString.isEmpty()){
                Toast.makeText(this, "Debes insertar tu edad", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
