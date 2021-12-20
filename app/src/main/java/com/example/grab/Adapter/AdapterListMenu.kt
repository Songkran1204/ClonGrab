package com.example.grab.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.grab.Model.FoodMenuPage
import com.example.grab.R
import com.squareup.picasso.Picasso


class AdapterListMenu(private val newListFoodMenu:ArrayList<FoodMenuPage>):
    RecyclerView.Adapter<AdapterListMenu.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val foodname: TextView =itemView.findViewById(R.id.namefoods)
        val price: TextView =itemView.findViewById(R.id.prices)
        val description: TextView =itemView.findViewById(R.id.description)
        val image: ImageView =itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.recycle_food_menu_listmenu,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currenItem=newListFoodMenu[position]
        holder.foodname.text=currenItem.namefood
        holder.price.text= "฿ "+currenItem.price.toString()
        holder.description.text=currenItem.description
        Picasso.get().load(currenItem.image).into(holder.image)
    }

    override fun getItemCount(): Int {
        return newListFoodMenu.size
    }
}