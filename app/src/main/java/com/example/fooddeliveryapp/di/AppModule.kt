package com.example.fooddeliveryapp.di

import com.example.fooddeliveryapp.data.datasource.SepetYemeklerDataSource
import com.example.fooddeliveryapp.data.datasource.YemeklerDataSource
import com.example.fooddeliveryapp.data.repo.SepetYemeklerRepository
import com.example.fooddeliveryapp.data.repo.YemeklerRepository
import com.example.fooddeliveryapp.retrofit.ApiUtils
import com.example.fooddeliveryapp.retrofit.SepetYemeklerDao
import com.example.fooddeliveryapp.retrofit.YemeklerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideYemeklerRepository(yds: YemeklerDataSource) : YemeklerRepository {
        return YemeklerRepository(yds)
    }

    @Provides
    @Singleton
    fun provideYemeklerDataSource(ydao: YemeklerDao) : YemeklerDataSource {
        return YemeklerDataSource(ydao)
    }

    @Provides
    @Singleton
    fun provideYemeklerDao() : YemeklerDao {
        return ApiUtils.getYemeklerDao()
    }

    // SepetYemekler
    @Provides
    @Singleton
    fun provideSepetYemeklerRepository(syds: SepetYemeklerDataSource) : SepetYemeklerRepository {
        return SepetYemeklerRepository(syds)
    }

    @Provides
    @Singleton
    fun provideSepetYemeklerDataSource(sydao: SepetYemeklerDao) : SepetYemeklerDataSource {
        return SepetYemeklerDataSource(sydao)
    }

    @Provides
    @Singleton
    fun provideSepetYemeklerDao() : SepetYemeklerDao {
        return ApiUtils.getSepetYemeklerDao()
    }
}