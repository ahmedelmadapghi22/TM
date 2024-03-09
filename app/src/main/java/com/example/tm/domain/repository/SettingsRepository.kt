package com.example.tm.domain.repository

import kotlinx.coroutines.flow.Flow

interface FilterRepository {
    suspend fun saveFilterIndex(index: Int)

    fun getFilterIndex(): Flow<Int>


}