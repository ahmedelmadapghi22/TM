package com.example.tm.domain.mapper

import com.example.tm.data.local.room.entity.MaterialEntity
import com.example.tm.domain.model.Material
import com.example.tm.util.Mapper
import javax.inject.Inject

class MaterialMapper @Inject constructor() : Mapper<Material, MaterialEntity> {
    override fun fromEntity(entity: MaterialEntity): Material {
        return Material(
            id = entity.id,
            name = entity.name,
            company = entity.company,
            kilogram = entity.kilogram
        )
    }

    override fun fromModel(model: Material): MaterialEntity {
        return MaterialEntity(name = model.name, company = model.company, kilogram = model.kilogram)
    }

}