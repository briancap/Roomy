package com.example.roomy.ui.home

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy.Bill
import com.example.roomy.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import timber.log.Timber
import java.nio.file.Files.size

class HomeBillsAdapter : ListAdapter<Bill, HomeBillsAdapter.ViewHolder>( BillDiffCallback() ) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem( position )
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var gridItemFab: FloatingActionButton = view.findViewById(R.id.grid_item_fab)
        var gridItemFabLabel: TextView = view.findViewById(R.id.grid_item_fab_label)

        fun bind(item: Bill) {
            val res = itemView.context.resources

            gridItemFabLabel.text = item.billName

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.grid_item_fab, parent, false)

                return ViewHolder(view)
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