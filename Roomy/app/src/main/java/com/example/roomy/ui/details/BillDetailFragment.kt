package com.example.roomy.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.roomy.R
import com.example.roomy.databinding.FragmentBillDetailBinding
import timber.log.Timber

class BillDetailFragment : Fragment() {

    private lateinit var binding: FragmentBillDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreate(savedInstanceState)
        Timber.e("onCreate")

        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_bill_detail, container, false )

        val args = BillDetailFragmentArgs.fromBundle(requireArguments())
        Timber.e("billName = ${args.billName}")

        return binding.root
    }

}