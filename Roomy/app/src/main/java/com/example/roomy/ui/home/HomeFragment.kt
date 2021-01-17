package com.example.roomy.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomy.R
import com.example.roomy.custom.AdapterItemClickListener
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

        //Get reference to view models
        val homeViewModel : HomeViewModel by viewModels()
        binding.homeViewModel = homeViewModel





        //START BILLS SECTION
        //layout manager to specify number of columns for grid view
        binding.billsGrid.layoutManager = GridLayoutManager( activity, 4 )

        //set adapter
        val billsAdapter : BillsGridAdapter = BillsGridAdapter()
        binding.billsGrid.adapter = billsAdapter

        binding.billsGrid.addOnItemTouchListener(
            AdapterItemClickListener(
                context,
                binding.billsGrid,
                object : AdapterItemClickListener.OnItemClickListener{
                    override fun onItemClick(view: View?, position: Int) {
                        Timber.v( "gridBills; onItemClick + " + position )

                        homeViewModel.bills.value?.get(position)?.billName?.let { billName ->
                            binding.root.findNavController()
                                .navigate(HomeFragmentDirections.actionNavigationHomeToBillDetailFragment( billName ))
                        }
                    }

                    override fun onLongItemClick(view: View?, position: Int) {
                        Timber.v( "gridBills; onLongItemClick")
                        onItemClick( view, position )
                    }
                }
            )
        )
        //END BILLS SECTION





        //START SHARED SECTION
        //default vertical layout manager
        binding.sharedList.layoutManager = LinearLayoutManager( context )

        //set adapter
        val sharedItemsAdapter : SharedItemsAdapter = SharedItemsAdapter()
        binding.sharedList.adapter = sharedItemsAdapter


        //END SHARED SECTION





        //START VIEW MODEL

        //START Fragment Home set List Adapter
        //observe the bills object and set the initial bill list
        homeViewModel.bills.observe(viewLifecycleOwner, Observer {
            it?.let{
                billsAdapter.submitList(it)
            }
        })

        //observe the sharedItem object and set the initial sharedItem list
        homeViewModel.sharedItem.observe(viewLifecycleOwner, Observer {
            it?.let{
                sharedItemsAdapter.submitList(it)
            }
        })
        //END Fragment Home set List Adapter


        //START ADD ITEMS //action_navigation_home_to_addItemFragment
        //listener for the button to add bills
        homeViewModel.eventAddBill.observe(viewLifecycleOwner, Observer { eventAddBill ->
            if( eventAddBill ){
                findNavController().navigate( HomeFragmentDirections.actionNavigationHomeToAddItemFragment( "bill" ) )
                homeViewModel.onAddBillComplete()
            }
        })

        //listener for the button to view all chores
        homeViewModel.eventAddSharedItem.observe(viewLifecycleOwner, Observer { eventAddSharedItem ->
            if( eventAddSharedItem ){
                findNavController().navigate( HomeFragmentDirections.actionNavigationHomeToAddItemFragment( "shared" ) )
                homeViewModel.onAddSharedItemCompleted()
            }
        })
        //END ADD ITEMS


        //START Chore Handling
        //listener for the button to view all chores
        homeViewModel.eventAllChores.observe(viewLifecycleOwner, Observer { eventAllChores ->
            if( eventAllChores ){
                findNavController().navigate( HomeFragmentDirections.actionNavigationHomeToChoreDetailFragment() )
                homeViewModel.onAllChoresComplete()
            }
        })

        //listener for the button to mark chore completed
        var choreCompleted = false;
        homeViewModel.eventChoreCompleted.observe(viewLifecycleOwner, Observer { eventChoreCompleted ->

            if( eventChoreCompleted ){

                if( !choreCompleted ) {
                    choreCompleted = true
                    binding.weeklyChoreMarkCompleted.text = "COMPLETED: 10/9"

                    if (context != null) {
                        binding.weeklyChoreMarkCompleted.setBackgroundColor(
                            ContextCompat.getColor(
                                context as Context,
                                R.color.colorBackground
                            )
                        )
                    }
                } else {
                    choreCompleted = false
                    binding.weeklyChoreMarkCompleted.text  = "MARK COMPLETED"

                    if (context != null) {
                        binding.weeklyChoreMarkCompleted.setBackgroundColor(
                            ContextCompat.getColor(
                                context as Context,
                                R.color.fab_light
                            )
                        )
                    }
                }

                homeViewModel.onChoreButtonChangeCompleted()
            }
        })
        //END Chore Handling


        //END VIEW MODEL




        return binding.root
    }
}