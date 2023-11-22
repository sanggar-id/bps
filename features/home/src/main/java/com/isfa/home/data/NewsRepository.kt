package com.isfa.home.data

import com.isfa.home.data.entity.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepository {

    // assume the [news] is a database
    private val news = mutableListOf(
        News("Tarian Budaya Makassar", "Sosial Budaya"),
        News("Pertandingan MotoGP Mandalika", "Olahraga"),
        News("Rendang makanan terbaik Indonesia", "Info")
    )

    fun newsList(): Flow<List<News>> {
        return flow {
            emit(news)
        }
    }

    fun addNews(title: String, category: String) {
        news.add(News(title, category))
    }
}