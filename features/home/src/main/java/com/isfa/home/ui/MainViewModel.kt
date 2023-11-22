package com.isfa.home.ui

import androidx.lifecycle.ViewModel
import com.isfa.home.data.entity.News
import com.isfa.home.domain.CategoryNewsUseCase
import com.isfa.home.domain.SetNewsUseCase
import com.isfa.home.domain.TitleNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    titleNewsUseCase: TitleNewsUseCase,
    categoryNewsUseCase: CategoryNewsUseCase,
    private val setNewsUseCase: SetNewsUseCase
) : ViewModel() {

    val news: Flow<List<News>> = combine(
        titleNewsUseCase.result(),
        categoryNewsUseCase.result()
    ) { (titles, categories) ->
        titles.zip(categories) { title, category ->
            News(title, category)
        }
    }

    fun addNews(title: String, category: String) {
        setNewsUseCase.execute(
            title = title,
            category = category
        )
    }
}