package sekhah.lane.piginfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity(), IPig {

    private var player1Name = ""
    private var player2Name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Let's get the player names from the first fragment
        val intent = intent
        player1Name = intent.getStringExtra("player1Name")
        player2Name = intent.getStringExtra("player2Name")

        // Then set the layout
        setContentView(R.layout.activity_second)
    }

    override fun player1Name(): String = player1Name
    override fun player2Name(): String = player2Name
}
