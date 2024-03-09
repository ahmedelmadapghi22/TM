package com.example.tm.data.local.room.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tm.data.local.room.entity.GoodsEntity
import com.example.tm.data.local.room.entity.MaterialEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GoodsDoa {
    @Insert
    suspend fun insertGoods(goodsEntity: GoodsEntity): Long
    @Query("SELECT * FROM goods")
     fun getAllGoods(): Flow<List<GoodsEntity>>
    @Query("SELECT * FROM goods WHERE date LIKE '%' || :dateQueryText|| '%'")
    fun searchByDate(dateQueryText:String): Flow<List<GoodsEntity>>

}