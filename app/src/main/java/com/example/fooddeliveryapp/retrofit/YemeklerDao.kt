package com.example.fooddeliveryapp.retrofit

import com.example.fooddeliveryapp.data.entity.YemeklerCevap
import retrofit2.http.GET

interface YemeklerDao {

    @GET("/yemekler/tumYemekleriGetir.php")
    suspend fun  tumYemekleriGetir() : YemeklerCevap

}