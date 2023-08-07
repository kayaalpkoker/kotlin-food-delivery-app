package com.example.fooddeliveryapp.data.datasource

import com.example.fooddeliveryapp.data.entity.Yemekler
import com.example.fooddeliveryapp.retrofit.YemeklerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class YemeklerDataSource(var ydao: YemeklerDao) {

    suspend fun tumYemekleriGetir(): List<Yemekler> =
        withContext(Dispatchers.IO) {
            return@withContext ydao.tumYemekleriGetir().yemekler
        }

}