package com.isfa.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.isfa.home.data.SampleRepository
import kotlinx.coroutines.flow.Flow

class MainViewModel constructor(
    private val sampleRepository: SampleRepository
) : ViewModel() {

    val sampleList: Flow<List<String>> = sampleRepository.getSampleList()

    companion object {

        // We have to create the ViewModel factory,
        // to instance the SampleRepository and pass it into
        // the MainViewModel.
        class Factory : ViewModelProvider.Factory {

            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                val sampleRepository = SampleRepository()
                return MainViewModel(sampleRepository) as T
            }
        }
    }
}