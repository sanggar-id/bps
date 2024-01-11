package com.isfa.home.domain

import com.isfa.home.data.NewsRepository
import com.isfa.home.data.entity.News
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class GetNewsUseCaseTest {

    private val repository = mockk<NewsRepository>()

    @Test
    fun test_showNewsList() {
        // Given
        val fakeNewsList = mutableListOf(
            News("foo", "bar")
        )

        // When
        every { repository.newsList() } returns fakeNewsList

        // Then
        val useCase = GetNewsUseCase(repository)

        assert(useCase.execute().isNotEmpty())
        assert(useCase.execute() == fakeNewsList)
    }

    @Test
    fun test_errorGetNewsList() {
        // When
        every { repository.newsList() } throws Throwable("")

        // Then
        val useCase = GetNewsUseCase(repository)

        verify(exactly = 0) { useCase.execute() }
    }
}