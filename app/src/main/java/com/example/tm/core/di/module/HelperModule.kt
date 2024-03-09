package com.example.tm.core.di.module

import com.example.tm.data.local.room.doa.MaterialsDoa
import com.example.tm.data.repository.MaterialRepositoryImpl
import com.example.tm.domain.mapper.MaterialMapper
import com.example.tm.domain.repository.MaterialRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun provideMaterialsRepo(
        materialsDoa: MaterialsDoa,
        materialMapper: MaterialMapper
    ): MaterialRepository {
        return MaterialRepositoryImpl(materialsDoa, materialMapper)
    }


}