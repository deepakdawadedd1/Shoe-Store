package com.udacity.nanodegree.shoestore.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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
        welcomeViewModel =
            ViewModelProvider(this, welcomeViewModelFactory).get(WelcomeViewModel::class.java)
        welcomeViewModel.email.observe(viewLifecycleOwner) { email ->
            binding.welcomeFragmentUsernameText.text = email
        }
        return binding.root
    }
}