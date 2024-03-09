package com.example.tm.data.local.room.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tm.data.local.room.entity.MaterialEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MaterialsDoa {
    @Insert
    suspend fun insertMaterial(materialEntity: MaterialEntity): Long
    @Query("SELECT * FROM materials")
     fun getAllMaterials(): Flow<List<MaterialEntity>>

    @Query("SELECT * FROM materials WHERE name LIKE '%' || :queryText|| '%'")
    fun searchByMaterialName(queryText:String): Flow<List<MaterialEntity>>
    @Query("SELECT * FROM materials WHERE company LIKE '%' || :queryText|| '%'")
    fun searchByCompanyName(queryText:String): Flow<List<MaterialEntity>>
    @Query("SELECT * FROM materials WHERE one_kilo LIKE '%' || :queryText|| '%'")
    fun searchByMeters(queryText:String): Flow<List<MaterialEntity>>
}