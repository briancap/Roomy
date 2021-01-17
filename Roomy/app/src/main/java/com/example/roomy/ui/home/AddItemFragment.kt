package com.example.roomy.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.roomy.R
import com.example.roomy.databinding.FragmentAddItemBinding
import com.example.roomy.databinding.FragmentBillDetailBinding
import timber.log.Timber

class AddItemFragment : Fragment() {

    private lateinit var binding: FragmentAddItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        Timber.e("onCreate")

        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_add_item, container, false )

        val args = AddItemFragmentArgs.fromBundle(requireArguments())
        Timber.e("itemName = ${args.itemName}")

        return binding.root
    }

}