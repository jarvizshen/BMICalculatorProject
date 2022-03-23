package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.bmicalculator.databinding.ActivityMainBinding
import java.text.DecimalFormat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.calculator -> {
                val intent = Intent(this, CalculatorActivity::class.java)
                startActivity(intent)
            }
            R.id.clear -> {
                binding.weight.setText("")
                binding.height.setText("")
                binding.result.text = ""
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            if (!binding.male.isChecked && !binding.female.isChecked) {
                Toast.makeText(this, "请选择性别", Toast.LENGTH_SHORT).show()
            } else {
                val height: Double = binding.height.text.toString().toDouble()
                val weight: Double = binding.weight.text.toString().toDouble()
                val bmi: Double = weight / (height.pow(2))
                val df = DecimalFormat("#.00")
                judgeText(df.format(bmi).toDouble())
            }
        }
        binding.male.setOnClickListener {
            if (binding.male.isChecked) {
                binding.female.isChecked = false
            }
        }
        binding.female.setOnClickListener {
            if (binding.female.isChecked) {
                binding.male.isChecked = false
            }
        }
    }

    private fun judgeText(bmi: Double) {
        if (!binding.male.isChecked) {
            when {
                bmi < 19 -> binding.result.text = "BMI：$bmi             诊断：体重过轻"
                bmi >= 19 && bmi < 24 -> binding.result.text = "BMI：$bmi             诊断：体重正常"
                bmi >= 24 && bmi < 26 -> binding.result.text = "BMI：$bmi             诊断：体重超重"
                bmi >= 26 && bmi < 29 -> binding.result.text = "BMI：$bmi             诊断：轻度肥胖"
                bmi >= 29 && bmi < 34 -> binding.result.text = "BMI：$bmi             诊断：中度肥胖"
                bmi >= 34 -> binding.result.text = "BMI：$bmi             诊断：重度肥胖"
            }
        } else {
            when {
                bmi < 20 -> binding.result.text = "BMI：$bmi             诊断：体重过轻"
                bmi >= 20 && bmi < 25 -> binding.result.text = "BMI：$bmi             诊断：体重正常"
                bmi >= 25 && bmi < 27 -> binding.result.text = "BMI：$bmi             诊断：体重超重"
                bmi >= 27 && bmi < 30 -> binding.result.text = "BMI：$bmi             诊断：轻度肥胖"
                bmi >= 30 && bmi < 35 -> binding.result.text = "BMI：$bmi             诊断：中度肥胖"
                bmi >= 35 -> binding.result.text = "BMI：$bmi             诊断：重度肥胖"
            }
        }
    }
}