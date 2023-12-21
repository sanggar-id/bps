package com.isfa.home

import com.isfa.home.domain.GetNewsUseCase
import com.isfa.home.domain.SetNewsUseCase
import com.isfa.home.ui.MainViewModel
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class MainViewModelTest {

    private val getNewsUseCase = mockk<GetNewsUseCase>()
    private val setNewsUseCase = mockk<SetNewsUseCase>()

    @Test
    fun test_showNewsList() {
        // Given
        val viewModel = MainViewModel(
            getNewsUseCase,
            setNewsUseCase
        )

        // Then
        Assert.assertTrue(viewModel.news.isNotEmpty())
    }
}