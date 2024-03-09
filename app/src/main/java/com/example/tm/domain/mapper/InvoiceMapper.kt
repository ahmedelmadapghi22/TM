package com.example.tm.domain.mapper

import com.example.tm.data.local.room.entity.GoodsEntity
import com.example.tm.domain.model.Goods
import com.example.tm.util.Mapper
import javax.inject.Inject

class GoodsMapper @Inject constructor() : Mapper<Goods, GoodsEntity> {
    override fun fromEntity(entity: GoodsEntity): Goods {
        return Goods(
            id = entity.id,
            materialID = entity.materialID,
            materialName = entity.materialName,
            price = entity.price,
            quantity = entity.quantity,
            date = entity.date
        )
    }

    override fun fromModel(model: Goods): GoodsEntity {
        return GoodsEntity(
            materialID = model.materialID,
            materialName = model.materialName,
            date = model.date,
            quantity = model.quantity,
            price = model.price
        )
    }

}