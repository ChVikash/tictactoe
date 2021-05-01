package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() , View.OnClickListener{
    lateinit var board : Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var btn1 = findViewById<Button>(R.id.btn1)
        var btn2 = findViewById<Button>(R.id.btn2)
        var btn3 = findViewById<Button>(R.id.btn3)
        var btn4 = findViewById<Button>(R.id.btn4)
        var btn5 = findViewById<Button>(R.id.btn5)
        var btn6 = findViewById<Button>(R.id.btn6)
        var btn7 = findViewById<Button>(R.id.btn7)
        var btn8 = findViewById<Button>(R.id.btn8)
        var btn9 = findViewById<Button>(R.id.btn9)

        board = arrayOf(
                arrayOf(btn1, btn2, btn3),
                arrayOf(btn4, btn5, btn6),
                arrayOf(btn7, btn8, btn9)
        )

        for(x in board){
            for(button in x){
                button.setOnClickListener(this)
            }
        }
        var resetbtn: Button = findViewById(R.id.resetbtn)
        resetbtn.setOnClickListener({

        })

    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn1 -> {

            }
            R.id.btn2 -> {

            }
            R.id.btn3 -> {

            }
            R.id.btn4 -> {

            }
            R.id.btn5 -> {

            }
            R.id.btn6 -> {

            }
            R.id.btn7 -> {

            }
            R.id.btn8 -> {

            }
            R.id.btn9 -> {

            }
        }
    }
}