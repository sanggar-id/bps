package com.isfa.home.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            var hasBottomSheetShown by remember { mutableStateOf(false) }

            MaterialTheme {
                Scaffold(
                    floatingActionButton = {
                        ExtendedFloatingActionButton(
                            onClick = {
                                hasBottomSheetShown = true
                            }
                        ) {
                            Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
                        }
                    }
                ) { paddingValues ->
                    val news = viewModel.news.toMutableStateList()

                    HomeScreen(
                        newsList = news,
                        modifier = Modifier.padding(paddingValues)
                    )

                    if (hasBottomSheetShown) {
                        NewsBottomSheet(
                            onAddNewsClick = { title, category ->
                                viewModel.addNews(title, category)
                            },
                            onSheetDismiss = {
                                hasBottomSheetShown = false
                            }
                        )
                    }
                }
            }
        }
    }
}