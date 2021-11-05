package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.button)


        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(6)

        val diceRoll = dice.roll()
        val luckyNumber = 4

        val resultTextView: TextView = findViewById(R.id.textView)
        val resultMessageTextView : TextView = findViewById(R.id.messageTextView)

        resultTextView.text = "$diceRoll"

        resultMessageTextView.text = when(diceRoll) {
            luckyNumber -> "You Won!"
            1 -> "So sorry! You rolled a 1. Try again!"
            2 -> "Sadly, you rolled a 2. Try again!"
            3 -> "Unfortunately, you rolled a 3. Try again!"
            5 -> "Don't cry! You rolled a 5. Try again!"
            6 -> "Apologies! you rolled a 6. Try again!"
            else -> "Result"
        }
    }
}

class Dice(private val numSides : Int) {

    fun roll() : Int {
        return (1..numSides).random()
    }
}