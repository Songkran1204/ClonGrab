package com.example.grab

import com.google.gson.annotations.SerializedName

data class Album(

    val uerId:Int,
    val id:Int,
    @SerializedName("title")
    val album_title:String

    )
