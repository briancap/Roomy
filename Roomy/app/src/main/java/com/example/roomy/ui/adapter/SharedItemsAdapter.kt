package com.example.roomy.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy.SharedItem
import com.example.roomy.databinding.ListItemSharedItemBinding

class SharedItemsAdapter  : ListAdapter<SharedItem, SharedItemsAdapter.ViewHolder>( SharedItemDiffCallback() )  {

    override fun onBindViewHolder(holder: SharedItemsAdapter.ViewHolder, position: Int) {
        val item = getItem( position )
        holder.bind(item)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SharedItemsAdapter.ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder( val binding: ListItemSharedItemBinding) : RecyclerView.ViewHolder( binding.root ) {

        fun bind( item : SharedItem ){
            binding.sharedItem = item
            binding.executePendingBindings()
        }

        companion object{
            fun from( parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from( parent.context )
                val binding = ListItemSharedItemBinding.inflate( layoutInflater, parent, false )

                return ViewHolder( binding )
            }
        }
    }

}

class SharedItemDiffCallback : DiffUtil.ItemCallback<SharedItem>(){
    override fun areItemsTheSame(oldItem: SharedItem, newItem: SharedItem): Boolean {
        return oldItem.sharedItemName == newItem.sharedItemName
    }

    override fun areContentsTheSame(oldItem: SharedItem, newItem: SharedItem): Boolean {
        return oldItem == newItem
    }

}