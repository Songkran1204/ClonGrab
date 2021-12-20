package com.example.grab.Activity

import com.example.grab.Model.FoodModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.grab.Adapter.AdapterShowListFood
import com.example.grab.DB.DBHelper
import com.example.grab.R

class AddDataSQLite : AppCompatActivity() {
    lateinit var food_name:EditText
    lateinit var food_price:EditText
    lateinit var food_description:EditText
    lateinit var bttSubmit:Button
    lateinit var dbHelper: DBHelper
    lateinit var name:String
    lateinit private var newRecylerviewShowFood: RecyclerView
//    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data_sqlite)

        initView()
        dbHelper= DBHelper(this)
         getFood()

        var data:ArrayList<FoodModel>
        bttSubmit.setOnClickListener {
            AddFood()
            getFood()
        }
    }

    private fun initView() {
        food_name=findViewById(R.id.etFoodName)
        food_price=findViewById(R.id.etPrice)
        food_description=findViewById(R.id.etDescription)
        bttSubmit=findViewById(R.id.bttSubmitAddFood)

    }

    private fun getFood(){
        newRecylerviewShowFood=findViewById(R.id.recycleFood)
        val foodList=dbHelper.getAllData()
        newRecylerviewShowFood.adapter= AdapterShowListFood(foodList)
        newRecylerviewShowFood.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }
    private fun AddFood(){
        val name=food_name.text.toString()
        val price=food_price.text.toString()
        val description=food_description.text.toString()

        if (name.isEmpty()||price.isEmpty()||description.isEmpty()){
            Toast.makeText(this,"Enter field",Toast.LENGTH_SHORT).show()
        }else{
            val food= FoodModel(0,name,price.toInt(),description)
            val status=dbHelper.insertFood(food)

            if(status>-1){
                Toast.makeText(this,"Food Add",Toast.LENGTH_SHORT).show()
                clearEditText()
            }else{
                Toast.makeText(this,"Not SAve",Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearEditText() {
        food_price.setText("")
        food_name.setText("")
        food_description.setText("")
    }
}