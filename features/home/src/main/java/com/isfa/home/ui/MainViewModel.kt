package com.isfa.home.ui

import androidx.lifecycle.ViewModel
import com.isfa.home.domain.GetNewsUseCase
import com.isfa.home.domain.SetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getNewsUseCase: GetNewsUseCase,
    private val setNewsUseCase: SetNewsUseCase
) : ViewModel() {

    val news = getNewsUseCase.execute()

    fun addNews(title: String, category: String) {
        setNewsUseCase.execute(
            title = title,
            category = category
        )
    }
}