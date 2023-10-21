package com.isfa.home.ui

import androidx.lifecycle.ViewModel
import com.isfa.home.domain.CategoryNewsUseCase
import com.isfa.home.domain.TitleNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val titleNewsUseCase: TitleNewsUseCase,
    private val categoryNewsUseCase: CategoryNewsUseCase
) : ViewModel() {

    val newsList: Flow<List<String>> = titleNewsUseCase.result()
    val categories: Flow<List<String>> = categoryNewsUseCase.result()
}