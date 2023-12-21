package com.isfa.home

import com.isfa.home.data.entity.News
import com.isfa.home.domain.GetNewsUseCase
import com.isfa.home.domain.SetNewsUseCase
import com.isfa.home.ui.MainViewModel
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert
import org.junit.Test

class MainViewModelTest {

    private val getNewsUseCase = mockk<GetNewsUseCase>()
    private val setNewsUseCase = mockk<SetNewsUseCase>()

    @Test
    fun test_showNewsList() {
        // Given
        val fakeNewsList = listOf(
            News("this is a sample news title", "sample")
        )

        every { getNewsUseCase.execute() } returns fakeNewsList

        val viewModel = MainViewModel(
            getNewsUseCase,
            setNewsUseCase
        )

        // Then
        Assert.assertTrue(viewModel.news.isNotEmpty())
        Assert.assertTrue(viewModel.news == fakeNewsList)
    }

    @Test
    fun test_showEmptyNewsList() {
        // Given
        every { getNewsUseCase.execute() } returns listOf()

        val viewModel = MainViewModel(
            getNewsUseCase,
            setNewsUseCase
        )

        // Then
        Assert.assertTrue(viewModel.news.isEmpty())
    }

    @Test
    fun test_shouldAddNewsExecute() {
        // Given
        every { setNewsUseCase.execute("", "") } just Runs
        every { getNewsUseCase.execute() } returns listOf()

        val viewModel = MainViewModel(
            getNewsUseCase,
            setNewsUseCase
        )

        // Then
        viewModel.addNews("", "")

        verify(exactly = 1) { setNewsUseCase.execute("", "") }
    }
}