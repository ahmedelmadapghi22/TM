package com.example.tm.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tm.data.local.room.DatabaseConstants

@Entity(tableName = DatabaseConstants.MATERIAL_TABLE_NAME)
data class MaterialEntity (
    @ColumnInfo(name = DatabaseConstants.MATERIAL_ID_COLUMN)
    @PrimaryKey(autoGenerate = true)
     var id: Int = 0
        ,
    @ColumnInfo(name = DatabaseConstants.MATERIAL_NAME_COLUMN)
     var name: String = ""
,
    @ColumnInfo(name = DatabaseConstants.MATERIAL_COMPANY_NAME_COLUMN)
     var company: String = ""
,
    @ColumnInfo(name = DatabaseConstants.MATERIAL_KILOGRAM_COLUMN)
     var kilogram: String = ""
)