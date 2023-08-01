package com.example.fooddeliveryapp.retrofit

class ApiUtils {
    companion object {
        val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getKisilerDao() : YemeklerDao {
            return RetrofitClient.getClient(BASE_URL).create(YemeklerDao::class.java)
        }
    }
}