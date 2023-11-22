package com.isfa.home.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.isfa.home.data.entity.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepository {

    // assume the [news] is a database
    private val news: SnapshotStateList<News> = mutableStateListOf(
        News("Tarian Budaya Makassar", "Sosial Budaya"),
        News("Pertandingan MotoGP Mandalika", "Olahraga"),
        News("Rendang makanan terbaik Indonesia", "Info")
    )

    fun newsList() = news.asReversed()

    fun addNews(title: String, category: String) {
        news.add(News(title, category))
    }
}