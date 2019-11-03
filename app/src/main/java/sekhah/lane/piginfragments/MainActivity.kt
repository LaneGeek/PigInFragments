package sekhah.lane.piginfragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), IPig {

    private var player1Name = ""
    private var player2Name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun newGame() {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("player1Name", player1Name)
        intent.putExtra("player2Name", player2Name)
        startActivity(intent)
    }

    fun playerNames(player1Name: String, player2Name: String) {
        this.player1Name = player1Name
        this.player2Name = player2Name
    }

    override fun player1Name(): String = player1Name
    override fun player2Name(): String = player2Name
}
