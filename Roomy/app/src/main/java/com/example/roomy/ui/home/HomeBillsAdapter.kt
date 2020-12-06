package com.example.roomy.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy.Bill
import com.example.roomy.databinding.GridItemFabBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeBillsAdapter : ListAdapter<Bill, HomeBillsAdapter.ViewHolder>( BillDiffCallback() ) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem( position )
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    class ViewHolder( val binding : GridItemFabBinding ) : RecyclerView.ViewHolder( binding.root ) {

        fun bind(item: Bill) {
            //resources will set drawable when fabs have unique drawables for each bill
            val res = itemView.context.resources
            binding.gridItemFabLabel.text = item.billName
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = GridItemFabBinding.inflate( layoutInflater, parent, false )

                return ViewHolder( binding )
            }
        }
    }

}

class BillDiffCallback : DiffUtil.ItemCallback<Bill>(){
    override fun areItemsTheSame(oldItem: Bill, newItem: Bill): Boolean {
        return oldItem.billName == newItem.billName
    }

    override fun areContentsTheSame(oldItem: Bill, newItem: Bill): Boolean {
        return oldItem == newItem
    }

}