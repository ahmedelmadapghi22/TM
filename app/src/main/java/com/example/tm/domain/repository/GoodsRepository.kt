package com.example.tm.domain.repository

import com.example.tm.domain.model.Material
import kotlinx.coroutines.flow.Flow

interface MaterialRepository {
    suspend fun insertMaterial(material: Material): Long
    fun getAllMaterials():Flow< List<Material>>

    fun searchByMaterialName(searchWord:String):Flow<List<Material>>
    fun searchByCompanyName(searchWord:String):Flow<List<Material>>
    fun searchByMeters(searchWord:String):Flow<List<Material>>

}