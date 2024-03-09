package com.example.tm.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.tm.data.local.room.DatabaseConstants

@Entity(tableName = DatabaseConstants.MATERIAL_TABLE_NAME)
class Material {
    @ColumnInfo(name = DatabaseConstants.MATERIAL_ID_COLUMN)
    private var id: Int = 0

    @ColumnInfo(name = DatabaseConstants.MATERIAL_NAME_COLUMN)
    private var name: String = ""

    @ColumnInfo(name = DatabaseConstants.MATERIAL_COMPANY_NAME_COLUMN)
    private var company: String = ""

    @ColumnInfo(name = DatabaseConstants.MATERIAL_KILOGRAM_COLUMN)
    private var kilogram: String = ""

}