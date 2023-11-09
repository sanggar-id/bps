package com.isfa.home.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeScreen()
        }

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