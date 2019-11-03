package sekhah.lane.piginfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment1.*

class FragmentOne : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        newGameButton.setOnClickListener {
            val player1 = player1EditText.text.toString()
            val player2 = player2EditText.text.toString()

            // Calling functions in MainActivity
            (activity as MainActivity).playerNames(player1, player2)
            (activity as MainActivity).newGame()
        }
    }
}
