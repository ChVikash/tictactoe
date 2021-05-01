package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() , View.OnClickListener{
    var player = true
    var turn_count = 0
    lateinit var board : Array<Array<Button>>
    var boardStatus = Array(3){IntArray(3)}

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
        intialiseBoard()

        var resetbtn: Button = findViewById(R.id.resetbtn)
        resetbtn.setOnClickListener({
            intialiseBoard()
            player = true
            turn_count = 0
        })

    }

    private fun intialiseBoard() {
        for(i in 0..2){
            for (j in 0..2){
                boardStatus[i][j] = -1
                board[i][j].isEnabled = true
                board[i][j].setText("")
            }
        }
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn1 -> {
                updatestatus(0 , 0 , player)

            }
            R.id.btn2 -> {
                updatestatus(0 , 1 , player)
            }
            R.id.btn3 -> {
                updatestatus(0 , 2 , player)
            }
            R.id.btn4 -> {
                updatestatus(1 , 0 , player)
            }
            R.id.btn5 -> {
                updatestatus(1 , 1 , player)
            }
            R.id.btn6 -> {
                updatestatus(1 , 2 , player)
            }
            R.id.btn7 -> {
                updatestatus(2 , 0 , player)
            }
            R.id.btn8 -> {
                updatestatus(2 , 1 , player)
            }
            R.id.btn9 -> {
                updatestatus(2 , 2 , player)
            }
        }
        player = if (player) false else true
    }

    private fun updatestatus(row: Int, col: Int, player: Boolean) {
        val x = if(player)  "X" else "O"
        val y = if(player) 1 else 0
        board[row][col].apply {
            isEnabled = false
            setText(x)
        }
        boardStatus[row][col] = y

    }
}