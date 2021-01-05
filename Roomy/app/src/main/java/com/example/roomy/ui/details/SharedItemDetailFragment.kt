package com.example.roomy.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.roomy.R
import com.example.roomy.databinding.FragmentBillDetailBinding
import com.example.roomy.databinding.FragmentChoreDetailBinding
import com.example.roomy.databinding.FragmentSharedItemDetailBinding
import timber.log.Timber

class SharedItemDetailFragment : Fragment() {


    private lateinit var binding: FragmentSharedItemDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        Timber.e("onCreate")

        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_shared_item_detail, container, false )



        return binding.root
    }

}