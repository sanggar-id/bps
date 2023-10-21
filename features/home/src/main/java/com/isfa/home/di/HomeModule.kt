package com.isfa.home.di

import com.isfa.home.data.NewsRepository
import com.isfa.home.domain.CategoryNewsUseCase
import com.isfa.home.domain.TitleNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HomeModule {

    @Provides
    @Singleton
    fun provideNewsRepository(): NewsRepository {
        return NewsRepository()
    }

    @Provides
    @Singleton
    fun provideCategoryNewsUseCase(newsRepository: NewsRepository): CategoryNewsUseCase {
        return CategoryNewsUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideTitleNewsUseCase(newsRepository: NewsRepository): TitleNewsUseCase {
        return TitleNewsUseCase(newsRepository)
    }
}