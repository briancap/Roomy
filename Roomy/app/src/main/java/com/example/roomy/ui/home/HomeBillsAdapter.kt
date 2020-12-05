package com.example.roomy.ui.home

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomy.Bill
import com.example.roomy.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import timber.log.Timber

class HomeBillsAdapter : RecyclerView.Adapter<HomeBillsAdapter.ViewHolder>() {

    var data =  listOf<Bill>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
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