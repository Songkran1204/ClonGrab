package com.example.grab.Api

import retrofit2.Call
import com.example.grab.Model.ApiModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

val BASE_URL="http://10.88.88.77:3010/th/v1/master/informations/"
interface ApiService {
    @GET("prefixes")
    fun getData(): Call<ApiModel>

    companion object{
        operator fun invoke():ApiService{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}