package com.isfa.home.domain

import com.isfa.home.data.NewsRepository
import javax.inject.Inject

class SetNewsUseCase @Inject constructor(
    private val newsRepository: NewsRepository
) {

    fun execute(title: String, category: String) {
        newsRepository.addNews(title, category)
    }
}