package com.example.knb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.lesson2.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        this.roundResult()
        this.movement()
    }

    private fun roundResult() {
        val resultImg = findViewById<ImageView>(R.id.res_image)
        val result = intent.getStringExtra("RESULT")
        if (result == "win")
            resultImg.setImageResource(R.drawable.winimg)
        else if (result == "lose")
            resultImg.setImageResource(R.drawable.looseimg)
        else if (result == "tie")
            resultImg.setImageResource(R.drawable.tieimg)
    }

    private fun movement() {
        val playerMove = findViewById<ImageView>(R.id.player)
        val compMove = findViewById<ImageView>(R.id.computer)
        val signPlayer = intent.getStringExtra("SIGN_PLAYER")
        val signComp = intent.getStringExtra("SIGN_COMP")

        if (signPlayer == "rock")
            playerMove.setImageResource(R.drawable.rock)
        if (signComp == "rock")
            compMove.setImageResource(R.drawable.rock)
        if (signPlayer == "cut")
            playerMove.setImageResource(R.drawable.scissors)
        if (signComp == "cut")
            compMove.setImageResource(R.drawable.scissors)
        if (signPlayer == "paper")
            playerMove.setImageResource(R.drawable.paper)
        if (signComp == "paper")
            compMove.setImageResource(R.drawable.paper)
    }
}