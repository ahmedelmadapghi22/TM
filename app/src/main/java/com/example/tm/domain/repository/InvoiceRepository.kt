package com.example.tm.domain.repository

import com.example.tm.domain.model.Goods
import kotlinx.coroutines.flow.Flow

interface GoodsRepository {
    suspend fun insertGoods(goods: Goods): Long
    fun getAllGoods(): Flow<List<Goods>>

    fun searchByDate(searchDate: String): Flow<List<Goods>>

}