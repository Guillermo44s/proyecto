package com.example.proyecto2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import com.example.proyecto2.databinding.ActivityMainBinding
import android.view.View.OnClickListener

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonGenerateFibonacci.setOnClickListener(this)
    }



    private fun sequenceFibonacci(){
        val fibonacci = Fibonacci()
        val listFibonacciString = fibonacci.sequenceFibonacci(binding.editTextNumber.text.toString().toInt()).joinToString()


            binding.editTextFibonacciList.setText(listFibonacciString)

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
        R.id.buttonGenerateFibonacci -> sequenceFibonacci()
        }

    }
}