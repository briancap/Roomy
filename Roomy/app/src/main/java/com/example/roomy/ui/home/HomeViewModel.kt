package com.example.roomy.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roomy.Bill
import com.example.roomy.SharedItem
import com.example.roomy.TestData
import timber.log.Timber

class HomeViewModel : ViewModel() {

    var bills = MutableLiveData<List<Bill>>().apply{
        value = TestData.bills
    }

    var sharedItem = MutableLiveData<List<SharedItem>>().apply{
        value = TestData.sharedItems
    }
}