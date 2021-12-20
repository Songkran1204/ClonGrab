package com.example.grab.Api

//import Coinssss
import com.example.grab.Activity.CoinApi
import com.example.grab.Model.CoinModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import javax.security.auth.callback.Callback
val Base_url="https://api.coinranking.com/v1/public/"
interface ApiCoinService {
    @GET("coins")
    fun getData(): Call<CoinModel>
    companion object{
        operator fun invoke(): ApiCoinService {
            return Retrofit.Builder()
                .baseUrl(Base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiCoinService::class.java)
        }
    }
}