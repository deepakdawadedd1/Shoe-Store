package com.udacity.nanodegree.shoestore.shoedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.nanodegree.shoestore.MainViewModel
import com.udacity.nanodegree.shoestore.R
import com.udacity.nanodegree.shoestore.databinding.FragmentShoeDetailsBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding
    private val shoeDetailViewModel by viewModels<ShoeDetailViewModel>()
    private val mainViewModel by viewModels<MainViewModel>({ requireActivity() })
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        binding.shoeDetailViewModel = shoeDetailViewModel
        binding.lifecycleOwner = this
        shoeDetailViewModel.eventBackToShoeList.observe(viewLifecycleOwner) { back ->
            if (back) {
                findNavController().navigateUp()
                shoeDetailViewModel.navigationDone()
            }
        }
        shoeDetailViewModel.newShoe.observe(viewLifecycleOwner) { shoe ->
            if (shoe != null)
                mainViewModel.addShoe(shoe)
        }
        shoeDetailViewModel
        return binding.root
    }
}