package com.example.tosscoin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.tosscoin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.btnToss.setOnClickListener {
            flipCoin()
            binding.txtResult.isVisible=true
        }

        flipCoin()
    }

    @SuppressLint("SetTextI18n")
    private fun flipCoin() {
        val coin = Coin()
        val coinRoll:Int= coin.roll()
        if (binding.etValue.text.isNullOrEmpty()){
            binding.txtResult.text="Invalid Enter Type"
            return
        }
        if (binding.etValue.text.toString().toInt()>2||binding.etValue.text.toString().toInt()<1){
            binding.txtResult.text="Invalid Entry Type"
            return
        }
        if (binding.etValue.text.toString().toInt()==coinRoll){
            binding.txtResult.text="You Won "
        }
        else{
            binding.txtResult.text="You loss "
        }
        val image=when(coinRoll){
            1-> R.drawable.headisde
            2-> R.drawable.tailside
            else ->R.drawable.oopps
        }
        binding.imgResult.setImageResource(image)

    }
    class Coin(private val faces: Int = 2) {
        fun roll(): Int {
            return (1..faces).random()
        }
    }

}
