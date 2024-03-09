package com.example.tm.domain.usecases

import com.example.tm.domain.model.Material
import com.example.tm.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMaterialsUseCase @Inject constructor(private val materialsRepository: MaterialRepository) {

    operator fun invoke(): Flow<List<Material>> {
        return materialsRepository.getAllMaterials()
    }


}