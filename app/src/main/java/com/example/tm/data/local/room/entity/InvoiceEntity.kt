package com.example.tm.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tm.data.local.room.DatabaseConstants

@Entity(tableName = DatabaseConstants.GOODS_TABLE_NAME)
data class GoodsEntity(
    @ColumnInfo(name = DatabaseConstants.GOODS_ID_COLUMN)
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    @ColumnInfo(name = DatabaseConstants.GOODS_MATERIAL_NAME_COLUMN)
    var materialName: String = "",
    @ColumnInfo(name = DatabaseConstants.GOODS_MATERIAL_ID_COLUMN)
    var materialID: Int = 0,
    @ColumnInfo(name = DatabaseConstants.GOODS_DATE_COLUMN)
    var date: String = "",
    @ColumnInfo(name = DatabaseConstants.GOODS_QUANTITY_COLUMN)
    var quantity: String = "",
    @ColumnInfo(name = DatabaseConstants.GOODS_PRICE_COLUMN)
    var price: String = ""
)