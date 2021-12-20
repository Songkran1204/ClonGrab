package com.example.grab.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grab.Adapter.AdapterListMenu
import com.example.grab.Model.FoodMenuPage
import com.example.grab.R
import org.json.JSONObject
import java.io.InputStream

class ListMenu : AppCompatActivity() {
    private lateinit var newArryListFoodMenuPage2: ArrayList<FoodMenuPage>
    private lateinit var newRecylerviewPage2: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_menu)
//        Log.e("JsonData", "PAGE2")
        readJsonFile()
    }

    fun readJsonFile(): String? {
        var json:String?=null
        newArryListFoodMenuPage2 = arrayListOf<FoodMenuPage>()
        try {
            val inputStram:InputStream=assets.open("json_data.json")
            json=inputStram.bufferedReader().use { it.readText() }
            var jsonObject=JSONObject(json)
            val jsonArray = jsonObject.optJSONArray("data")
            for (i in 0 until jsonArray.length()){
                val jsonObject = jsonArray.getJSONObject(i)
                val price = jsonObject.optString("price").toInt()
                val name = jsonObject.optString("name")
                val image = jsonObject.optString("image")
                val description = jsonObject.optString("description")

                newRecylerviewPage2=findViewById(R.id.recyclerMenuPage2)
                val news= FoodMenuPage(image, name, price, description)
                newArryListFoodMenuPage2.add(news)

            }
//            Log.e("JsonData description", newArryListPage2.toString())
            newRecylerviewPage2.adapter= AdapterListMenu(newArryListFoodMenuPage2)
            newRecylerviewPage2.layoutManager= LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false)
            newRecylerviewPage2.setHasFixedSize(true)

        }catch (ex:Exception){
//            ex.printStackTrace()
            Log.e("JsonData", ex.toString())
            return null
        }
        return json
    }
}