package com.example.tm.domain.usecases.materials

import android.util.Log
import com.example.tm.domain.repository.FilterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetFilterMethodUseCase @Inject constructor(private val filterRepository: FilterRepository) {
    suspend operator fun invoke(): Flow<Int> {
        return flow {

            filterRepository.getFilterIndex().collect {
                emit(it)
            }

        }

    }

}