package com.example.proteamfantasy11rj.pradctionapp.Fragment1

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.proteamfantasy11rj.pradctionapp.R
import com.google.firebase.database.core.Context

class MyAdapter(var newArrayList: ArrayList<News>,var context:Activity):
    RecyclerView.Adapter< MyAdapter.MyViewholder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewholder {
   val itemView=LayoutInflater.from(parent.context).inflate(R.layout.each_item,parent,false)
        return MyViewholder(itemView)

    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewholder, position: Int) {
val currentItem=newArrayList[position]
        holder.htitle.text=currentItem.newsHeading
        holder.Iimage.setImageResource(currentItem.newsImage)
    }

    override fun getItemCount(): Int {
return newArrayList.size
    }

    class MyViewholder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val htitle=itemView.findViewById<TextView>(R.id.textAdapter)
        val Iimage=itemView.findViewById<ImageView>(R.id.imageApter)

    }
}