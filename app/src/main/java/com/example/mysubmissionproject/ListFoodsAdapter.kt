package com.example.mysubmissionproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListFoodsAdapter(private val listFoods: ArrayList<Foods>): RecyclerView.Adapter<ListFoodsAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById((R.id.tv_item_name))
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_foods, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listFoods.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listFoods[position]
        holder.tvName.text = name
        holder.tvDescription.text = description
        holder.imgPhoto.setImageResource(photo)

        holder.itemView.setOnClickListener {
            val intentDetail  =Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_foods", listFoods[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

}