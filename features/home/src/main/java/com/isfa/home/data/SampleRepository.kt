package com.isfa.home.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SampleRepository {

    fun getSampleList(): Flow<List<String>> {
        return flow {
            val result = listOf(
                "Ini sample pertama",
                "ini ujicoba",
                "ini data dari BPS",
            )

            emit(result)
        }
    }
}