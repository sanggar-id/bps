package com.isfa.home.data

import com.isfa.home.data.entity.News
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepository {

    fun newsList(): Flow<List<News>> {
        return flow {
            val result = listOf(
                News("Tarian Budaya Makassar", "Sosial Budaya"),
                News("Pertandingan MotoGP Mandalika", "Olahraga"),
                News("Rendang makanan terbaik Indonesia", "Info"),
            )

            emit(result)
        }
    }
}