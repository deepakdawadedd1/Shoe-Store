package com.udacity.nanodegree.shoestore.shoelist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.nanodegree.shoestore.R
import com.udacity.nanodegree.shoestore.databinding.FragmentShoeListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.shoeListFragmentToShoeDetails.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListToShoeDetails())
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.onboarding_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.logout_menu_item) {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListToLogin())
            true
        } else super.onOptionsItemSelected(item)
    }
}