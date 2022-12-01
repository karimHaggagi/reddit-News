package com.karimhaggagi.grandtask.presentation.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.karimhaggagi.grandtask.data.data_source.local.DatabaseNews
import com.karimhaggagi.grandtask.databinding.NewsItemBinding

class NewsListAdapter(private val onNewsItemClick: (DatabaseNews) -> Unit) :
    ListAdapter<DatabaseNews, NewsListAdapter.NewsListViewHolder>(DiffUtilCallBacks) {

    inner class NewsListViewHolder(private val binding: NewsItemBinding) :
        ViewHolder(binding.root) {
        fun bind(item: DatabaseNews) {
            if (item.thumbnail_url.isNotEmpty()) {
                binding.imageView.visibility = View.VISIBLE
                val ratio = item.thumbnail_width / item.thumbnail_height

                val layoutParams = binding.imageView.layoutParams as ConstraintLayout.LayoutParams
                layoutParams.dimensionRatio = ratio.toString()
                binding.imageView.layoutParams = layoutParams

            } else {
                binding.imageView.visibility = View.GONE
            }

            binding.model = item

            binding.root.setOnClickListener {
                onNewsItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        return NewsListViewHolder(
            NewsItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    companion object DiffUtilCallBacks : DiffUtil.ItemCallback<DatabaseNews>() {
        override fun areItemsTheSame(oldItem: DatabaseNews, newItem: DatabaseNews): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: DatabaseNews, newItem: DatabaseNews): Boolean {
            return oldItem == newItem
        }

    }
}