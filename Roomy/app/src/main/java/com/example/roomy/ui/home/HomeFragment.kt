package com.example.roomy.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.roomy.Bill
import com.example.roomy.R
import com.example.roomy.TestData
import com.example.roomy.databinding.FragmentHomeBinding
import timber.log.Timber

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        //Get a reference to the binding object
        val binding: FragmentHomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_home, container, false)

        //layout manager to specify number of columns for grid view
        binding.homeGridBills.layoutManager = GridLayoutManager( activity, 4 )

        //set adapter
        val gridAdapter : HomeBillsAdapter = HomeBillsAdapter()
        binding.homeGridBills.adapter = gridAdapter


        //Get reference to view model
        val homeViewModel : HomeViewModel by viewModels()

        //observe the bills object and set the initial bill list
        homeViewModel.bills.observe(viewLifecycleOwner, Observer {
            it?.let{
                gridAdapter.submitList(it)
            }
        })


        return binding.root
    }
}