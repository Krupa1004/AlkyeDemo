package com.example.alkyedemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyedemo.R
import com.example.alkyedemo.databinding.ItemFeaturedArticleBinding
import com.example.alkyedemo.model.Item

class FeaturedArticleAdapter(private val items: List<Item>, private val onClick: () -> Unit) : RecyclerView.Adapter<FeaturedArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemFeaturedArticleBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_featured_article, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: ItemFeaturedArticleBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Item) {
            binding.root.setOnClickListener {
                onClick.invoke()
            }
            binding.dateTextView.text = data.date
            binding.descriptionTextView.text = data.carDesc
        }
    }
}
