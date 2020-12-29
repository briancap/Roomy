package com.example.roomy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TestData {

    companion object{
        val bills : List<Bill> = listOf(
            Bill("Rent")
            , Bill("Internet")
            , Bill("Electric")
            , Bill("Gas")
        )

        val sharedItems : List<SharedItem> = listOf(
            SharedItem("Olive Oil")
            , SharedItem("Dish Soap")
            , SharedItem("Sponges")
            , SharedItem("Laundry Detergent")
        )
    }

}