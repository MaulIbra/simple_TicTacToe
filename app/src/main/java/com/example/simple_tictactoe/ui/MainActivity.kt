package com.example.simple_tictactoe.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.simple_tictactoe.R
import com.example.simple_tictactoe.utils.PLAYER_ONE_NAME
import com.example.simple_tictactoe.utils.PLAYER_TWO_NAME
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun handleClick(view: View) {
        val intent = Intent(this,GamePlayActivity::class.java)
        intent.putExtra(PLAYER_ONE_NAME,etPlayerOne.text.toString())
        intent.putExtra(PLAYER_TWO_NAME,etPlayerTwo.text.toString())
        startActivity(intent)
    }
}
