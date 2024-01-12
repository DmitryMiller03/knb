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

        var signPlayer: ImageSign

        rockBtn.setOnClickListener {
            signPlayer = ImageSign.ROCK
            val signComp = this.getRandomSign()
            val result = this.analyzeMove(signPlayer, signComp)
            this.startSecondActivity(result, signPlayer, signComp)
        }

        cutBtn.setOnClickListener {
            signPlayer = ImageSign.CUT
            val signComp = this.getRandomSign()
            val result = this.analyzeMove(signPlayer, signComp)
            this.startSecondActivity(result, signPlayer, signComp)
        }

        paperBtn.setOnClickListener {
            signPlayer = ImageSign.PAPER
            val signComp = this.getRandomSign()
            val result = this.analyzeMove(signPlayer, signComp)
            this.startSecondActivity(result, signPlayer, signComp)
        }
    }

    private fun startSecondActivity(result: String, signPlayer: ImageSign, signComp: ImageSign) {
        val resultIntent = Intent(this, SecondActivity::class.java)
        resultIntent.putExtra("RESULT", result)
        resultIntent.putExtra("SIGN_PLAYER", signPlayer.toString().lowercase())
        resultIntent.putExtra("SIGN_COMP", signComp.toString().lowercase())
        startActivity(resultIntent)
    }

    private fun getRandomSign(): ImageSign {
        var signComp: ImageSign
        val randomNumber = Random.nextInt(1, 4)
        if (randomNumber == 1) {
            signComp = ImageSign.ROCK
        }
        else if (randomNumber == 2) {
            signComp = ImageSign.CUT
        }
        else {
            signComp = ImageSign.PAPER
        }
        return signComp
    }

    private fun analyzeMove(signPlayer: ImageSign, signComp: ImageSign): String{
        if (!this.isEqual(signPlayer, signComp)) {
            if (this.isWinner(signPlayer, signComp)) {
                return "win"
            } else {
                return "loose"
            }
        }
            else {
                return "tie"
            }
    }

    private fun isEqual(signPlayer: ImageSign, signComp: ImageSign): Boolean {
        return signPlayer == signComp
    }

    private fun isWinner(signPlayer: ImageSign, signComp: ImageSign): Boolean {
        val move = signPlayer.toString() + signComp
        if (ImageSign.ROCK.toString() + ImageSign.PAPER == move)
            return false
        else if (ImageSign.PAPER.toString() + ImageSign.CUT == move)
            return false
        else if (ImageSign.CUT.toString() + ImageSign.ROCK == move)
            return false
        return true
    }

}
