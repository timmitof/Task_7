package com.timmitof.practice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var resultTextView: TextView
    lateinit var backButton: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        
        resultTextView = findViewById(R.id.tvText)
        backButton = findViewById(R.id.backBtn)

        resultTextView.text = intent.getStringExtra("RESULTWHILE")
        resultTextView.text = intent.getStringExtra("RESULTFOR")


        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}