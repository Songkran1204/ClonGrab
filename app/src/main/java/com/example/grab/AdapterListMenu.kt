package com.example.grab

import android.accounts.AccountManager.get
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class AdapterListMenu(private val newList:ArrayList<Page2List>):
    RecyclerView.Adapter<AdapterListMenu.MyViewHolder>() {
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val foodname: TextView =itemView.findViewById(R.id.textView6)
        val price: TextView =itemView.findViewById(R.id.textView5)
        val description: TextView =itemView.findViewById(R.id.textView4)
        val image: ImageView =itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterListMenu.MyViewHolder {

        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.page2listmenu,parent,false)
        return AdapterListMenu.MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currenItem=newList[position]
        holder.foodname.text=currenItem.namefood
        holder.price.text= currenItem.price.toString()
        holder.description.text=currenItem.description
        Log.e("Image",currenItem.image)
        Picasso.get().load(currenItem.image).into(holder.image)

    }

    override fun getItemCount(): Int {
        return newList.size
    }
}