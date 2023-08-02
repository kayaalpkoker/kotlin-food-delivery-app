package com.example.fooddeliveryapp.data.repo

import com.example.fooddeliveryapp.data.datasource.YemeklerDataSource
import com.example.fooddeliveryapp.data.entity.Yemekler

class YemeklerRepository(var yds: YemeklerDataSource) {

    suspend fun tumYemekleriGetir(): List<Yemekler> = yds.tumYemekleriGetir()
}