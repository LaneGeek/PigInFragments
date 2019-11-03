// The only purpose of this interface is so that FragmentTwo can work with both main activity or second activity,
// without knowing which activity called it. So that instead of casting the activity as either MainActivity or
// SecondActivity we can instead cast the activity as IPig.

package sekhah.lane.piginfragments

interface IPig {
    fun player1Name(): String
    fun player2Name(): String
}
