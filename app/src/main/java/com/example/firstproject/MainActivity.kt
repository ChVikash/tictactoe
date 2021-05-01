package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() , View.OnClickListener{
    var player = true
    var turn_count = 0
    lateinit var board : Array<Array<Button>>
    var boardStatus = Array(3){IntArray(3)}
    lateinit var tv1 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn1:Button = findViewById<Button>(R.id.btn1)
        var btn2:Button = findViewById<Button>(R.id.btn2)
        var btn3:Button = findViewById<Button>(R.id.btn3)
        var btn4:Button = findViewById<Button>(R.id.btn4)
        var btn5:Button = findViewById<Button>(R.id.btn5)
        var btn6:Button = findViewById<Button>(R.id.btn6)
        var btn7:Button = findViewById<Button>(R.id.btn7)
        var btn8:Button = findViewById<Button>(R.id.btn8)
        var btn9:Button = findViewById<Button>(R.id.btn9)

        tv1 = findViewById(R.id.tv1)

        this.board = arrayOf(
                arrayOf(btn1, btn2, btn3),
                arrayOf(btn4, btn5, btn6),
                arrayOf(btn7, btn8, btn9)
        )

        for(x in board){
            for(button in x){
                button.setOnClickListener(this)
            }
        }
        initializeBoard()

        var resetbtn: Button = findViewById(R.id.resetbtn)
        resetbtn.setOnClickListener {
            initializeBoard()
            player = true
            turn_count = 0
            tv1.setText("Player X turn")
        }
        tv1.setText("Player X turn")

    }

    private fun initializeBoard() {
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
                updateStatus(0 , 0 , player)
            }
            R.id.btn2 -> {
                updateStatus(0 , 1 , player)
            }
            R.id.btn3 -> {
                updateStatus(0 , 2 , player)
            }
            R.id.btn4 -> {
                updateStatus(1 , 0 , player)
            }
            R.id.btn5 -> {
                updateStatus(1 , 1 , player)
            }
            R.id.btn6 -> {
                updateStatus(1 , 2 , player)
            }
            R.id.btn7 -> {
                updateStatus(2 , 0 , player)
            }
            R.id.btn8 -> {
                updateStatus(2 , 1 , player)
            }
            R.id.btn9 -> {
                updateStatus(2 , 2 , player)
            }
        }
        turn_count++
        player = if (player) false else true

        if(player == true){
            disptv("Player X turn")
        }else {
            disptv("Player 0 turn")
        }
        if(turn_count == 9) {
            disptv("Draw")
        }
        someoneWon()
    }

    private fun disptv( s: String) {

        tv1.setText(s)
    }

    private fun someoneWon() {
        var winner  = -1
        for (i in 0..2){
            if(boardStatus[i][0] == boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]){
                winner = boardStatus[i][0]
                break
            }
            if(boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]){
               winner = boardStatus[0][i]
                break
            }
            }

        if(winner == -1 && boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]){
            winner = boardStatus[0][0]
        }
        if(winner == -1 && boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]){
            winner = boardStatus[0][2]
        }
        if(winner != -1){
            disableClicks()
            val v = if(winner == 1) "X" else "O"
            disptv("Player $v  Wins")
        }
    }


    private fun disableClicks() {
        for(x in board){
            for(button in x){
                button.isEnabled = false
            }
        }
    }

    private fun updateStatus(row: Int, col: Int, player: Boolean) {
        val x = if(player)  "X" else "O"
        val y = if(player) 1 else 0
        board[row][col].apply {
            isEnabled = false
            setText(x)
        }
        boardStatus[row][col] = y

    }
}