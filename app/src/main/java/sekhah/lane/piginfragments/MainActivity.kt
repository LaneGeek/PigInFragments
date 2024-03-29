package sekhah.lane.piginfragments

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IPig {

    private var player1Name = ""
    private var player2Name = ""
    private var onePaneLayout = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Using my own hack to find out if one or two panes are running. I created a FrameLayout
        // with a TextView for the sole purpose so that I can check if it exists. If it does then
        // I know that there are two fragments on the screen at the same time.
        onePaneLayout = bigScreenActiveTextView == null
    }

    fun newGame() {
        if (onePaneLayout) {
            // Start SecondActivity
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("player1Name", player1Name)
            intent.putExtra("player2Name", player2Name)
            startActivity(intent)
        } else {
            // Launch FragmentTwo within this activity
            val frag = FragmentTwo()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment2, frag)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    fun playerNames(player1Name: String, player2Name: String) {
        this.player1Name = player1Name
        this.player2Name = player2Name
    }

    override fun player1Name(): String = player1Name
    override fun player2Name(): String = player2Name
}
