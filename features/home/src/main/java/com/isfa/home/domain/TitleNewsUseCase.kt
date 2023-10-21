package com.isfa.home.domain

import com.isfa.home.data.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TitleNewsUseCase constructor(
    private val newsRepository: NewsRepository
) {

    fun result(): Flow<List<String>> {
        return newsRepository
            .newsList()
            .map { news ->
                news.map { it.title }
            }
    }
}