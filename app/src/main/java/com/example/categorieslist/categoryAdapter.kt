package com.example.categorieslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class categoryAdapter(private val objects:ArrayList<Entrie>,
                      private val listener:OnItemClickListener)
                     :RecyclerView.Adapter<categoryAdapter.categoryViewHolder>() {


    interface OnItemClickListener {
        fun onItemClick(position: Int) {}

    }

    class categoryViewHolder(val view:View):RecyclerView.ViewHolder(view) {


            fun bind (category:Entrie){
                view.findViewById<TextView>(R.id.textView).text = category.Category
            }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): categoryViewHolder {
        val inflater=LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return categoryViewHolder(inflater)

    }

    override fun onBindViewHolder(holder: categoryViewHolder, position: Int) {
        val item= objects[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { this.listener.onItemClick(position) }
    }

    override fun getItemCount(): Int {
        return objects.size
    }




    }


