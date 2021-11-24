package com.timmitof.practice1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    lateinit var tvText: TextView
    lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        
        tvText = findViewById(R.id.textViewRes)
        backButton = findViewById(R.id.backBtn)

        val inWhile = intent.getStringExtra("TEXTWHILE")
        val inFor = intent.getStringExtra("TEXT")
        val inIndex = intent.getIntExtra("INDEX", 0)

        if (inWhile != null) {
            tvText.text = inWhile
        }

        else if (inFor != null && inIndex != null) {
            val text = inFor
            val index = inIndex
            tvText.text = "Using 'for' - $text: $index"
        }

        backButton.setOnClickListener {
            onBackPressed()
        }
    }
}