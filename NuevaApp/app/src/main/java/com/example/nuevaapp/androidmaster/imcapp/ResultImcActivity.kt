package com.example.nuevaapp.androidmaster.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.nuevaapp.R
import com.example.nuevaapp.androidmaster.imcapp.ImcActivity.Companion.IMC_KEY

class ResultImcActivity : AppCompatActivity() {
    private lateinit var tvResoult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnReCalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        volver()
    }

    private fun volver() {
        btnReCalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        tvIMC.text = result.toString()
        when(result){
            in 0.00..18.50 -> { //Bajo peso
                tvResoult.text = getString(R.string.bajo_peso)
                tvResoult.setTextColor(ContextCompat.getColor(this,R.color.peso_bajo))
                tvDescription.text = getString(R.string.dBajo_peso)
            }
            in 18.51..24.99 -> { //Peso normal
                tvResoult.text = getString(R.string.peso_normal)
                tvResoult.setTextColor(ContextCompat.getColor(this,R.color.peso_normal))
                tvDescription.text = getString(R.string.dPeso_normal)
            }
            in 25.00..29.50 -> { //Sobrepeso
                tvResoult.text = getString(R.string.sobrepeso)
                tvResoult.setTextColor(ContextCompat.getColor(this,R.color.peso_sobrepeso))
                tvDescription.text = getString(R.string.dSobrepeso)
            }
            in 30.00..99.00 -> { //Obesidad
                tvResoult.text = getString(R.string.obeso)
                tvResoult.setTextColor(ContextCompat.getColor(this,R.color.obesidad))
                tvDescription.text = getString(R.string.dObeso)
            }
            else ->{
                tvIMC.text = getString(R.string.error)
                tvResoult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }

    private fun initComponents(){
        tvIMC = findViewById(R.id.tvIMC)
        tvResoult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }
}