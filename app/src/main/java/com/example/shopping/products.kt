package com.example.shopping

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.shopping.databinding.ActivityProductsBinding

class products(var list:MutableList<goods>):RecyclerView.Adapter<products.MyHolder>(){

    var onItemClick : ((MainActivity2) -> Unit)? = null

    class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var name = itemView.findViewById<TextView>(R.id.name)
        var cost = itemView.findViewById<TextView>(R.id.cost)
        var img = itemView.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.activity_products,parent,false))
        return view
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var good = list[position]
        holder.cost.text = good.cost
        holder.name.text = good.name
        holder.img.load(good.img){
            placeholder(R.drawable.baseline_circle_24)
            error(R.drawable.baseline_circle_24)
        }

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(MainActivity2())
        }
    }

}