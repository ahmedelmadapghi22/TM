package com.example.tm.data.repository

import com.example.tm.data.local.room.doa.MaterialsDoa
import com.example.tm.domain.mapper.MaterialMapper
import com.example.tm.domain.model.Material
import com.example.tm.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MaterialRepositoryImpl @Inject constructor(
    private val materialsDoa: MaterialsDoa,
    private val materialMapper: MaterialMapper
) :
    MaterialRepository {
    override suspend fun insertMaterial(material: Material): Long {
        return materialsDoa.insertMaterial(materialMapper.fromModel(material))
    }

    override fun getAllMaterials(): Flow<List<Material>> {
        return materialsDoa.getAllMaterials().map {
            it.map {
                materialMapper.fromEntity(it)
            }
        }
    }

    override fun searchByMaterialName(searchWord: String): Flow<List<Material>> {
        return materialsDoa.searchByMaterialName(searchWord).map {
            it.map {
                materialMapper.fromEntity(it)
            }
        }
    }

    override fun searchByCompanyName(searchWord: String): Flow<List<Material>> {
        return materialsDoa.searchByCompanyName(searchWord).map {
            it.map {
                materialMapper.fromEntity(it)
            }
        }
    }

    override fun searchByMeters(searchWord: String): Flow<List<Material>> {
        return materialsDoa.searchByMeters(searchWord).map {
            it.map {
                materialMapper.fromEntity(it)
            }
        }
    }


}