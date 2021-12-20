package com.example.grab.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grab.Adapter.AdapterCoin
import com.example.grab.Api.ApiCoinService
import com.example.grab.Model.CoinModel
import com.example.grab.Model.CoinsItem
import com.example.grab.Model.FoodMenuPage
import com.example.grab.R
import retrofit2.Response

class CoinApi : AppCompatActivity() {
    private lateinit var newRecylerviewCoin: RecyclerView
    private lateinit var newArryListCoin: ArrayList<CoinsItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_api)
        val apiService: ApiCoinService =ApiCoinService()
        newArryListCoin= arrayListOf()
        val call=apiService.getData()
        call.enqueue(object :retrofit2.Callback<CoinModel>{
            override fun onResponse(
                call: retrofit2.Call<CoinModel>,
                response: Response<CoinModel>) {
                if (response.isSuccessful){
                    var data=response.body()
                    for (i in 0 until (data?.data?.coins!!.size)){
                        val new=data?.data?.coins!![i]
                        newArryListCoin.add(new!!)
                    }
                    newRecylerviewCoin=findViewById(R.id.reecycleCoin)
                    newRecylerviewCoin.adapter=AdapterCoin(newArryListCoin)
                    newRecylerviewCoin.layoutManager=LinearLayoutManager(this@CoinApi,
                        LinearLayoutManager.VERTICAL,false)
                    newRecylerviewCoin.setHasFixedSize(true)
                }
            }

            override fun onFailure(call: retrofit2.Call<CoinModel>, t: Throwable) {
               Log.e("Api",t.message.toString())
            }

        })
    }
}