package sekhah.lane.piginfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment2.*

class FragmentTwo : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val player1 = (activity as SecondActivity).player1Name()
        val player2 = (activity as SecondActivity).player2Name()
        player1NameTextView.text = player1
        player2NameTextView.text = player2

        rollDieButton.setOnClickListener() {
            Toast.makeText(activity, "Roll", Toast.LENGTH_SHORT).show()
        }
    }
}
