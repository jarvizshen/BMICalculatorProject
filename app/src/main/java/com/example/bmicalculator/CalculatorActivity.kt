package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bmicalculator.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding = ActivityCalculatorBinding.inflate(layoutInflater)
        binding.data = CalculatorViewModel()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}