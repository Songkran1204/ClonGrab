package com.example.grab.Adapter

import android.graphics.Insets.add
import android.media.Image
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import com.example.grab.Model.CoinsItem
import com.example.grab.Model.FoodMenuPage
import com.example.grab.R
import com.squareup.picasso.Picasso

class AdapterCoin (private val newList:ArrayList<CoinsItem>):
RecyclerView.Adapter<AdapterCoin.MyViewHolder>(){
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val coinId: TextView =itemView.findViewById(R.id.coin_id)
        val coinPrice: TextView =itemView.findViewById(R.id.coin_price)
        val coinName: TextView =itemView.findViewById(R.id.coin_name)
        val coinIcon: ImageView =itemView.findViewById(R.id.tvIconCoin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.recycle_coin,parent,false)
        return AdapterCoin.MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currenItem=newList[position]
        holder.coinId.text= currenItem.id.toString()
        holder.coinPrice.text=currenItem.price
        holder.coinName.text=currenItem.name

        holder.coinIcon.loadSvg(currenItem.iconUrl!!)
    }

    override fun getItemCount(): Int {
       return newList.size
    }
    fun ImageView.loadSvg(url: String) {
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry { add(SvgDecoder(this@loadSvg.context)) }
            .build()

        val request = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(0)
            .data(url)
            .target(this)
            .build()

        imageLoader.enqueue(request)
    }
}
