package com.example.fooddeliveryapp.retrofit

import com.example.fooddeliveryapp.data.entity.YemeklerCevap
import retrofit2.http.GET

interface YemeklerDao {
    //http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    //http://kasimadalan.pe.hu/ -> base url
    //yemekler/tumYemekleriGetir.php -> api url

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun  yemekleriYukle() : YemeklerCevap


}