package com.isfa.home.di

import com.isfa.home.data.NewsRepository
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
}