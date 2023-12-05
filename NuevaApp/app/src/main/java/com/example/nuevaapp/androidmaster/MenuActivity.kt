package com.example.nuevaapp.androidmaster

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.nuevaapp.R
import com.example.nuevaapp.androidmaster.edadcaninaapp.EdadCaninaActivity
import com.example.nuevaapp.androidmaster.firstapp.MainActivity
import com.example.nuevaapp.androidmaster.imcapp.ImcActivity
import com.example.nuevaapp.androidmaster.todoapp.TodoActivity
import com.example.nuevaapp.androidmaster.vozapp.VozActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener { openActivity(VozActivity::class.java) }
        button3.setOnClickListener { openActivity(ImcActivity::class.java) }
        button4.setOnClickListener { openActivity(EdadCaninaActivity::class.java) }
        button5.setOnClickListener { openActivity(TodoActivity::class.java) }
    }

    private fun openActivity(activity: Class<out Activity>) {
        val intent = Intent (this, activity)
        startActivity(intent)
    }

}