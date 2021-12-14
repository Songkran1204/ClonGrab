package com.example.grab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grab.R.id.*

class MainActivity : AppCompatActivity() {
    private lateinit var newRecylerview: RecyclerView
    private lateinit var newRecylerview1: RecyclerView
    private lateinit var newArryList: ArrayList<Menus>
    private lateinit var newArryList1: ArrayList<Menus>
    lateinit var foodname:Array<String>
    lateinit var price:Array<String>
    lateinit var description:Array<String>
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
        )
        imageId= arrayOf(
            R.drawable.hamburger,
            R.drawable.diet,
            R.drawable.delivery,
            R.drawable.market,
        )
        price= arrayOf(
            "฿15",
            "฿16",
            "฿88",
            "฿20",
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
        description= arrayOf(
            "AAAAAAAA",
            "BBBBBBBBB",
            "CCCCCCCC",
            "DDDDDDD",
        )
        newArryList= arrayListOf<Menus>()
        newArryList1= arrayListOf<Menus>()
        newRecylerview=findViewById(recyclerMenu)
        newRecylerview1=findViewById(recyclerMenuForYou)
        MenuRecyclerView(newRecylerview)
        MenuRecyclerView(newRecylerview1)
        getUserData()


        val bttFood:Button=findViewById(bttFood)
        bttFood.setOnClickListener {
                val Intent =Intent(this,ListMenu::class.java)
                startActivity(Intent)

        }
    }

    private fun MenuRecyclerView(recyclerView: RecyclerView){
        recyclerView.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.setHasFixedSize(true)

    }
    private fun getUserData(){
        for (i in foodname.indices){
            val news=Menus(imageId[i],foodname[i], price[i], description[i])
            newArryList.add(news)

        }

        for (i in foodnameForYou.indices){
            val news=Menus(imageIdForYou[i],foodnameForYou[i], priceForYou[i], description[i])
            newArryList1.add(news)

        }
        newRecylerview.adapter= Adapter(newArryList)
        newRecylerview1.adapter= Adapter(newArryList1)
    }
}