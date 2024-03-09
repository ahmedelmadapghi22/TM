package com.example.tm.domain.usecases.goods

import com.example.tm.domain.model.Goods
import com.example.tm.domain.model.Material
import com.example.tm.domain.repository.GoodsRepository
import com.example.tm.domain.repository.MaterialRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllGoodsUseCase @Inject constructor(private val goodsRepository: GoodsRepository) {

    operator fun invoke(): Flow<List<Goods>> {
        return goodsRepository.getAllGoods()
    }


}