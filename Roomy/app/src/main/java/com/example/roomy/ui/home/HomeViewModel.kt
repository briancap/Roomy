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


    //view all weekly chores
    private val _eventAllChores = MutableLiveData<Boolean>()
    val eventAllChores: LiveData<Boolean>
        get() = _eventAllChores

    fun onAllChores(){
        _eventAllChores.value = true

    }

    fun onAllChoresComplete(){
        _eventAllChores.value = false
    }


    //mark the current chore completed
    private val _eventChoreCompleted = MutableLiveData<Boolean>()
    val eventChoreCompleted: LiveData<Boolean>
        get() = _eventChoreCompleted

    fun onChoreMarkCompleted(){
        _eventChoreCompleted.value = true
    }

    fun onChoreButtonChangeCompleted(){
        _eventChoreCompleted.value = false
    }


    //add a shared item
    private val _eventAddSharedItem = MutableLiveData<Boolean>()
    val eventAddSharedItem: LiveData<Boolean>
        get() = _eventAddSharedItem

    fun onAddSharedItem(){
        _eventAddSharedItem.value = true
    }

    fun onAddSharedItemCompleted(){
        _eventAddSharedItem.value = false
    }
}