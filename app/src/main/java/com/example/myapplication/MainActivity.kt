package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageSetter = ImageSetter.Builder().width(150.0).build()

        val square: Square = Square()

        val calculation: Calculation = Calculation(0)

        val calculation2 : Calculation = Square()
        calculation2.calArea(10,10)
        print("${calculation2.calArea(10,10)}")
//        val square2 : Square = Calculation()

    }
}