package com.example.roomy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TestData {

    companion object{
        val bills : List<Bill> = listOf(
            Bill("Rent"), Bill("Internet"), Bill("Electric"), Bill("Gas")
        )

        val bills2 : List<Bill> = listOf(
            Bill("Rent2"), Bill("Internet2"), Bill("Electric2"), Bill("Gas2")
        )
    }

}