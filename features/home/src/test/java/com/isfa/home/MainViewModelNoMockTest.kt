package com.isfa.home

import com.isfa.home.data.NewsRepository
import com.isfa.home.domain.GetNewsUseCase
import com.isfa.home.domain.SetNewsUseCase
import com.isfa.home.ui.MainViewModel
import org.junit.Assert.assertTrue
import org.junit.Test

// Not Recommended, please use a mock version.
class MainViewModelNoMockTest {

    @Test
    fun test_showNewsList() {
        // Given
        val repository = NewsRepository()

        val getNewsUseCase = GetNewsUseCase(repository)
        val setNewsUseCase = SetNewsUseCase(repository)

        val viewModel = MainViewModel(
            getNewsUseCase,
            setNewsUseCase
        )

        // Then
        assertTrue(viewModel.news.isNotEmpty())
    }
}