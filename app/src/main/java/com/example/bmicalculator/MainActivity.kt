package com.example.bmicalculator

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(textViewBMI.windowToken, 0)
            calculate()
        }
    }

    private fun calculate(){
        val weight: Double = editTextWeight.text.toString().toDouble();
        val height: Double = editTextHeight.text.toString().toDouble();

        var bmi = String.format("%.2f", weight/((height/100)*(height/100)))

        if(bmi.toDouble() < 18.5){
            val underweight : ImageView = findViewById(R.id.imageViewProfile)
            underweight.setImageResource(R.drawable.under)
            textViewBMI.text = "BMI: " + bmi.toString() + " (Underweight)"
        }else if(bmi.toDouble() > 18.5 && bmi.toDouble() < 24.9 ){
            val normal : ImageView = findViewById(R.id.imageViewProfile)
            normal.setImageResource(R.drawable.normal)
            textViewBMI.text = "BMI: " + bmi.toString() + " (Normal)"
        }else if(bmi.toDouble() > 25){
            val over : ImageView = findViewById(R.id.imageViewProfile)
            over.setImageResource(R.drawable.over)
            textViewBMI.text = "BMI: " + bmi.toString() + " (Overweight)"
        }else{
            val default : ImageView = findViewById(R.id.imageViewProfile)
            default.setImageResource(R.drawable.empty)
        }
    }
}
