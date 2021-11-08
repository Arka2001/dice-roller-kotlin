package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton : Button = findViewById(R.id.button)

        // Do a dice Roll once the "Roll" button is clicked
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice1 = Dice(6)
        val dice2 = Dice(6)

        val diceRoll1 = dice1.roll()
        val diceRoll2 = dice2.roll()

        // Create an array of the drawable resources which are going to be displayed on the screen
        val diceImageIdList = arrayOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6,
        )

        // Take a reference of the ImageView which we are going to update by using findViewById method
        val diceImage1: ImageView = findViewById(R.id.imageView)
        val diceImage2: ImageView = findViewById(R.id.imageView2)

        // Finally update the image view using the value returned by the roll() method of the Dice class
        diceImage1.setImageResource(diceImageIdList[diceRoll1-1])
        diceImage2.setImageResource(diceImageIdList[diceRoll2-1])

        // Update the contentDescription
        diceImage1.contentDescription = diceRoll1.toString()
        diceImage2.contentDescription = diceRoll2.toString()
    }
}

class Dice(private val numSides : Int) {

    fun roll() : Int {
        return (1..numSides).random()
    }
}