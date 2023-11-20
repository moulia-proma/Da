package com.liilab.android_basics.presentation.screen.MVVM.ViewModel

import androidx.lifecycle.ViewModel
import com.liilab.android_basics.presentation.screen.MVVM.Model.CalculateData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CalculatorViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(CalculateData(0,0,0,null))
    val uiState: StateFlow<CalculateData> = _uiState.asStateFlow()

    fun calculator(num1: Int, num2: Int, type: String) {
       val sum = num1+num2
        val mul = num1*num2
        val sub = num1-num2
        _uiState.value = CalculateData( sum, mul, sub, type)
    }


}