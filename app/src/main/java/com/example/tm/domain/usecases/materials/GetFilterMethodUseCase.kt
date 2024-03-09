package com.example.tm.domain.usecases.materials

import com.example.tm.domain.repository.FilterRepository
import javax.inject.Inject

class SaveFilterMethodUseCase @Inject constructor(private val filterRepository: FilterRepository) {
    suspend operator fun invoke(index:Int) {
        filterRepository.saveFilterIndex(index)
    }

}