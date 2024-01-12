package com.example.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rockBtn = findViewById<ImageButton>(R.id.btn_rock)
        val cutBtn = findViewById<ImageButton>(R.id.btn_scis)
        val paperBtn = findViewById<ImageButton>(R.id.btn_paper)

        var signPlayer: String

        rockBtn.setOnClickListener {
            signPlayer = "ROCK"
            val signComp = this.getRandomSign()
            val result = this.analyzeMove(signPlayer, signComp)
            this.startSecondActivity(result, signPlayer, signComp)
        }

        cutBtn.setOnClickListener {
            signPlayer = "CUT"
            val signComp = this.getRandomSign()
            val result = this.analyzeMove(signPlayer, signComp)
            this.startSecondActivity(result, signPlayer, signComp)
        }

        paperBtn.setOnClickListener {
            signPlayer = "PAPER"
            val signComp = this.getRandomSign()
            val result = this.analyzeMove(signPlayer, signComp)
            this.startSecondActivity(result, signPlayer, signComp)
        }
    }

    private fun startSecondActivity(result: String, signPlayer: String, signComp: String) {
        val resultIntent = Intent(this, SecondActivity::class.java)
        resultIntent.putExtra("RESULT", result)
        resultIntent.putExtra("SIGN_PLAYER", signPlayer.toString().lowercase())
        resultIntent.putExtra("SIGN_COMP", signComp.toString().lowercase())
        startActivity(resultIntent)
    }

    private fun getRandomSign(): String {
        var signComp: String
        val randomNumber = Random.nextInt(1, 4)
        if (randomNumber == 1) {
            signComp = "ROCK"
        }
        else if (randomNumber == 2) {
            signComp = "CUT"
        }
        else {
            signComp = "PAPER"
        }
        return signComp
    }

    private fun analyzeMove(signPlayer: String, signComp: String): String{
        val move = signPlayer + signComp
        if (signPlayer != signComp) {
            if ("PAPERROCK" == move)
                return "win"
            else if ("CUTPAPER" == move)
                return "win"
            else if ("ROCKCUT" == move)
                return "win"
            else
                return "loose"
        }
        else return "tie"
    }
}
