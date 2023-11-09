package com.isfa.home.ui

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.isfa.home.ui.component.HeaderView
import com.isfa.home.ui.component.NewsCard

@Composable
fun HomeScreen(viewModel: MainViewModel = viewModel()) {
    val news by viewModel.news.collectAsState(initial = emptyList())

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(24.dp)
    ) {
        item {
            HeaderView(
                time = "Malam",
                name = "BPS Beritaku!"
            )
        }

        item {
            Spacer(modifier = Modifier.padding(top = 16.dp))
        }

        items(news) {
            NewsCard(
                title = it.title,
                category = it.category
            ) {
                Log.d("BPS", it.title)
            }
        }
    }
}

@Composable
@Preview(
    showBackground = true,
    showSystemUi = true,
    backgroundColor = 0xFFFFFFFF,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
fun HomeScreenPreview() {
    HomeScreen()
}