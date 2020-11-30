package id.adeds.scarnes_dice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import id.adeds.scarnes_dice.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val userScore = 0
    private val computerScore = 0
    private val userTurnScore = 0
    private val computerTurnScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()
    }

    private fun initClickListener() = binding.apply {
        btnRoll.setOnClickListener {
            updateDice(Random.nextInt(5))
        }
    }

    private fun updateDice(dice: Int) {
        val imgDice = when (dice) {
            0 -> R.drawable.dice1
            1 -> R.drawable.dice2
            2 -> R.drawable.dice3
            3 -> R.drawable.dice4
            4 -> R.drawable.dice5
            5 -> R.drawable.dice6
            else -> null
        }
        binding.imgDice.setImageDrawable(imgDice?.let { ContextCompat.getDrawable(this, it) })
    }
}