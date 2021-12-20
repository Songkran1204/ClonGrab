package com.example.grab.DB

import com.example.grab.Model.FoodModel
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.lang.Exception

class DBHelper(context: Context?,) : SQLiteOpenHelper(context, DB_name , null, 1) {
    companion object{
        private const val DB_name="GrabFood.db"
        private const val table_name="food_table"
        private const val col_id="food_id"
        private const val col_name="food_name"
        private const val col_price="food_price"
        private const val col_description="food_description"
        private var id:Int = 0
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable=("CREATE TABLE "+ table_name +" ( "
                + col_id +" INT PRIMARY KEY, "+ col_name +" TEXT, "
                + col_price +" INT, "+ col_description +" TEXT )"
                )
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $table_name")
    }
    fun insertFood(food: FoodModel):Long{
        var id=getIDLast()+1

        val db =this.writableDatabase
        val contentValues=ContentValues()
        contentValues.put(col_name,food.food_name)
        contentValues.put(col_id,id)
        contentValues.put(col_price,food.food_price)
        contentValues.put(col_description,food.food_description)
        val success=db.insert(table_name,null,contentValues)
        db.close()
        return success
    }
    @SuppressLint("Range")
    fun getAllData():ArrayList<FoodModel>{
//        Log.e("CURSOR ","9")
        val foodList:ArrayList<FoodModel>
        val selectQuery="SELECT * FROM $table_name"
        val db=this.readableDatabase
        val cursor:Cursor?
        foodList= arrayListOf<FoodModel>()
        try {
            cursor=db.rawQuery(selectQuery,null)
        }catch (e:Exception){
            Log.e("CURSOR ","EXCEPTION")
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var name:String
        var price:Int
        var idfood:Int
        var description:String

        if (cursor.moveToFirst()){
            do {
                idfood=cursor.getInt(cursor.getColumnIndex(col_id))
                name=cursor.getString(cursor.getColumnIndex(col_name))
                Log.e("DO WHILE",name)
                price=cursor.getInt(cursor.getColumnIndex(col_price))
                description=cursor.getString(cursor.getColumnIndex(col_description))
                val food= FoodModel(idfood,name,price,description)
                foodList.add(food)
            }while (cursor.moveToNext())
        }
        return foodList
    }

    @SuppressLint("Range")
    fun getIDLast():Int{
        val foodList:ArrayList<FoodModel>
        val selectQuery="SELECT * FROM $table_name ORDER BY $col_id DESC LIMIT 1"
        val db=this.readableDatabase
        val cursor:Cursor?
        try {
            cursor=db.rawQuery(selectQuery,null)
        }catch (e:Exception){

            Log.e("CURSOR ","EXCEPTION")
            e.printStackTrace()
            db.execSQL(selectQuery)
            return 0
        }
        if(cursor.moveToFirst())
            id  =  cursor.getInt( cursor.getColumnIndex(col_id) );
        cursor.close();
        return id

    }


}