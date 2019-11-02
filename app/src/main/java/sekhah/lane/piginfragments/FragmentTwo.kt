package sekhah.lane.piginfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment2.*

class FragmentTwo : Fragment() {

    private var pigGame = PigGame()
    private var die = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val player1 = (activity as SecondActivity).player1Name()
        val player2 = (activity as SecondActivity).player2Name()
        player1NameTextView.text = player1
        player2NameTextView.text = player2

        rollDieButton.setOnClickListener {
            die = pigGame.rollDie()
            if (die == 1) {
                rollDieButton.isEnabled = false
                turnButton.text = "End Turn"
                pigGame.changeTurn()
            }
            updateScreen()
        }

        turnButton.setOnClickListener {
            if (turnButton.text == "Start Turn") {
                turnButton.text = "End Turn"
                rollDieButton.isEnabled = true
            } else {
                turnButton.text = "Start Turn"
                rollDieButton.isEnabled = false
                pigGame.changeTurn()
                die = 0
            }
            updateScreen()
        }

        updateScreen()
    }

    private fun updateScreen() {
        if (pigGame.currentPlayer == 1)
            nextTurnTextView.text = "${player1NameTextView.text}'s Turn"
        else
            nextTurnTextView.text = "${player2NameTextView.text}'s Turn"

        player1ScoreTextView.text = pigGame.player1Score.toString()
        player2ScoreTextView.text = pigGame.player2Score.toString()
        turnPointsTextView.text = pigGame.turnPoints.toString()

        // Check for winner
        if (pigGame.checkForWinner() != -1) {
            when (pigGame.checkForWinner()) {
                0 -> nextTurnTextView.text = "It is a tie!"
                1 -> nextTurnTextView.text = "${player1NameTextView.text} Wins!"
                2 -> nextTurnTextView.text = "${player2NameTextView.text} Wins!"
            }
            rollDieButton.isEnabled = false
            turnButton.isEnabled = false
        }

        // Update the die image
        when (die) {
            0 -> dieImageView.setImageResource(R.drawable.pig)
            1 -> dieImageView.setImageResource(R.drawable.die1)
            2 -> dieImageView.setImageResource(R.drawable.die2)
            3 -> dieImageView.setImageResource(R.drawable.die3)
            4 -> dieImageView.setImageResource(R.drawable.die4)
            5 -> dieImageView.setImageResource(R.drawable.die5)
            6 -> dieImageView.setImageResource(R.drawable.die6)
        }
    }
}
