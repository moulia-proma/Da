package com.liilab.android_basics.presentation.screen.MVVM.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.material.button.MaterialButton
import com.liilab.android_basics.R
import com.liilab.android_basics.presentation.screen.MVVM.ViewModel.CalculatorViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalculatorActivity : AppCompatActivity() {

    private val viewModel: CalculatorViewModel by viewModels()
    private lateinit var num1: EditText
    private lateinit var num2: EditText
    private lateinit var result: TextView
    private lateinit var sum: MaterialButton
    private lateinit var sub: MaterialButton
    private lateinit var mul: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        sum = findViewById(R.id.btn_sum)
        mul = findViewById(R.id.btn_mul)
        sub = findViewById((R.id.btn_sub))
        num1 = findViewById(R.id.edit_text_num1)
        num2 = findViewById(R.id.edit_text_num2)
        result = findViewById(R.id.text_result)



        sum.setOnClickListener {
            val n1 = num1.text.toString().toIntOrNull() ?: 0
            val n2 = num2.text.toString().toIntOrNull() ?: 0
            viewModel.calculator(n1, n2, "add")
        }


        sub.setOnClickListener() {
            val n1 = num1.text.toString().toIntOrNull() ?: 0
            val n2 = num2.text.toString().toIntOrNull() ?: 0
            viewModel.calculator(n1, n2, "sub")
        }


        mul.setOnClickListener() {
            val n1 = num1.text.toString().toIntOrNull() ?: 0
            val n2 = num2.text.toString().toIntOrNull() ?: 0
            viewModel.calculator(n1, n2, "mul")
        }


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    Log.d("_xyz", "onCreate: value = $it")
                    if (it.type == "add") {
                        result.text = "Sum is = ${it.sum}"
                    } else if (it.type == "sub") {
                        result.text = "sub = ${it.sub}"

                    } else if (it.type == "mul") {
                        result.text = "sub = ${it.mul}"
                    }

                }
            }
        }


    }
}


