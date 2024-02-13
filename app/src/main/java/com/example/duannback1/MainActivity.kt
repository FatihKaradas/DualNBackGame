package com.example.duannback1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.collections.HashSet

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
 private var counter:Int = 0
 private var counter2:Int = 0
 private var counter3:Double = 0.00
 private var counter4:Int = 0
 private lateinit var  skor:TextView
class MainActivity : AppCompatActivity() {
    private val squareImageViews = arrayOfNulls<ImageView>(9)
    private val numbers = intArrayOf(0)
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
        /* squareImageView0.isClickable=false
        squareImageView1.isClickable=false
        squareImageView2.isClickable=false
        squareImageView3.isClickable=false
        squareImageView4.isClickable=false
        squareImageView5.isClickable=false
        squareImageView6.isClickable=false
        squareImageView7.isClickable=false
        squareImageView8.isClickable=false*/
        StartButton = findViewById(R.id.StartButton)
        StartButton.setOnClickListener{
            startGame()
        }
    }
    private fun startGame() {
        skor.text="Success Rate:"
        counter=0
        counter2 = 0
        counter3 = 0.00
        stepCount = 0
        counter4 = 0
        showNextStep()
    }
    private val previousNumbers = mutableMapOf<Int, HashSet<Int>>()

    private fun showNextStep() {
        if (stepCount < 10) {
            squareImageView0=findViewById(R.id.squareImageView0)
            squareImageView1=findViewById(R.id.squareImageView1)
            squareImageView2=findViewById(R.id.squareImageView2)
            squareImageView3=findViewById(R.id.squareImageView3)
            squareImageView4=findViewById(R.id.squareImageView4)
            squareImageView5=findViewById(R.id.squareImageView5)
            squareImageView6=findViewById(R.id.squareImageView6)
            squareImageView7=findViewById(R.id.squareImageView7)
            squareImageView8=findViewById(R.id.squareImageView8)
           /* squareImageView0.isClickable=true
            squareImageView1.isClickable=true
            squareImageView2.isClickable=true
            squareImageView3.isClickable=true
            squareImageView4.isClickable=true
            squareImageView5.isClickable=true
            squareImageView6.isClickable=true
            squareImageView7.isClickable=true
            squareImageView8.isClickable=true*/
            val random = Random()
            val randomIndex = random.nextInt(9)
            val selectedImageView = squareImageViews[randomIndex]!!
            val randomNumber = getRandomItem(numbers)
            selectedImageView.setImageResource(getDrawableResource(randomNumber))

            // Eğer seçilen kare daha önce atanmış bir sayıya sahipse, counter'ı artır
            if (previousNumbers.containsKey(randomIndex) && previousNumbers[randomIndex]!!.contains(randomNumber)) {
                counter++
            }

            // Seçilen karenin daha önce atanmış sayılarını güncelle
            if (!previousNumbers.containsKey(randomIndex)) {
                previousNumbers[randomIndex] = HashSet()
            }
            previousNumbers[randomIndex]!!.add(randomNumber)

            // Kareye tıklama olayı
            squareImageView0.setOnClickListener {
                // Daha önce bu kareye aynı sayı atanmış mı kontrol et
                val correctMatch = previousNumbers.containsKey(randomIndex) && previousNumbers[randomIndex]!!.contains(randomNumber)
                // Doğru eşleşme durumu
                if (correctMatch) {
                    counter2++
                    Toast.makeText(this, "Correct Match", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect Matching", Toast.LENGTH_SHORT).show()
                }
            }
            squareImageView1.setOnClickListener {
                // Daha önce bu kareye aynı sayı atanmış mı kontrol et
                val correctMatch = previousNumbers.containsKey(randomIndex) && previousNumbers[randomIndex]!!.contains(randomNumber)
                // Doğru eşleşme durumu
                if (correctMatch) {
                    counter2++
                    Toast.makeText(this, "Correct Match", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect Matching", Toast.LENGTH_SHORT).show()
                }
            }
            squareImageView2.setOnClickListener {
                // Daha önce bu kareye aynı sayı atanmış mı kontrol et
                val correctMatch = previousNumbers.containsKey(randomIndex) && previousNumbers[randomIndex]!!.contains(randomNumber)
                // Doğru eşleşme durumu
                if (correctMatch) {
                    counter2++
                    Toast.makeText(this, "Correct Match", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect Matching", Toast.LENGTH_SHORT).show()
                }
            }
            squareImageView3.setOnClickListener {
                // Daha önce bu kareye aynı sayı atanmış mı kontrol et
                val correctMatch = previousNumbers.containsKey(randomIndex) && previousNumbers[randomIndex]!!.contains(randomNumber)
                // Doğru eşleşme durumu
                if (correctMatch) {
                    counter2++
                    Toast.makeText(this, "Correct Match", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect Matching", Toast.LENGTH_SHORT).show()
                }
            }
            squareImageView4.setOnClickListener {
                // Daha önce bu kareye aynı sayı atanmış mı kontrol et
                val correctMatch = previousNumbers.containsKey(randomIndex) && previousNumbers[randomIndex]!!.contains(randomNumber)
                // Doğru eşleşme durumu
                if (correctMatch) {
                    counter2++
                    Toast.makeText(this, "Correct Match", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect Matching", Toast.LENGTH_SHORT).show()
                }
            }
            squareImageView5.setOnClickListener {
                // Daha önce bu kareye aynı sayı atanmış mı kontrol et
                val correctMatch = previousNumbers.containsKey(randomIndex) && previousNumbers[randomIndex]!!.contains(randomNumber)
                // Doğru eşleşme durumu
                if (correctMatch) {
                    counter2++
                    Toast.makeText(this, "Correct Match", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect Matching", Toast.LENGTH_SHORT).show()
                }
            }
            squareImageView6.setOnClickListener {
                // Daha önce bu kareye aynı sayı atanmış mı kontrol et
                val correctMatch = previousNumbers.containsKey(randomIndex) && previousNumbers[randomIndex]!!.contains(randomNumber)
                // Doğru eşleşme durumu
                if (correctMatch) {
                    counter2++
                    Toast.makeText(this, "Correct Match", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect Matching", Toast.LENGTH_SHORT).show()
                }
            }
            squareImageView7.setOnClickListener {
                // Daha önce bu kareye aynı sayı atanmış mı kontrol et
                val correctMatch = previousNumbers.containsKey(randomIndex) && previousNumbers[randomIndex]!!.contains(randomNumber)
                // Doğru eşleşme durumu
                if (correctMatch) {
                    counter2++
                    Toast.makeText(this, "Correct Match", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect Matching", Toast.LENGTH_SHORT).show()
                }
            }
            squareImageView8.setOnClickListener {
                // Daha önce bu kareye aynı sayı atanmış mı kontrol et
                val correctMatch = previousNumbers.containsKey(randomIndex) && previousNumbers[randomIndex]!!.contains(randomNumber)
                // Doğru eşleşme durumu
                if (correctMatch) {
                    counter2++
                    Toast.makeText(this, "Correct Match", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Incorrect Matching", Toast.LENGTH_SHORT).show()
                }
            }
            Handler(Looper.getMainLooper()).postDelayed({
                selectedImageView.setImageResource(0)
                stepCount++
                showNextStep()
            }, 1500)
        } else {
            counter3 = ((counter2.toDouble() / counter.toDouble())*100)
            counter4=counter3.toInt()
            skor.text = "Success Rate:%$counter4"
            previousNumbers.clear()
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

