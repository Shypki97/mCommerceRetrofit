package com.e.mcommerceretrofit.commercelist

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.e.mcommerceretrofit.model.Commerce

class CommerceAdapter: ListAdapter<Commerce, RecyclerView.ViewHolder>(COMMERCE_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CommerceViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val repoItem = getItem(position)
        if(repoItem != null){
            (holder as CommerceViewHolder).bind(repoItem)
        }
    }

    companion object{
        private val COMMERCE_COMPARATOR = object: DiffUtil.ItemCallback<Commerce>(){
            override fun areItemsTheSame(oldItem: Commerce, newItem: Commerce): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Commerce, newItem: Commerce): Boolean {
                return oldItem == newItem
            }

        }
    }

}
