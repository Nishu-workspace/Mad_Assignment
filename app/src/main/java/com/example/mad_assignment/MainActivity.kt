package com.example.mad_assignment


import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log

import android.widget.Button

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton


class MainActivity : AppCompatActivity() {

    lateinit var addition:Button
    lateinit var multiplication:Button
    lateinit var substraction:Button
    lateinit var mode:MaterialButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val nightFlag = resources?.configuration?.uiMode?.and(Configuration.UI_MODE_NIGHT_MASK)
        Log.d("nightFlag","$nightFlag")


        addition = findViewById<Button>(R.id.addButton)
        multiplication = findViewById<Button>(R.id.mulButton)
        substraction = findViewById(R.id.subButton)
        mode = findViewById(R.id.buttomMode)
        addition.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
        substraction.setOnClickListener{
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
//        Log.d("nightFlag" , "$nightFlag")
//        }
//        points:
//        you can use any of the below logic, 16 is for light theme and 32 is for darktheme.
//            if(nightFlag==16){
//                mode.icon = (ContextCompat.getDrawable(this,R.drawable.darkmode))
//                mode.text = "Night"
//
//            }
//            else{
//                mode.icon = ContextCompat.getDrawable(this,R.drawable.lightmode)
//                mode.text = "Light"
//
//            }
            when (nightFlag) {
                Configuration.UI_MODE_NIGHT_YES -> {
                    mode.setIcon(ContextCompat.getDrawable(this,R.drawable.lightmode))
                    mode.text = "Light"
                }

                Configuration.UI_MODE_NIGHT_NO -> {
                    mode.setIcon(ContextCompat.getDrawable(this,R.drawable.darkmode))
                    mode.text = "Night"
                }

            }


            mode.setOnClickListener {
                val currentNightMode = resources.configuration.uiMode.and(Configuration.UI_MODE_NIGHT_MASK)
                if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    mode.setIconResource(R.drawable.darkmode)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    mode.setIconResource(R.drawable.lightmode)
                }
            }



    }
    }