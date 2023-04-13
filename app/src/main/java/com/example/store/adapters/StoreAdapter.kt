package com.example.store.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.store.R
import com.example.store.models.StoreModel

class StoreAdapter(private val dataList: List<StoreModel>) :
    RecyclerView.Adapter<StoreAdapter.ViewHolder>() {
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val title: TextView = itemView.findViewById(R.id.txt_title)
        val price: TextView = itemView.findViewById(R.id.txt_price)
        val count: TextView = itemView.findViewById(R.id.txt_rating)
        val image: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.title.text = data.title
        holder.price.text = data.price.toString()
        holder.count.text = data.rating.count.toString()
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

