package com.liilab.android_basics.presentation.screen.RetrofitMvvm.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.liilab.android_basics.R
import com.liilab.android_basics.presentation.screen.RetrofitMvvm.ViewModel.RetrofitMvvmViewModel
import com.liilab.android_basics.presentation.screen.RetrofitTask.RetroTaskAdapter
import kotlinx.coroutines.launch

class RetrofitMvvmActivity : AppCompatActivity() {
    private lateinit var  recyclerViewtMvvm : RecyclerView
    private val viewModel: RetrofitMvvmViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_campaign)
        recyclerViewtMvvm = findViewById(R.id.recycler_view_campaigns)


        viewModel.getUsers()



        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect{
                    val retrofitAdapt = RetroMvvmAdapter(this@RetrofitMvvmActivity, it)
                   recyclerViewtMvvm.adapter= retrofitAdapt


            }

        }

            }


    }
}