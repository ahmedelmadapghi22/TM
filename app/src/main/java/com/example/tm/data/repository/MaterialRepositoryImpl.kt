package com.example.tm.domain.repository

import com.example.tm.domain.model.Material

interface MaterialRepository {
    suspend fun insertMaterial(material: Material): Long
    fun getAllMaterials(): List<Material>
}