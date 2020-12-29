package com.example.roomy.ui.home

import android.content.res.Resources
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import com.example.roomy.Bill
import com.example.roomy.R
import com.example.roomy.SharedItem
import com.google.android.material.floatingactionbutton.FloatingActionButton
import timber.log.Timber


@BindingAdapter("billName")
fun TextView.setBillName( bill : Bill){
    bill?.let {
        text = bill.billName
    }
}

@BindingAdapter("sharedItemName")
fun TextView.setSharedItemName( sharedItem : SharedItem){
    sharedItem?.let {
        text = sharedItem.sharedItemName
    }
}


