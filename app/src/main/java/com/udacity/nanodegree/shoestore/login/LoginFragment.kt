package com.udacity.nanodegree.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udacity.nanodegree.shoestore.R
import com.udacity.nanodegree.shoestore.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val loginViewModel by viewModels<LoginViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = this
        loginViewModel.eventLoginComplete.observe(viewLifecycleOwner) { hasLogged ->
            if (hasLogged) {
                navigateToOnBoarding()
                loginViewModel.loginComplete()
            }
        }
        return binding.root
    }

    private fun navigateToOnBoarding() {
        val navDirections =
            LoginFragmentDirections.actionLoginToWelcome(loginViewModel.emailField.value ?: "")
        findNavController().navigate(navDirections)
    }

}