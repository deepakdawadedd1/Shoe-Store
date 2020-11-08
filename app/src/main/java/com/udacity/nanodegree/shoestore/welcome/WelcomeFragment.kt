package com.udacity.nanodegree.shoestore.welcome

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.udacity.nanodegree.shoestore.R
import com.udacity.nanodegree.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    private lateinit var welcomeViewModelFactory: WelcomeViewModelFactory
    private lateinit var welcomeViewModel: WelcomeViewModel
    private val args by navArgs<WelcomeFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        welcomeViewModelFactory = WelcomeViewModelFactory(args.email)
        welcomeViewModel = ViewModelProvider(this, welcomeViewModelFactory)
            .get(WelcomeViewModel::class.java)
        binding.welcomeViewModel = welcomeViewModel
        binding.lifecycleOwner = this

        welcomeViewModel.eventInstruction.observe(viewLifecycleOwner) { canNavigate ->
            if (canNavigate) {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeToInstructions())
                welcomeViewModel.navigateToInstructionsComplete()
            }
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
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeToLogin())
            true
        } else super.onOptionsItemSelected(item)
    }
}