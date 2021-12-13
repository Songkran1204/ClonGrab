package com.example.grab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var newRecylerview: RecyclerView
    private lateinit var newRecylerview1: RecyclerView
    private lateinit var newArryList: ArrayList<Menus>
    private lateinit var newArryList1: ArrayList<Menus>
    lateinit var foodname:Array<String>
    lateinit var price:Array<String>
    lateinit var imageId:Array<Int>

    lateinit var foodnameForYou:Array<String>
    lateinit var priceForYou:Array<String>
    lateinit var imageIdForYou:Array<Int>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        foodname= arrayOf(
            "กระเพรา",
            "ไข่ดาว",
            "ข้าวผัด",
            "คะน้า",
            "EMM"
        )
        imageId= arrayOf(
            R.drawable.hamburger,
            R.drawable.diet,
            R.drawable.delivery,
            R.drawable.market,
            R.drawable.hamburger,
        )
        price= arrayOf(
            "฿15",
            "฿16",
            "฿88",
            "฿20",
            "฿200",
        )

        foodnameForYou= arrayOf(
            "AAA",
            "BBB",
            "CCC",
            "DDD",
        )
        imageIdForYou= arrayOf(
            R.drawable.hamburger,
            R.drawable.diet,
            R.drawable.banner,
            R.drawable.card,
        )
        priceForYou= arrayOf(
            "฿15",
            "฿16",
            "฿88",
            "฿20",
        )

        newRecylerview=findViewById(R.id.recyclerMenu)
        newRecylerview.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        newRecylerview.setHasFixedSize(true)
//

        newRecylerview1=findViewById(R.id.recyclerMenuForYou)
        newRecylerview1.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        newRecylerview1.setHasFixedSize(true)

        newArryList= arrayListOf<Menus>()
        newArryList1= arrayListOf<Menus>()
        getUserData()
    }
    private fun getUserData(){
        for (i in foodname.indices){
            val news=Menus(imageId[i],foodname[i], price[i])
            newArryList.add(news)

        }

        for (i in foodnameForYou.indices){
            val news=Menus(imageIdForYou[i],foodnameForYou[i], priceForYou[i])
            newArryList1.add(news)

        }
        newRecylerview.adapter= Adapter(newArryList)
        newRecylerview1.adapter= Adapter(newArryList1)
    }
}