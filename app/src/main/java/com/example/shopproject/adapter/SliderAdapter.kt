package com.example.shopproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shopproject.Model.SliderModel
import com.example.shopproject.R

class SliderAdapter(var data: List<SliderModel>, var context: Context): RecyclerView.Adapter<SliderAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        var imageView: ImageView = itemView.findViewById(R.id.imageSlide)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflate = LayoutInflater.from(parent.context).inflate(R.layout.slider_item_container, parent, false)
        return ViewHolder(inflate)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = data[position]
        Glide.with(context)
            .load(item.url)
            .into(holder.imageView)
    }
}