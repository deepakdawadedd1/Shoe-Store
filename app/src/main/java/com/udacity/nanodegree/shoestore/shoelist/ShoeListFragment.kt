package com.udacity.nanodegree.shoestore.shoelist

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.nanodegree.shoestore.MainViewModel
import com.udacity.nanodegree.shoestore.R
import com.udacity.nanodegree.shoestore.Shoe
import com.udacity.nanodegree.shoestore.databinding.FragmentShoeListBinding
import com.udacity.nanodegree.shoestore.databinding.LayoutShoeListBinding

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val mainViewModel by viewModels<MainViewModel>({ requireActivity() })
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.shoeListFragmentToShoeDetails.setOnClickListener {
            findNavController().navigate(ShoeListFragmentDirections.actionShoeListToShoeDetails())
        }
        mainViewModel.shoeList.observe(viewLifecycleOwner) { shoes ->
            shoes.forEach { shoe ->
                binding.linearLayout.addView(getChild(shoe))
            }
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun getChild(shoe: Shoe): View {
        val layout = LayoutShoeListBinding.inflate(layoutInflater)
        layout.shoeName.text = getString(R.string.shoe_name_format, shoe.name)
        layout.shoeCompany.text = getString(R.string.shoe_company_format, shoe.company)
        layout.shoeSize.text = getString(R.string.shoe_size_format, shoe.size.toString())
        layout.description.text = shoe.description
        return layout.root
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