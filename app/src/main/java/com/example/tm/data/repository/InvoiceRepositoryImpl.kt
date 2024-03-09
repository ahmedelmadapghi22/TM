package com.example.tm.data.repository

import com.example.tm.data.local.room.doa.GoodsDoa
import com.example.tm.data.local.room.doa.MaterialsDoa
import com.example.tm.domain.mapper.GoodsMapper
import com.example.tm.domain.mapper.MaterialMapper
import com.example.tm.domain.model.Goods
import com.example.tm.domain.model.Material
import com.example.tm.domain.repository.GoodsRepository
import com.example.tm.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GoodsRepositoryImpl @Inject constructor(
    private val goodsDoa: GoodsDoa,
    private val goodsMapper: GoodsMapper
) :
    GoodsRepository {
    override suspend fun insertGoods(goods: Goods): Long {
        return goodsDoa.insertGoods(goodsMapper.fromModel(goods))
    }

    override fun getAllGoods(): Flow<List<Goods>> {
       return goodsDoa.getAllGoods().map {
           it.map {
               goodsMapper.fromEntity(it)
           }
       }
    }

    override fun searchByDate(searchDate: String): Flow<List<Goods>> {
        return goodsDoa.searchByDate(searchDate).map {
            it.map {
                goodsMapper.fromEntity(it)
            }
        }
    }

}