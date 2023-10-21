package com.isfa.home.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.isfa.home.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

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