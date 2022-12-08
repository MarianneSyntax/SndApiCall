package com.example.sndapicall.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.sndapicall.R

class DogAdapter() : RecyclerView.Adapter<DogAdapter.ItemViewHolder>() {
    private var dataset = listOf<String>()

    inner class ItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val dogImage: ImageView = view.findViewById(R.id.dog_image)
        //val dogCard: CardView = view.findViewById(R.id.dog_card)
        //val dogBreed: TextView = view.findViewById(R.id.dog_breed)
    }

    fun submitList(list: List<String>){
        dataset = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.dog_item,parent,false)
        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item: String = dataset[position]
        holder.dogImage.load(item)

    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}