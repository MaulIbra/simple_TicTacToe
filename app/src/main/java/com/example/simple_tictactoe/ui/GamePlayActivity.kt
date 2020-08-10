package com.example.simple_tictactoe.ui

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.simple_tictactoe.R
import com.example.simple_tictactoe.models.Player
import com.example.simple_tictactoe.utils.PLAYER_ONE_NAME
import com.example.simple_tictactoe.utils.PLAYER_ONE_PICK_LABEL
import com.example.simple_tictactoe.utils.PLAYER_TWO_NAME
import com.example.simple_tictactoe.utils.PLAYER_TWO_PICK_LABEL
import kotlinx.android.synthetic.main.activity_game_play.*
import kotlinx.android.synthetic.main.activity_main.*

class GamePlayActivity : AppCompatActivity() {

    private var turnsPlayer = Player(0,"","")
    private var playerOne = Player(0,"","")
    private var playerTwo = Player(0,"","")
    private var board = arrayOf(
        arrayOf("", "", ""),
        arrayOf("", "", ""),
        arrayOf("", "", "")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_play)
        val playerOneName = intent.getStringExtra(PLAYER_ONE_NAME)
        val playerTwoName = intent.getStringExtra(PLAYER_TWO_NAME)
        playerOne = Player(1, playerOneName, PLAYER_ONE_PICK_LABEL)
        playerTwo = Player(2, playerTwoName, PLAYER_TWO_PICK_LABEL)
        turnsPlayer = playerOne
        tvPlayerTurns.text = "${turnsPlayer.playerName} Turn"
    }

    fun handleClick(view: View) {
        when (view.id) {
            btn00.id -> btn00.text = turnsPlayer.playerPickLabel
            btn01.id -> btn01.text = turnsPlayer.playerPickLabel
            btn02.id -> btn02.text = turnsPlayer.playerPickLabel
            btn10.id -> btn10.text = turnsPlayer.playerPickLabel
            btn11.id -> btn11.text = turnsPlayer.playerPickLabel
            btn12.id -> btn12.text = turnsPlayer.playerPickLabel
            btn20.id -> btn20.text = turnsPlayer.playerPickLabel
            btn21.id -> btn21.text = turnsPlayer.playerPickLabel
            btn22.id -> btn22.text = turnsPlayer.playerPickLabel
        }
        view.isClickable = false
        val rowCol = view.tag.toString()
        board[Character.getNumericValue(rowCol[0])][Character.getNumericValue(rowCol[1])] = turnsPlayer.playerPickLabel

        if (checkGameResult()) {
            tvPlayerWin.text = turnsPlayer.playerName
            rlWinPopup.visibility = View.VISIBLE
        }

        switchPlayer()
    }

    private fun switchPlayer(){
        if (turnsPlayer == playerOne) {
            turnsPlayer = playerTwo
        } else {
            turnsPlayer = playerOne
        }
        tvPlayerTurns.text = "${turnsPlayer.playerName} Turn"
    }


    private fun checkGameResult(): Boolean {
        if (hasThreeSameDiagonalCell() || hasThreeSameHorizontalCell() || hasThreeSameVerticalCell()){
            return true
        }
        return false
    }

    private fun hasThreeSameHorizontalCell() :Boolean{
        for (i in 0..2) {
            if ((board[i][0] == board[i][1]) && (board[i][0] == board[i][2]) && (board[i][0] != "")) {
                return true
            }
        }
        return false
    }

    private fun hasThreeSameVerticalCell() :Boolean{
        for (i in 0..2) {
            if ((board[0][i] == board[1][i]) && (board[0][i] == board[2][i]) && (board[0][i] != "")) {
                return true
            }
        }
        return false
    }

    private fun hasThreeSameDiagonalCell() :Boolean{
        if ((board[0][0]==(board[1][1])) && (board[0][0] == board[2][2]) && (board[0][0] != "")) {
            return true
        }
        if ((board[0][2] == board[1][1]) && (board[0][2] == board[2][0]) && (board[0][2] != "")) {
            return true
        }
        return false
    }

    fun handleBackBtn(view: View) {
        onBackPressed()
    }
}
