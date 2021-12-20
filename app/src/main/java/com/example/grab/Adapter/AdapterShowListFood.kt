package com.example.grab.Adapter

import com.example.grab.Model.FoodModel
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.grab.R

class AdapterShowListFood(private val newList:ArrayList<FoodModel>):
    RecyclerView.Adapter<AdapterShowListFood.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val foodname: TextView =itemView.findViewById(R.id.nameFood)
        val price: TextView =itemView.findViewById(R.id.priceFood)
        val description: TextView =itemView.findViewById(R.id.descriptionFood)
        val id: TextView =itemView.findViewById(R.id.idFood)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.recycle_show_food,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currenItem=newList[position]
        holder.foodname.text=currenItem.food_name
        holder.price.text= "฿ "+currenItem.food_price.toString()
        holder.description.text=currenItem.food_description
        holder.id.text=currenItem.food_id.toString()

    }

    override fun getItemCount(): Int {
        return newList.size
    }
}