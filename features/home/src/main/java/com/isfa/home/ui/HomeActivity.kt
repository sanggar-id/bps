package com.isfa.home.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.isfa.home.R
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(
            this,
            MainViewModel.Companion.Factory()
        )[MainViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        lifecycleScope.launch {
            viewModel.newsList.collect {
                it.forEach { title ->
                    println(">> ${title}")
                }
            }
        }

        lifecycleScope.launch {
            viewModel.categories.collect {
                it.forEach { category ->
                    println("categories >> ${category}")
                }
            }
        }
    }
}