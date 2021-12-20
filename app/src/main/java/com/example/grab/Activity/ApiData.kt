package com.example.grab.Activity

import android.app.DownloadManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.grab.Album
import com.example.grab.Api.ApiService
import com.example.grab.Model.ApiModel
import com.example.grab.R
import okhttp3.Call
import okhttp3.Request
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

class ApiData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ap_idata)
        val apiService:ApiService = ApiService()
        val call=apiService.getData()
        call.enqueue(object :Callback<ApiModel>{
            override fun onResponse(call: retrofit2.Call<ApiModel>, response: Response<ApiModel>) {
                Log.e("Api Message","Response")
                if (response.isSuccessful){
                    val data =response.body()
                    if (data != null) {
                        for (i in 0 until (data.result?.size!!)){
                            var id=data?.result!![i]?.id.toString()
                            var name=data?.result!![i]?.nameTh.toString()
                            Log.e("Id",id)
                            Log.e("Name",name)
                        }
//                            Log.e("data", data?.result!![0]?.nameTh.toString())
                    }
                }else{
                    Log.e("Api Message","Response Fail")
                }
            }
            override fun onFailure(call: retrofit2.Call<ApiModel>, t: Throwable) {
                Log.e("Api Message",t.message.toString())
            }

        })
    }
}