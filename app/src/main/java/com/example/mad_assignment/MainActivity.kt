package com.example.mad_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var addition:Button
    lateinit var multiplication:Button
    lateinit var substraction:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        addition = findViewById<Button>(R.id.addButton)
        multiplication = findViewById<Button>(R.id.mulButton)
        substraction = findViewById(R.id.subButton)

        addition.setOnClickListener{
            val intent = Intent(this,AddActivity::class.java )
            startActivity(intent)

        }

    }
}