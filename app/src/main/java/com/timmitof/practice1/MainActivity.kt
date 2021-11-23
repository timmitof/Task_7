package com.timmitof.practice1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var buttonUsingWhile: Button
    lateinit var buttonUsingFor: Button

    val array = arrayListOf("A", "B", "C", "D", "E")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        buttonUsingWhile = findViewById(R.id.buttonWhile)
        buttonUsingFor = findViewById(R.id.buttonFor)

        buttonUsingWhile.setOnClickListener {
            val text = editText.text.toString()
            val resultWhile = getValueUsingWhile(text)
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("RESULTWHILE", resultWhile)
            startActivity(intent)
        }

        buttonUsingFor.setOnClickListener {
            val text = editText.text.toString()
            val resultFor = getValueUsingFor(text)

        }
    }



    fun getValueUsingWhile(text: String) : String? {
        var index = 0

        while (index < array.size){
            if (text == array[index]){
                return "$text: $index"
            }
            ++index
        }
        return null
    }

    fun getValueUsingFor(text: String){
        var intent = Intent(this, SecondActivity::class.java)

        for (item in array){
            if (item == text){
                val textRes = intent.putExtra("TEXT", text)
                val indexRes = intent.putExtra("INDEX", array.indexOf(item))
                val result = "$textRes: $indexRes"
                intent.putExtra("RESULTFOR", result)
                startActivity(intent)
            }
        }
    }

}