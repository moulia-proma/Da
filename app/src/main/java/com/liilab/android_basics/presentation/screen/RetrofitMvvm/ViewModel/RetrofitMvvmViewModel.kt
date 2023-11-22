package com.liilab.android_basics.presentation.screen.RetrofitMvvm.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liilab.android_basics.presentation.Repositary.RetrofitMvvmRepositary
import com.liilab.android_basics.presentation.screen.RetrofitMvvm.Model.UserInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call

class RetrofitMvvmViewModel : ViewModel() {
    val _uiState = MutableStateFlow<List<UserInfo>>(emptyList())
    val uiState: StateFlow<List<UserInfo>> = _uiState.asStateFlow()


    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val rep = RetrofitMvvmRepositary()
            val data = rep.getUser()
            _uiState.value = data
        }

    }

}