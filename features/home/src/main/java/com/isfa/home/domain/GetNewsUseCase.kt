package com.isfa.home.domain

import com.isfa.home.data.NewsRepository
import com.isfa.home.data.entity.News
import javax.inject.Inject

class GetNewsUseCase @Inject constructor(
    private val repository: NewsRepository
) {

    fun execute(): List<News> {
        return repository.newsList()
    }
}