package com.example.grab.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.grab.Model.Menus
import com.example.grab.R

class Adapter(private val newList: ArrayList<Menus>):RecyclerView.Adapter<Adapter.MyViewHolder>(){

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val foodname:TextView=itemView.findViewById(R.id.foodname)
        val price:TextView=itemView.findViewById(R.id.price)
        val bttMenus: ImageButton =itemView.findViewById(R.id.bttMenu)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.recycle_list_menu_main,parent,false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currenItem=newList[position]
        holder.foodname.text=currenItem.namefood
        holder.price.text=currenItem.price
        holder.bttMenus.setImageResource(currenItem.image)

    }

    override fun getItemCount(): Int {
        return newList.size
    }
}