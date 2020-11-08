package com.udacity.nanodegree.shoestore.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.nanodegree.shoestore.R
import com.udacity.nanodegree.shoestore.databinding.FragmentShoeDetailsBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding
    private lateinit var shoeDetailViewModel: ShoeDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        shoeDetailViewModel = ViewModelProvider(this).get(ShoeDetailViewModel::class.java)
        binding.shoeDetailViewModel = shoeDetailViewModel
        binding.lifecycleOwner = this
        shoeDetailViewModel.eventBackToShoeList.observe(viewLifecycleOwner) { back ->
            if (back) {
                findNavController().navigateUp()
                shoeDetailViewModel.navigationDone()
            }

        }
        return binding.root
    }
}