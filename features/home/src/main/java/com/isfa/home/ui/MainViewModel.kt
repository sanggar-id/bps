package com.isfa.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.isfa.home.data.NewsRepository
import com.isfa.home.domain.CategoryNewsUseCase
import com.isfa.home.domain.TitleNewsUseCase
import kotlinx.coroutines.flow.Flow

class MainViewModel constructor(
    private val titleNewsUseCase: TitleNewsUseCase,
    private val categoryNewsUseCase: CategoryNewsUseCase
) : ViewModel() {

    val newsList: Flow<List<String>> = titleNewsUseCase.result()
    val categories: Flow<List<String>> = categoryNewsUseCase.result()

    companion object {

        // We have to create the ViewModel factory,
        // to instance the SampleRepository and pass it into
        // the MainViewModel.
        class Factory : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val newsRepository = NewsRepository()
                val titleNewsUseCase = TitleNewsUseCase(newsRepository)
                val categoryNewsUseCase = CategoryNewsUseCase(newsRepository)

                return MainViewModel(titleNewsUseCase, categoryNewsUseCase) as T
            }
        }
    }
}