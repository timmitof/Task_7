package com.timmitof.practice1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

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
            if (resultWhile.isNullOrEmpty()) Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show()
            else {
                intent.putExtra("TEXTWHILE", resultWhile)
                startActivity(intent)
            }
        }

        buttonUsingFor.setOnClickListener {
            val text = editText.text.toString()
            getValueUsingFor(text)
        }
    }

    fun getValueUsingWhile(text: String) : String? {
        var index = 0

        while (index < array.size){
            if (text == array[index]){
                return "Using 'while' - $text: $index"
            } else if(text.isNullOrEmpty()) {
                return null
            }
            ++index
        }
        return null
    }

    fun getValueUsingFor(text: String){
        val intent = Intent(this, SecondActivity::class.java)

        for (item in array){
            if (item == text) {
                intent.putExtra("TEXT", text)
                intent.putExtra("INDEX", array.indexOf(item))
                startActivity(intent)}

            else if (text.isNullOrEmpty()){
                Toast.makeText(this, "Введите текст", Toast.LENGTH_SHORT).show()
            }
        }
    }

}