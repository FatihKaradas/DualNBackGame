package com.example.duannback1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*
private lateinit var StartButton:Button
private lateinit var squareImageView0:ImageView
private lateinit var squareImageView1:ImageView
private lateinit var squareImageView2:ImageView
private lateinit var squareImageView3:ImageView
private lateinit var squareImageView4:ImageView
private lateinit var squareImageView5:ImageView
private lateinit var squareImageView6:ImageView
private lateinit var squareImageView7:ImageView
private lateinit var squareImageView8:ImageView
 private var stepCount=0
 private var counter = 0
 private lateinit var  skor:TextView


class MainActivity : AppCompatActivity() {
    private val squareImageViews = arrayOfNulls<ImageView>(9)
    private val numbers = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        skor=findViewById(R.id.skor)
        squareImageViews[0] = findViewById(R.id.squareImageView0)
        squareImageViews[1] = findViewById(R.id.squareImageView1)
        squareImageViews[2] = findViewById(R.id.squareImageView2)
        squareImageViews[3] = findViewById(R.id.squareImageView3)
        squareImageViews[4] = findViewById(R.id.squareImageView4)
        squareImageViews[5] = findViewById(R.id.squareImageView5)
        squareImageViews[6] = findViewById(R.id.squareImageView6)
        squareImageViews[7] = findViewById(R.id.squareImageView7)
        squareImageViews[8] = findViewById(R.id.squareImageView8)
        StartButton = findViewById(R.id.StartButton)
        StartButton.setOnClickListener{
            startGame()
        }



    }
    private fun startGame() {
        skor.text="Score:0"
        counter=0
        stepCount = 0
        showNextStep()
    }
    private fun showNextStep(){
        if(stepCount<20){
            val random = Random()
            val randomIndex = random.nextInt(9)
            val selectedImageView = squareImageViews[randomIndex]
            val randomNumber = getRandomItem(numbers)
            if (selectedImageView?.tag == randomNumber) {
                counter++
            }

            // Aynı sayıyı aynı kareye atamamak için önceki sayıyı tag olarak sakla
            selectedImageView?.tag = randomNumber
            selectedImageView?.setImageResource(getDrawableResource(randomNumber))
            Handler(Looper.getMainLooper()).postDelayed({
                selectedImageView?.setImageResource(0)
                stepCount++
                showNextStep()
            }, 1500)


        }
        else {
            skor.text="Score:$counter"
        }

    }
    private fun getDrawableResource(number: Int): Int {
        return when (number) {
            0 -> R.drawable.number_0
            1 -> R.drawable.number_1
            2 -> R.drawable.number_2
            3 -> R.drawable.number_3
            4 -> R.drawable.number_4
            5 -> R.drawable.number_5
            6 -> R.drawable.number_6
            7 -> R.drawable.number_7
            8 -> R.drawable.number_8
            9 -> R.drawable.number_9
            else -> R.drawable.number_0 // Default
        }
    }
    private fun getRandomItem(array: IntArray): Int {
        val random = Random()
        return array[random.nextInt(array.size)]
    }



}
